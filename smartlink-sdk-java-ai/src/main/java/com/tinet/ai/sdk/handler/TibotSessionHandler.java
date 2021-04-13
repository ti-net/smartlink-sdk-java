package com.tinet.ai.sdk.handler;


import com.tinet.ai.sdk.BotWebSocketClient;
import com.tinet.ai.sdk.ClientSession;
import com.tinet.ai.sdk.response.Pong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.messaging.simp.stomp.*;

import java.lang.reflect.Type;
import java.net.ConnectException;
import java.util.Objects;

/**
 * 订阅接收服务端通过WebSocket发送的信息，转交给  {@code TibotEventHandler} 处理，各平台处理
 *
 * @author houfc
 * @date 2019/03/01
 */
public class TibotSessionHandler extends StompSessionHandlerAdapter {

    private Logger logger = LoggerFactory.getLogger(TibotSessionHandler.class);

    private BotWebSocketClient tbotWebSocketClient;
    /**
     * 登录ID
     */
    private String loginId;
    /**
     * 登录头
     */
    private StompHeaders loginHeaders;

    /**
     * 判断是否是断线重连，如果是的话，需要处理客户端的遗留数据。
     */
    private boolean retry = false;

    public TibotSessionHandler(BotWebSocketClient tibotWebSocketClient) {
        this(tibotWebSocketClient,null);
    }
    public TibotSessionHandler(BotWebSocketClient tibotWebSocketClient, String loginId) {
        this(tibotWebSocketClient, loginId, null);
    }
    public TibotSessionHandler(BotWebSocketClient tibotWebSocketClient, String loginId, StompHeaders loginHeaders) {
        this(tibotWebSocketClient, loginId, loginHeaders, false);
    }
    public TibotSessionHandler(BotWebSocketClient tibotWebSocketClient, String loginId,
                               StompHeaders loginHeaders, boolean retry) {
        this.tbotWebSocketClient = tibotWebSocketClient;
        this.loginId = loginId;
        this.loginHeaders = loginHeaders;
        this.retry = retry;
    }
    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        logger.info("handleFrame: " + payload);
    }

    /**
     * 建立WebSocket连接后订阅指定消息通道
     *
     * @param session          新的StompSession
     * @param connectedHeaders StompHeaders
     */
    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        logger.info("connect TBot server successful  ~(￣▽￣)~ session {} header {}", session, connectedHeaders);

        // 处理重连客户端数据
        if (retry) {
            ClientSession clientSession = tbotWebSocketClient.getClientSessionMap().get(loginId);
            if (Objects.nonNull(clientSession)) {
                // 客户端自动进行重新订阅
                logger.info("[TBot] reConnected, login, current loginId :{}", loginId);
                tbotWebSocketClient.login(clientSession, true);
            }
            // 开启新的心跳
            tbotWebSocketClient.startHeartbeat(loginId,
                    tbotWebSocketClient.getClientSessionMap().get(loginId).getUnConnectCount());
        } else {
            // 连接成功后登录
            tbotWebSocketClient.subscribe(session, loginId, loginHeaders);
            // 心跳检测
            tbotWebSocketClient.startHeartbeat(loginId,
                    tbotWebSocketClient.getClientSessionMap().get(loginId).getUnConnectCount());
        }

        subscribePong(session, loginId);
    }

    private void subscribePong(StompSession session, String loginId) {
        StompHeaders headers = new StompHeaders();

        headers.setDestination("/chat/pong/" + loginId);
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
                            ClientSession clientSession = tbotWebSocketClient.getClientSessionMap().get(loginId);
                            clientSession.unConnectCount.set(0);
                            logger.info("[TBot] received pong  HOST_UUID:{}", ((Pong) pong).getRequestId());
                        }
                    }
                }
        );
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        logger.error("handleException: session: {}, command: {}, header: {}, payload: {} exception: {}",
                session, command, headers, payload, exception);
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {
        if (exception instanceof ConnectionLostException) {
            logger.error("handleTransportError, lost connection for TBot server loginId " + loginId, exception);
            connectRetry(loginId);
        } else if (exception instanceof ConnectException) {
            logger.error("handleTransportError, can't connect TBot server " + loginId, exception);
            connectRetry(loginId);
        }
    }

    /**
     * sleep 指定毫秒后重新连接
     *
     */
    private void connectRetry(String loginId) {
        try {
            Thread.sleep(3000);
            tbotWebSocketClient.reconnect(loginId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
