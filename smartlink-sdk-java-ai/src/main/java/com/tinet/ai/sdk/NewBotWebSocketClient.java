package com.tinet.ai.sdk;

import com.tinet.ai.sdk.handler.BotSessionHandler;
import com.tinet.ai.sdk.handler.ChatResponseCallback;
import com.tinet.ai.sdk.model.enums.PlatformEnum;
import com.tinet.ai.sdk.request.ChatRequest;
import com.tinet.ai.sdk.response.ChatResponse;
import com.tinet.smartlink.sdk.core.auth.SignatureComposer;
import com.tinet.smartlink.sdk.core.auth.Signer;
import com.tinet.smartlink.sdk.core.utils.RequestConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.lang.NonNull;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 * <pre>
 * CC call center <br/>
 *
 * 1. SDK 在启动时通过调用 client.connect() 建立与 TiBot 的 WebSocket 连接 <br/>
 *
 * 2. 进入机器人节点时（有一个机器人通话），调用 client.login() 订阅topic /chat/response/{uniqueId}，
 *  并传递botId、clientId、userId、params等参数，SDK中维护一个Map结构：uniqueId -> ClientSession <br/>
 *
 * 3. TiBot通过SessionSubscribeEvent获取uniqueId、botId、clientId、userId、params等，
 *  构建UserSession，并用map结构存储uniqueId和UserSession的对应关系
 *
 *  当客户开说话时（ASR 开始进行识别时）调用 client.sayBegin() 通知 Tibot 用户开始说话了， <br/>
 *
 *  当 ASR 识别完成时，调用 client.chat() 将用户说的话发送给 Tibot <br/>
 *
 *  当录音播放完后，调用 client.playEnd() 通知 Tibot <br/>
 *
 * 4. 退出机器人节点时，调用 client.logout() 取消订阅topic，TiBot删除UserSession的对应关系，SDK中删除ClientSession <br/>
 *
 * 5. 当断线时，
 *     方案1：TiBot通过SessionDisconnectEvent获取sessionId，并获取对应的订阅列表，然后将这些订阅关联的UserSession删除
 *     方案2：根据UnsubscribeEnvent，删除关联的UserSession删除
 * 6. 当断线重连时，CC从SDK获取所有的ClientSession，重新订阅
 *
 * 7. 心跳检测 <br/>
 * </pre>
 *
 * @author huwk
 * @date 2021/05/14
 */
public class NewBotWebSocketClient implements DisposableBean {

    private static Logger logger = LoggerFactory.getLogger(NewBotWebSocketClient.class);

    private WebSocketStompClient stompClient = new WebSocketStompClient(new StandardWebSocketClient());

    /**
     * SDK 连接到 Tibot 生成的 session，复用一个 WebSocket 连接
     */
    private StompSession session;

    private StompSession.Subscription subscription;

    private StompHeaders subHeaders;

    private TibotWebSocketClientConfiguration configuration;

    private SignatureComposer composer = new SignatureComposer();

    private Signer signer = Signer.getSigner();

    /**
     * websocket连接地址
     */
    private String url;

    private ChatResponseCallback callback;

    /**
     * 平台标识，默认为客户端服务器名称
     */
    private PlatformEnum platform;

    /**
     * 平台客户端主机名称
     */
    private String clientHostName;

    /**
     * 客户端唯一标识
     */
    public static final String PLATFORM_CLIENT_UUID = "client-" + UUID.randomUUID().toString();

    public NewBotWebSocketClient(@NonNull TibotWebSocketClientConfiguration configuration,
                                 ChatResponseCallback callback) {
        this(configuration, callback, null);
    }

    public NewBotWebSocketClient(@NonNull TibotWebSocketClientConfiguration configuration,
                                 ChatResponseCallback callback, PlatformEnum platform) {
        this.configuration = configuration;
        this.stompClient.setMessageConverter(new MappingJackson2MessageConverter());
        this.url = "ws://" + configuration.getHost() + "/tibot";
        this.callback = callback;
        this.platform = platform;
        // 配置定时任务
        configTaskScheduler();
        // 配置主机名称
        this.clientHostName = getClientHostName();
        // 创建连接
        connect();
    }

    /**
     * 配置心跳检测调度器。
     */
    private void configTaskScheduler() {
        // 定义并设置用于心跳检测的调度器
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.initialize();
        stompClient.setTaskScheduler(taskScheduler);
        stompClient.setDefaultHeartbeat(new long[]{10000, 10000});
    }

    /**
     * 获取客户端服务器主机名称
     *
     * @return
     */
    private String getClientHostName() {
        // 获取客户端服务器名称
        String hostName = "unknown-host-";
        try {
            if (platform != null) {
                hostName = platform.getValue() + "-";
            } else {
                hostName = InetAddress.getLocalHost().getHostName() + "-";
            }
        } catch (UnknownHostException e) {
            logger.error("获取客户端主机名称异常", e);
        }
        hostName = hostName + PLATFORM_CLIENT_UUID;

        return hostName;

    }

    /**
     * 建立与 Tibot WebSocket 连接，
     */
    public void connect() {
        connect(false);
    }

