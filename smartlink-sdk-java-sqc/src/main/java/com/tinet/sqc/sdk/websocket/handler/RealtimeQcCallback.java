package com.tinet.sqc.sdk.websocket.handler;


import com.tinet.sqc.sdk.websocket.response.RealtimeQcResponse;

/**
 * @author Chenjf
 * @date 2019/8/19 13:23
 **/
public interface RealtimeQcCallback {
    /**
     * 处理实时质检结果的回调方法
     */
    void callback(RealtimeQcResponse event);
}
