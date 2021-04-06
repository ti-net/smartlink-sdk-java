package com.tinet.ai.sdk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinet.ai.sdk.handler.AfterConnectHandler;
import com.tinet.ai.sdk.handler.ChatResponseCallback;
import com.tinet.ai.sdk.handler.TibotSessionHandler;
import com.tinet.ai.sdk.request.ChatHttpRequest;
import com.tinet.ai.sdk.request.ChatRequest;
import com.tinet.ai.sdk.request.LogoutHttpRequest;
import com.tinet.ai.sdk.response.ChatResponse;
import com.tinet.ai.sdk.response.Pong;
import com.tinet.ai.sdk.response.SuccessResponse;
import com.tinet.smartlink.sdk.core.SmartlinkClientConfiguration;
import com.tinet.smartlink.sdk.core.auth.SignatureComposer;
import com.tinet.smartlink.sdk.core.auth.Signer;
import com.tinet.smartlink.sdk.core.exceptions.ClientException;
import com.tinet.smartlink.sdk.core.exceptions.ServerException;
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
 * 1. 进入机器人节点时（有一个机器人通话），调用 client.login() 订阅topic /chat/response/{uniqueId}，
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

    private static final Logger logger = LoggerFactory.getLogger(BotWebSocketClient.class);

    private final WebSocketStompClient stompClient = new WebSocketStompClient(new StandardWebSocketClient());

    /**
     * SDK 维护 clientSession，不需要 CC 再自己维护 uniqueId -> clientSession
     */
    private final Map<String, ClientSession> clientSessionMap = new ConcurrentHashMap<>();

    /**
     * 建立连接后维护 loginId -> StompSession 关系
     */
    private final Map<String, StompSession> sessionMap = new ConcurrentHashMap<>();

    /**
     * 每个 uniqueId 对应的订阅 uniqueId -> subscription
     */
    private final Map<String, StompSession.Subscription> subscriptionMap = new ConcurrentHashMap<>();

    private final TibotWebSocketClientConfiguration configuration;

    private final SignatureComposer composer = new SignatureComposer();

    private final Signer signer = Signer.getSigner();

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * WebSocket
     */
    private final String url;

    private final ChatResponseCallback callback;

    private final AfterConnectHandler afterConnect;

    /**
     * 连接失败计数器
     */
    public static AtomicInteger unConnectCount = new AtomicInteger(0);

    /**
     * 最大失败次数
     */
    private static final int MAX_FAILED_NUM = 3;

    private AIHttpClient httpClient;

    /**
     * 心跳检测
     */
    private final ThreadFactory namedFactory = new CustomizableThreadFactory("TBot-pool-");
    private final ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(500, namedFactory);

    public BotWebSocketClient(@NonNull TibotWebSocketClientConfiguration configuration,
                              ChatResponseCallback callback, AfterConnectHandler afterConnect) {
        this.configuration = configuration;
        this.stompClient.setMessageConverter(new MappingJackson2MessageConverter());
        this.url = "ws://" + configuration.getHost() + "/tibot";
        this.callback = callback;
        this.afterConnect = afterConnect;
        this.httpClient = initHttpClient(configuration);
    }

    private AIHttpClient initHttpClient(TibotWebSocketClientConfiguration configuration) {
        SmartlinkClientConfiguration httpConfiguration = new SmartlinkClientConfiguration();
        httpConfiguration.setAccessKeyId(configuration.getAccessKeyId());
        httpConfiguration.setAccessKeySecret(configuration.getAccessKeySecret());
        httpConfiguration.setHost(configuration.getHost());
        return new AIHttpClient(httpConfiguration);
    }

    /**
     * 建立与 Tibot WebSocket 连接，
     */
    private StompSession connect(String loginId) {

        logger.info("[TBot]connect to server ...");

        StompSession session = sessionMap.get(loginId);
        try {
            if (session != null) {
                return session;
            }

            TibotSessionHandler sessionHandler = new TibotSessionHandler(this);
            session = stompClient.connect(url, getWebSocketHttpHeaders(),
                    new StompHeaders(), sessionHandler).get();
            sessionMap.put(loginId, session);

            subscribePong(session);

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
        return session;
    }

    private void subscribePong(StompSession session) {
        StompHeaders headers = new StompHeaders();
        headers.setDestination("/chat/pong/" + CLIENT_UUID);
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
                            unConnectCount.set(0);
                            logger.info("[TBot] received pong  HOST_UUID:{}", ((Pong) pong).getRequestId());
                        }
                    }
                }
        );
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
     * 进入机器人结点时，调用该方法，与tbot建立WebSocket连接并将该机器人进行订阅
     *
     * @param clientSession ClientSession
     */
    public boolean login(ClientSession clientSession) {
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
            logger.error("[TBot] loginId {} parse params json error, params is: {}", loginId, clientSession.getParams(), e);
        }

        StompSession session = connect(loginId);
        if (session == null) {
            return false;
        }
        // 心跳检测
        startHeartbeat(loginId);
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
                            logger.debug("[TBot] uniqueId {} ChatResponse {}, timestamp is {}",
                                    chatResponse.getUniqueId(), chatResponse, System.currentTimeMillis());
                            List<String> actionList = chatResponse.getAction();
                            if (actionList != null && actionList.size() > 0) {
                                if (actionList.contains("END")) {
                                    logout(chatResponse.getUniqueId(), chatResponse.getLoginId());
                                }
                            }
                            callback.callback(chatResponse);
                        }
                    }
                });

        // 订阅成功时加入 clientSession 及 subscriptionMap
        clientSessionMap.put(loginId, clientSession);
        subscriptionMap.put(loginId, subscription);
        return true;
    }



    /**
     * 启动心跳检测
     */
    private static final String CLIENT_UUID = UUID.randomUUID().toString();

    private void startHeartbeat(String loginId) {
        scheduledExecutorService.scheduleWithFixedDelay(new HeartBeatTask(loginId), 10, 15, TimeUnit.SECONDS);
    }

    /**
     * 自定义心跳任务
     */
    class HeartBeatTask implements Runnable {
        private final String loginId;
        public HeartBeatTask(String loginId) {
            this.loginId = loginId;
        }
        @Override
        public void run() {
            int pingCount = unConnectCount.incrementAndGet();
            try {
                StompSession session = sessionMap.get(loginId);
                judgeReConnect(session, pingCount, loginId);
                if (session != null) {
                    session.send("/app/ping", CLIENT_UUID);
                    logger.debug("[TBot] ping currentPingCount:{}", pingCount);
                } else {
                    logger.error("[TBot] connected failed:{}", pingCount);
                }
            } catch (Exception e) {
                logger.error("[TBot] send ping exception pingCount:{}", pingCount, e);
            }
        }

        /**
         * 判断是否重连
         *
         * @param pingCount 没收到pong的次数
         */
        private void judgeReConnect(StompSession session, int pingCount, String loginId) {
            if (pingCount > 0 && pingCount % MAX_FAILED_NUM == 0) {
                logger.warn("[TBot] reConnect... currentPingCount:{}", pingCount);
                if (session != null && !session.isConnected()) {
                    connect(loginId);
                }
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
        StompSession session = sessionMap.get(loginId);
        if (session != null) {
            session.send("/app/sayBegin", loginId);
        }
    }

    public void logoutWithHttp(String loginId) {
        LogoutHttpRequest logout = new LogoutHttpRequest();
        logout.setLoginId(loginId);
        try {
            httpClient.getResponseModel(logout);
        } catch (ServerException | ClientException e) {
            logger.error("[TBot] logoutWithHttp loginId {} error:", loginId, e);
        }
    }

    /**
     * 当退出机器人结点时，取消请订阅，当 client 收到 END action时， client 本身也会调用 logout 方法
     * 1. 取消订阅
     * 2. 断开连接
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
            disconnect(loginId);
        }
    }

    public void chatWithHttp(ChatRequest chatRequest) {
        ChatHttpRequest httpRequest = new ChatHttpRequest();
        httpRequest.setIntent(chatRequest.getIntent());
        httpRequest.setLoginId(chatRequest.getLoginId());
        httpRequest.setUniqueId(chatRequest.getUniqueId());
        httpRequest.setQuery(chatRequest.getQuery());
        httpRequest.setPlayStatus(chatRequest.getPlayStatus());
        httpRequest.setSentenceId(chatRequest.getSentenceId());
        httpRequest.setType(chatRequest.getType());

        try {
            httpClient.getResponseModel(httpRequest);
        } catch (ServerException | ClientException e) {
            logger.error("[TBot] chatWithHttp loginId {} error:", httpRequest.getLoginId(), e);
        }
    }

    public void chat(ChatRequest chatRequest) {
        logger.debug("[TBot] ChatRequest {}, timestamp is {}", chatRequest, System.currentTimeMillis());
        StompSession session = sessionMap.get(chatRequest.getLoginId());
        if (session != null) {
            session.send("/app/chat", chatRequest);
        } else  {
            logger.warn("[TBot] ChatRequest {}, sdk don`t have loginId: {}", chatRequest, chatRequest.getLoginId());
        }
    }

    /**
     * 通知 Tibot 播放结束
     *
     * @param loginId 本次订阅唯一标识
     */
    public void playEnd(String loginId) {
        logger.debug("[TBot] loginId {} playEnd", loginId);
        StompSession session = sessionMap.get(loginId);
        if (session != null) {
            session.send("/app/playEnd", loginId);
        }
    }

    /**
     * 退出IVR机器人节点时，关闭与TiBot的WebSocket连接
     * @param loginId 唯一标识
     */
    public void disconnect(String loginId) {
        logger.info("disconnect tibot server, uniqueId is {}", loginId);
        StompSession session = sessionMap.get(loginId);
        if (session != null) {
            session.disconnect();
            sessionMap.remove(loginId);
        }
    }

    public int activeSessionCount() {
        return clientSessionMap.size();
    }

    @Override
    @Deprecated
    public void destroy() throws Exception {
        clientSessionMap.clear();
        subscriptionMap.clear();
        scheduledExecutorService.shutdown();
    }
}
