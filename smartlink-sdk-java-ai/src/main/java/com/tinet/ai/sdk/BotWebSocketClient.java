package com.tinet.ai.sdk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinet.ai.sdk.handler.AfterConnectHandler;
import com.tinet.ai.sdk.handler.ChatResponseCallback;
import com.tinet.ai.sdk.handler.TibotSessionHandler;
import com.tinet.ai.sdk.request.ChatRequest;
import com.tinet.ai.sdk.response.ChatResponse;
import com.tinet.ai.sdk.response.Pong;
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
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

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
 * @author houfc
 * @date 2019/03/13
 */
public class BotWebSocketClient implements DisposableBean {

    private static Logger logger = LoggerFactory.getLogger(BotWebSocketClient.class);

    private WebSocketStompClient stompClient = new WebSocketStompClient(new StandardWebSocketClient());

    /**
     * SDK 维护 clientSession，不需要 CC 再自己维护 uniqueId -> clientSession
     */
    private Map<String, ClientSession> clientSessionMap = new ConcurrentHashMap<>();

    /**
     * 每个 uniqueId 对应的订阅 uniqueId -> subscription
     */
    private Map<String, StompSession.Subscription> subscriptionMap = new ConcurrentHashMap<>();

    /**
     * SDK 连接到 Tibot 生成的 session，复用一个 WebSocket 连接
     */
    private StompSession session;

    private TibotWebSocketClientConfiguration configuration;

    private SignatureComposer composer = new SignatureComposer();

    private Signer signer = Signer.getSigner();

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * WebSocket
     */
    private String url;

    private ChatResponseCallback callback;

    private AfterConnectHandler afterConnect;

    /**
     * 连接失败计数器
     */
    private AtomicInteger unConnectCount = new AtomicInteger(0);

    /**
     * 最大失败次数
     */
    private static final int MAX_FAILED_NUM = 6;

    public BotWebSocketClient(@NonNull TibotWebSocketClientConfiguration configuration,
                              ChatResponseCallback callback, AfterConnectHandler afterConnect) {
        this.configuration = configuration;
        this.stompClient.setMessageConverter(new MappingJackson2MessageConverter());
        this.url = "ws://" + configuration.getHost() + "/tibot";
        this.callback = callback;
        this.afterConnect = afterConnect;
        connect();
    }

