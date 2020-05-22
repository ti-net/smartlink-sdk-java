package com.tinet.assistant.handler;

import com.tinet.assistant.response.ChatResponse;

/**
 * ChatResponse 回调
 * @author houfc
 * @date 2019/3/16
 */
public interface ChatResponseCallback {
    void callback(ChatResponse event);
}
