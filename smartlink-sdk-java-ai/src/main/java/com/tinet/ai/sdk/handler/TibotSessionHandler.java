package com.tinet.ai.sdk.handler;


import com.tinet.ai.sdk.BotWebSocketClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.stomp.*;

import java.net.ConnectException;

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
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        logger.error("handleException", exception);
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {

        if (exception instanceof ConnectionLostException) {
            logger.error("handleTransportError, lost connection for TBot server", exception);
        } else if (exception instanceof ConnectException) {
            logger.error("handleTransportError, can't connect TBot server", exception);
        }
    }
}
