package com.tinet.ai.sdk.handler;

import com.tinet.ai.sdk.ClientSession;

import java.util.Map;

/**
 * 连接后
 *
 * @author zhaojy
 */
public interface AfterConnectHandler {

    /**
     * 重新连接后处理旧ws连接session
     *
     * @param clientSessionMap
     */
    void handlerClientSessionAfterConnect(Map<String, ClientSession> clientSessionMap);
}
