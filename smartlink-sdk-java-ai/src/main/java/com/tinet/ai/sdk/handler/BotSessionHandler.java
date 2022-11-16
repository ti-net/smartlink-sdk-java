package com.tinet.ai.sdk.handler;


import com.tinet.ai.sdk.NewBotWebSocketClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.stomp.*;

import java.net.ConnectException;

/**
 * 订阅接收服务端通过WebSocket发送的信息，转交给平台处理
 *
 * @author huwk
 * @date 2021/05/14
 */
public class BotSessionHandler extends StompSessionHandlerAdapter {

    private Logger logger = LoggerFactory.getLogger(BotSessionHandler.class);

    private NewBotWebSocketClient botWebSocketClient;

    public BotSessionHandler(NewBotWebSocketClient botWebSocketClient) {
        this.botWebSocketClient = botWebSocketClient;
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

        botWebSocketClient.subscribe(session, botWebSocketClient.getSubHeaders());
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        logger.error("handleException", exception);
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {

        if (exception instanceof ConnectionLostException) {
            logger.error("handleConnectionLostException, lost connection for TBot server, sleep 3s and retry connect", exception);
            connectRetry(3000);
        } else if (exception instanceof ConnectException) {
            logger.error("handleConnectException, can't connect TBot server, sleep 5s and retry connect", exception);
            connectRetry(5000);
        } else if (exception instanceof StompConversionException) {
            logger.error("handleStompConversionException, can't connect TBot server, sleep 5s and retry connect", exception);
            connectRetry(5000);
        } else {
            logger.error("handleException, can't connect TBot server, sleep 5s and retry connect", exception);
            // connectRetry(5000);
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
            botWebSocketClient.connect(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
