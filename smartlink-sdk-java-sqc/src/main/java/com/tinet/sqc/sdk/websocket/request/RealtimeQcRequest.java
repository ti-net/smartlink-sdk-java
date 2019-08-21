package com.tinet.sqc.sdk.websocket.request;

import lombok.Data;

/**
 * @author Chenjf
 * @date 2019/8/19 13:14
 **/
@Data
public class RealtimeQcRequest {

    /**
     * 唯一标识
     */
    private String uniqueId;

    /**
     * 实时转写文本
     */
    private String text;

    /**
     * 文本属于哪一侧  0:坐席侧  1:客户侧
     */
    private Integer side;


}
