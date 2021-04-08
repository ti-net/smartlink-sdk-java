package com.tinet.ai.sdk.handler;


import com.tinet.ai.sdk.BotWebSocketClient;
import com.tinet.ai.sdk.ClientSession;
import com.tinet.ai.sdk.response.Pong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.messaging.simp.stomp.*;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Type;
import java.net.ConnectException;
import java.util.List;
import java.util.Map;
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

        String loginId = getKeyByValue(session.getSessionId(), tbotWebSocketClient.getLoginId2SessionId());
        if (Objects.isNull(loginId)) {
            logger.info("[connect TBot server ] 当前的会话的连接为空");
            return;
        }
        subscribePong(session, loginId);

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
                logger.info("[TBot] reConnected, login, current loginId :{}", loginId);
                tbotWebSocketClient.login(clientSessionMap.get(loginId));

            }
        }
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

    /**
     * 通过value获取map<String,String>中的key
     *
     * @param value
     * @param map
     * @return
     */
    public String getKeyByValue(String value, Map<String, String> map) {

        String key = null;
        if (Objects.isNull(value)) {
            return null;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                key = entry.getKey();
                break;
            }
        }
        return key;
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        logger.error("handleException", exception);
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {

        String loginId = getKeyByValue(session.getSessionId(), tbotWebSocketClient.getLoginId2SessionId());
        if (exception instanceof ConnectionLostException) {
            logger.error("handleTransportError, lost connection for TBot server loginId " + loginId, exception);
            tbotWebSocketClient.reconnect(loginId);
        } else if (exception instanceof ConnectException) {
            logger.error("handleTransportError, can't connect TBot server " + loginId, exception);
            tbotWebSocketClient.reconnect(loginId);
        }
    }
}
