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
import java.util.Map;

/**
 * 订阅接收服务端通过WebSocket发送的信息，转交给  {@code TibotEventHandler} 处理，各平台处理
 *
 * @author houfc
 * @date 2019/03/01
 */
public class TibotSessionHandler extends StompSessionHandlerAdapter {

    private Logger logger = LoggerFactory.getLogger(TibotSessionHandler.class);

    private BotWebSocketClient tbotWebSocketClient;

    public TibotSessionHandler(BotWebSocketClient tibotWebSocketClient) {
        this.tbotWebSocketClient = tibotWebSocketClient;
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
        logger.info("connect TBot server successful  ~(￣▽￣)~");

        subscribePong();

        Map<String, ClientSession> clientSessionMap = tbotWebSocketClient.getClientSessionMap();
        if (!clientSessionMap.isEmpty()) {
            // 重连成功
            AfterConnectHandler afterConnect;
            if ((afterConnect = tbotWebSocketClient.getAfterConnect()) != null) {
                // 用户自己处理session
                logger.info("[TBot] reConnected, handler old session... ");
                afterConnect.handlerClientSessionAfterConnect(clientSessionMap);
                clientSessionMap.clear();
            } else {
                // 客户端自动进行重新订阅
                for (Map.Entry<String, ClientSession> sessionEntry : clientSessionMap.entrySet()) {
                    logger.info("[TBot] reConnected, login, current loginId :{}", sessionEntry.getKey());
                    tbotWebSocketClient.login(sessionEntry.getValue(), "noLogin");
                }
            }
        }
    }

    private void subscribePong() {
        StompHeaders headers = new StompHeaders();
        headers.setDestination("/chat/pong/" + BotWebSocketClient.CLIENT_UUID);
        tbotWebSocketClient.getSession().subscribe(headers,
                new StompFrameHandler() {
                    @Override
                    @NonNull
                    public Type getPayloadType(@NonNull StompHeaders headers) {
                        return Pong.class;
                    }

                    @Override
                    public void handleFrame(@NonNull StompHeaders headers, Object pong) {
                        if (pong instanceof Pong) {
                            BotWebSocketClient.unConnectCount.set(0);
                            logger.info("[TBot] received pong  HOST_UUID:{}", ((Pong) pong).getRequestId());
                        }
                    }
                }
        );
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        logger.error("handleException", exception);
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {

        if (exception instanceof ConnectionLostException) {
            logger.error("handleTransportError, lost connection for TBot server, sleep 3s and retry connect", exception);
            connectRetry(3000);
        } else if (exception instanceof ConnectException) {
            logger.error("handleTransportError, can't connect TBot server, sleep 5s and retry connect", exception);
            connectRetry(5000);
        }
    }

    /**
     * sleep 指定毫秒后重新连接
     *
     * @param sleepMillis sleep 毫秒数
     */
    private void connectRetry(long sleepMillis) {
        try {
            Thread.sleep(sleepMillis);
            tbotWebSocketClient.connect();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
