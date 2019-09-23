package com.tinet.ai.sdk.handler;

import com.tinet.ai.sdk.response.ChatResponse;

/**
 * ChatResponse 回调
 * @author houfc
 * @date 2019/3/16
 */
public interface ChatResponseCallback {
    void callback(ChatResponse event);
}
