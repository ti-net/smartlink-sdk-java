package com.tinet.sqc.sdk.websocket.handler;


import com.tinet.sqc.sdk.websocket.RealtimeQcWebSocketClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.stomp.*;

import java.net.ConnectException;

/**
 * @author houfc
 * @date 2019/03/01
 */
public class RealtimeQcSessionHandler extends StompSessionHandlerAdapter {

    private Logger logger = LoggerFactory.getLogger(RealtimeQcSessionHandler.class);

    private RealtimeQcWebSocketClient realTimeQcWebSocketClient;

    public RealtimeQcSessionHandler(RealtimeQcWebSocketClient realTimeQcWebSocketClient) {
        this.realTimeQcWebSocketClient = realTimeQcWebSocketClient;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        System.out.println("handleFrame: " + payload);
    }

    /**
     * 建立WebSocket连接后订阅指定消息通道
     * @param session StompSession
     * @param connectedHeaders StompHeaders
     */
    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        logger.info("connect realTimeQc server successful  ~(￣▽￣)~");
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        logger.error("handleException", exception);
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {

        if (exception instanceof ConnectionLostException) {
            logger.error("handleTransportError, lost connection for realTimeQc server, sleep 3s and retry connect",
                    exception);
            connectRetry(3000);
        } else if (exception instanceof ConnectException) {
            logger.error("handleTransportError, can't connect realTimeQc server, sleep 5s and retry connect",
                    exception);
            connectRetry(5000);
        }
    }

    /**
     * sleep 指定毫秒后重新连接
     * @param sleepMillis sleep 毫秒数
     */
    private void connectRetry(long sleepMillis) {
        try {
            Thread.sleep(sleepMillis);
            realTimeQcWebSocketClient.connect();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
