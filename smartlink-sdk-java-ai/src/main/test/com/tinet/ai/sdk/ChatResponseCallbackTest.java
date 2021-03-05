package com.tinet.ai.sdk;

import com.tinet.ai.sdk.handler.ChatResponseCallback;
import com.tinet.ai.sdk.response.ChatResponse;

/**
 * @author 侯法超
 * @date 2021/3/1
 */
public class ChatResponseCallbackTest implements ChatResponseCallback {
    @Override
    public void callback(ChatResponse event) {
        System.out.println(event);
    }
}
