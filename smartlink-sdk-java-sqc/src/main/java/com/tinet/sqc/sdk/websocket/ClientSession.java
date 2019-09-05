package com.tinet.sqc.sdk.websocket;

import lombok.Data;

import java.util.Map;

/**
 * 注册时使用的信息
 * @author houfc
 * @date 2019/3/16
 */
@Data
public class ClientSession {

    /**
     * 唯一标识
     */
    private String uniqueId;


    /**
     * 三户模型中的 userId，对应 CC 的 enterpriseId
     **/
    private String userId;


    public ClientSession(String uniqueId, String userId) {
        this.uniqueId = uniqueId;
        this.userId = userId;
    }

}
