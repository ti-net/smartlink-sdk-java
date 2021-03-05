package com.tinet.ai.sdk;

import com.tinet.ai.sdk.handler.AfterConnectHandler;

import java.util.Map;

/**
 * @author 侯法超
 * @date 2021/3/1
 */
public class AfterConnectHandlerTest implements AfterConnectHandler {
    @Override
    public void handlerClientSessionAfterConnect(Map<String, ClientSession> clientSessionMap) {
        System.out.println(clientSessionMap);
    }
}