    /**
     * 建立与 Tibot WebSocket 连接，
     */
    public void connect() {

        logger.info("[TBot]connect to server ...");

        TibotSessionHandler sessionHandler = new TibotSessionHandler(this);

        // 定义并设置用于心跳检测的调度器
//        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
//        taskScheduler.initialize();
//        stompClient.setTaskScheduler(taskScheduler);

        try {

            session = stompClient.connect(url, getWebSocketHttpHeaders(),
                    new StompHeaders(), sessionHandler).get();

            unConnectCount.set(0);

            // 心跳检测
            startHeartbeat();

            if (!clientSessionMap.isEmpty()) {
                // 重连成功
                if (afterConnect != null) {
                    // 用户自己处理session
                    logger.info("[TBot] reConnected, handler old session... ");
                    afterConnect.handlerClientSessionAfterConnect(clientSessionMap);
                    clientSessionMap.clear();
                } else {
                    // 客户端自动进行重新订阅
                    for (Map.Entry<String, ClientSession> sessionEntry : clientSessionMap.entrySet()) {
                        logger.info("[TBot] reConnected, login, current loginId :{}", sessionEntry.getKey());
                        this.login(sessionEntry.getValue());
                    }
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            logger.error("[TBot] Websocket connect error! ", e);
        }
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
     * 进入机器人结点时，将该机器人进行订阅
     *
     * @param clientSession ClientSession
     */
    public void login(ClientSession clientSession) {
        StompHeaders headers = new StompHeaders();

        String loginId = clientSession.getLoginId();
        String uniqueId = clientSession.getUniqueId();
        loginId = Objects.isNull(loginId) ? uniqueId : loginId;

        logger.debug("[TBot] login uniqueId {} loginId {}", uniqueId, loginId);

        headers.setDestination("/chat/response/" + loginId);

        headers.set("userId", String.valueOf(clientSession.getUserId()));
        if (!StringUtils.isEmpty(loginId)) {
            headers.set("loginId", loginId);
        }
        headers.set("uniqueId", uniqueId);
        headers.set("clientId", clientSession.getClientId());
        headers.set("botId", clientSession.getBotId());
        try {
            headers.set("params", objectMapper.writeValueAsString(clientSession.getParams()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        if (session == null || !session.isConnected()) {
            connect();
        }
        StompSession.Subscription subscription = session.subscribe(headers,
                new StompFrameHandler() {
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

        // 订阅成功时加入 clientSession 及 subscriptionMap
        clientSessionMap.put(loginId, clientSession);
        subscriptionMap.put(loginId, subscription);

    }

    private ThreadFactory namedFactory = new CustomizableThreadFactory("TBot-pool-");
    private ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1, namedFactory);
    /**
     * 心跳任务关闭
     */
    private ScheduledFuture<?> scheduledFuture;
    /**
     * 启动心跳检测
     */
    private void startHeartbeat() {

        StompHeaders headers = new StompHeaders();
        headers.setDestination("/topic/pong");

        if (session == null || !session.isConnected()) {
            connect();
        }

        session.subscribe(headers,
                new StompFrameHandler() {
                    @Override
                    @NonNull
                    public Type getPayloadType(@NonNull StompHeaders headers) {
                        return Pong.class;
                    }

                    @Override
                    public void handleFrame(@NonNull StompHeaders headers, Object pong) {
                        if (pong instanceof Pong) {
                            int pingCount = unConnectCount.decrementAndGet();
                            logger.info("[TBot] received pong {}, pingCount:{}", ((Pong) pong).getRequestId(), pingCount);
                        }
                    }
                }
        );
        this.scheduledFuture =
                scheduledExecutorService.scheduleWithFixedDelay(new HeartBeatTask(), 0, 15, TimeUnit.SECONDS);
    }

    /**
     * 自定义心跳任务
     */
    class HeartBeatTask implements Runnable {
        @Override
        public void run() {
            try {
                session.send("/app/ping", UUID.randomUUID().toString());
                int pingCount = unConnectCount.incrementAndGet();
                judgeReConnect(pingCount);
                logger.debug("[TBot] ping currentPingCount:{}", pingCount);
            } catch (Exception e) {
                int pingCount = unConnectCount.incrementAndGet();
                judgeReConnect(pingCount);
                logger.error("[TBot] send ping exception pingCount:{}", pingCount);
            }
        }

        /**
         * 判断是否重连
         *
         * @param pingCount 没收到pong的次数
         */
        private void judgeReConnect(int pingCount) {
            if (pingCount % MAX_FAILED_NUM == 0) {
                logger.warn("[TBot] reConnect... timestamp: {} currentPingCount:{}", System.currentTimeMillis(), pingCount);
                session.disconnect();
                scheduledFuture.cancel(true);
                connect();
            }
        }
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
     * 当退出机器人结点时，取消请订阅，当 client 收到 END action时， client 本身也会调用 logout 方法
     *
     * @param uniqueId Cdr 中的 uniqueId
     * @param loginId  本次订阅唯一标识
     */
    public void logout(String uniqueId, String loginId) {
        loginId = Objects.isNull(loginId) ? uniqueId : loginId;

        StompSession.Subscription subscription = subscriptionMap.get(loginId);
        if (subscription != null) {
            StompHeaders headers = new StompHeaders();
            headers.set("uniqueId", uniqueId);
            if (!StringUtils.isEmpty(loginId)) {
                headers.set("loginId", loginId);
            }
            subscription.unsubscribe(headers);
            clientSessionMap.remove(loginId);
            subscriptionMap.remove(loginId);
        }
    }

    public void chat(ChatRequest chatRequest) {
        logger.debug("[TBot] ChatRequest {}, timestamp is {}", chatRequest, System.currentTimeMillis());
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

    public boolean isConnected() {
        if (session == null || !session.isConnected()) {
            return false;
        }
        return true;
    }

    public int activeSessionCount() {
        return clientSessionMap.size();
    }

    @Override
    public void destroy() throws Exception {
        clientSessionMap.clear();
        subscriptionMap.clear();
        scheduledExecutorService.shutdown();
    }
}
