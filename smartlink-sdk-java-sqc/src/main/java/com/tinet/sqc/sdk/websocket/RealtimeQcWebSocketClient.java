package com.tinet.sqc.sdk.websocket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinet.smartlink.sdk.core.auth.SignatureComposer;
import com.tinet.smartlink.sdk.core.auth.Signer;
import com.tinet.smartlink.sdk.core.utils.RequestConstant;
import com.tinet.sqc.sdk.websocket.handler.RealtimeQcCallback;
import com.tinet.sqc.sdk.websocket.handler.RealtimeQcSessionHandler;
import com.tinet.sqc.sdk.websocket.request.RealtimeQcRequest;
import com.tinet.sqc.sdk.websocket.response.RealtimeQcResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

/**
 * @author Chenjf
 * @date 2019/8/19 13:19
 **/
public class RealtimeQcWebSocketClient {
    private static Logger logger = LoggerFactory.getLogger(RealtimeQcWebSocketClient.class);

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
     * SDK 生成的 session，复用一个 WebSocket 连接
     */
    private StompSession session;

    private RealtimeQcWebSocketClientConfiguration configuration;

    private SignatureComposer composer = new SignatureComposer();

    private Signer signer = Signer.getSigner();

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * WebSocket 
     */
    private String url;

    private RealtimeQcCallback callback;

    public RealtimeQcWebSocketClient(@NonNull RealtimeQcWebSocketClientConfiguration configuration, RealtimeQcCallback callback) {
        this.configuration = configuration;
        this.stompClient.setMessageConverter(new MappingJackson2MessageConverter());
        this.url = "ws://" + configuration.getHost() + "/ws";
        this.callback = callback;
    }

    /**
     * 建立与WebSocket 连接，
     */
    public void connect() {

        logger.info("connect to realtimeQc server");

        WebSocketHttpHeaders httpHeaders = new WebSocketHttpHeaders();

        // 与鉴权相关的信息
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put(RequestConstant.ACCESS_KEY_ID, configuration.getAccessKeyId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        queryParams.put(RequestConstant.TIMESTAMP, sdf.format(new Date()));
        queryParams.put(RequestConstant.EXPIRES, String.valueOf(configuration.getExpires()));

        String stringToSign = composer.getStringToSign("GET",
                configuration.getHost(), "/ws", queryParams);
        String signature = signer.signString(stringToSign, configuration.getAccessKeySecret());

        httpHeaders.setAll(queryParams);
        httpHeaders.set(RequestConstant.SIGNATURE, signature);

        StompHeaders stompHeaders = new StompHeaders();

        RealtimeQcSessionHandler sessionHandler = new RealtimeQcSessionHandler(this);

        // 定义并设置用于心跳检测的调度器
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.initialize();
        stompClient.setTaskScheduler(taskScheduler);

        try {
            session = stompClient.connect(url, httpHeaders, stompHeaders, sessionHandler).get();
        } catch (InterruptedException | ExecutionException e) {
            logger.error("RealTimeQc connect error! ", e);
        }
    }

    /**
     * 开始订阅
     * @param clientSession ClientSession
     */
    public void login(ClientSession clientSession) {
        logger.debug("uniqueId {} login realtimeQc", clientSession.getUniqueId());
        StompHeaders headers = new StompHeaders();
        headers.setDestination("/realtimeQc/response/" + clientSession.getUniqueId());
        headers.set("uniqueId", clientSession.getUniqueId());
        headers.set("userId",clientSession.getUserId());

        if (session == null || !session.isConnected()) {
            connect();
        }
        StompSession.Subscription subscription = session.subscribe(headers,
                new StompFrameHandler() {
                    @Override
                    @NonNull
                    public Type getPayloadType(@NonNull StompHeaders headers) {
                        return RealtimeQcResponse.class;
                    }

                    @Override
                    public void handleFrame(@NonNull  StompHeaders headers, Object payload) {
                        if (payload instanceof RealtimeQcResponse) {
                            RealtimeQcResponse realtimeQcResponse = (RealtimeQcResponse) payload;
                            logger.debug("uniqueId {} RealtimeQcResponse {}, timestamp is {}",
                                    realtimeQcResponse.getUniqueId(), realtimeQcResponse, System.currentTimeMillis());
                            callback.callback(realtimeQcResponse);

                        }
                    }
                });

        // 订阅成功时加入 clientSession 及 subscriptionMap
        clientSessionMap.put(clientSession.getUniqueId(), clientSession);
        subscriptionMap.put(clientSession.getUniqueId(), subscription);

    }


    /**
     * 取消订阅
     */
    public void logout(String uniqueId) {
        StompSession.Subscription subscription = subscriptionMap.get(uniqueId);
        if (subscription != null) {
            subscription.unsubscribe();
            clientSessionMap.remove(uniqueId);
            subscriptionMap.remove(uniqueId);
        }
    }

    /**
     * 实时质检
     */
    public void realtimeQc(RealtimeQcRequest request) {
        logger.debug("uniqueId {} RealtimeQcRequest {}, timestamp is {}", request.getUniqueId(),
                request, System.currentTimeMillis());
        session.send("/app/realtimeQc", request);
    }


    /**
     * 关闭WebSocket连接
     */
    public void disConnect() {
        logger.info("disconnect realtimeQc server");
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
}