    /**
     * 建立与 Tibot WebSocket 连接
     *
     * @param retry 重新连接 true, 第一次连接 false。
     */
    public void connect(boolean retry) {
        // 判断是否连接，防止重复连接和订阅
        if (retry) {
            if (isConnected()) {
                session.disconnect();
            }
            logger.info("[TBot]reconnect to server ...");
        } else {
            logger.info("[TBot]connect to server ...");
        }
        subHeaders = new StompHeaders();
        subHeaders.setDestination("/chat/response/" + PLATFORM_CLIENT_UUID);

        BotSessionHandler sessionHandler = new BotSessionHandler(this);

        try {
            session = stompClient.connect(url, getWebSocketHttpHeaders(),
                    new StompHeaders(), sessionHandler).get();

        } catch (InterruptedException | ExecutionException e) {
            logger.error("[TBot] Websocket connect error! ", e);
        }
    }

    /**
     * 创建订阅(基于客户端ID创建订阅)
     *
     * @param headers
     */
    public void subscribe(StompHeaders headers) {
        logger.info("[TBot] subscribe to server, platformClientId {} clientHostName {} ... ",
                PLATFORM_CLIENT_UUID, clientHostName);
        this.subscription = session.subscribe(headers, new StompFrameHandler() {
            @Override
            @NonNull
            public Type getPayloadType(@NonNull StompHeaders headers) {
                return ChatResponse.class;
            }

            @Override
            public void handleFrame(@NonNull StompHeaders headers, Object payload) {
                if (payload instanceof ChatResponse) {
                    ChatResponse chatResponse = (ChatResponse) payload;
                    logger.debug("uniqueId {} ChatResponse {}, timestamp is {}",
                            chatResponse.getUniqueId(), chatResponse, System.currentTimeMillis());
                    callback.callback(chatResponse);
                }
            }
        });
    }

    /**
     * 生成ws 请求头
     *
     * @return header
     */
    private WebSocketHttpHeaders getWebSocketHttpHeaders() {
        WebSocketHttpHeaders httpHeaders = new WebSocketHttpHeaders();

        // 与鉴权相关的信息
        Map<String, String> queryParams = new HashMap<>(8);
        queryParams.put(RequestConstant.ACCESS_KEY_ID, configuration.getAccessKeyId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        queryParams.put(RequestConstant.TIMESTAMP, sdf.format(new Date()));
        queryParams.put(RequestConstant.EXPIRES, String.valueOf(configuration.getExpires()));

        String stringToSign = composer.getStringToSign("GET", configuration.getHost(), "/tibot", queryParams);
        String signature = signer.signString(stringToSign, configuration.getAccessKeySecret());

        httpHeaders.setAll(queryParams);
        httpHeaders.set(RequestConstant.SIGNATURE, signature);
        return httpHeaders;
    }

    /**
     * 进入机器人结点时，登录会话
     *
     * @param clientSession ClientSession
     */
    public void login(ClientSession clientSession) {

        String loginId = clientSession.getLoginId();
        String uniqueId = clientSession.getUniqueId();
        loginId = Objects.isNull(loginId) ? uniqueId : loginId;

        // 登录时标识客户端服务器的唯一标识和名称
        clientSession.setPlatformClientId(PLATFORM_CLIENT_UUID);
        clientSession.setClientHostName(clientHostName);

        logger.debug("[TBot] login uniqueId {}, loginId {}, platformClientId {}, clientHostName {}",
                uniqueId, loginId, clientSession.getPlatformClientId(),clientSession.getClientHostName());
        // 登录会话，通过
        session.send("/app/login", clientSession);
    }


    /**
     * 通知 Tbot 用户开始说话了
     *
     * @param loginId 本次订阅唯一标识
     */
    public void sayBegin(String loginId) {
        logger.debug("[TBot] sayBegin loginId:{} ", loginId);
        session.send("/app/sayBegin", loginId);
    }

    /**
     * 当退出机器人结点时，清理会话信息
     *
     * @param uniqueId Cdr 中的 uniqueId
     * @param loginId  本次订阅唯一标识
     */
    public void logout(String uniqueId, String loginId) {
        // 清空服务端的会话信息
        loginId = Objects.isNull(loginId) ? uniqueId : loginId;
        session.send("/app/logout", loginId);

    }

    public void chat(ChatRequest chatRequest) {
        logger.debug("[TBot] ChatRequest {}, timestamp is {}", chatRequest, System.currentTimeMillis());
        chatRequest.setPlatformClientId(PLATFORM_CLIENT_UUID);
        session.send("/app/chat", chatRequest);
    }

    /**
     * 通知 Tibot 播放结束
     *
     * @param loginId 本次订阅唯一标识
     */
    public void playEnd(String loginId) {
        logger.debug("[TBot] loginId {} playEnd", loginId);
        session.send("/app/playEnd", loginId);
    }

    /**
     * 退出IVR机器人节点时，关闭与TiBot的WebSocket连接
     */
    public void disconnect() {
        logger.info("disconnect tibot server");
        session.disconnect();
    }

    /**
     * 取消订阅
     *
     * @param loginId
     * @param uniqueId
     */
    public void unsubscribe(String loginId, String uniqueId) {
        logger.info("unSubscribe tibot server");
        loginId = Objects.isNull(loginId) ? uniqueId : loginId;
        if (subscription != null) {
            StompHeaders headers = new StompHeaders();
            headers.set("uniqueId", uniqueId);
            if (!StringUtils.isEmpty(loginId)) {
                headers.set("loginId", loginId);
            }
            subscription.unsubscribe(headers);
        }
    }

    public boolean isConnected() {
        return session != null && session.isConnected();
    }

    public StompHeaders getSubHeaders() {
        return subHeaders;
    }

    @Override
    public void destroy() throws Exception {
        session.disconnect();
    }
}
