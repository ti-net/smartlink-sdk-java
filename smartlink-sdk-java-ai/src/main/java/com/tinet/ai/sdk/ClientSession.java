package com.tinet.ai.sdk;

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
     * cdr 中的 uniqueId
     */
    private String uniqueId;

    /**
     * 三户模型中的 userId，对应 CC 的 enterpriseId
     */
    private Integer userId;

    /**
     * 三户模型中的 clientId，对应 CC 中的客户号码
     */
    private String clientId;

    /**
     * 企业所配置的机器人 ID
     */
    private String botId;

    /**
     * 请求参数
     */
    private Map<String, String> params;

}
