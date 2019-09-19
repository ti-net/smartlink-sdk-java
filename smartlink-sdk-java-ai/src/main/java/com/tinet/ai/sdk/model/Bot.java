package com.tinet.ai.sdk.model;

import lombok.Data;

import java.util.Date;

/**
 * 机器人配置
 */
@Data
public class Bot {

    private Integer id;

    /**
     * 企业id
     */
    private Integer userId;

    /**
     * 供应商
     */
    private String provider;

    /**
     * 请求url
     */
    private String accessUrl;

    /**
     * ak
     */
    private String accessKey;

    /**
     * sk
     */
    private String secretKey;

    /**
     * 令牌
     */
    private String accessToken;

    /**
     * tibot机器人id
     */
    private String botId;

    /**
     * 第三方机器人id
     */
    private String botThirdPartyId;

    /**
     * 平台登录名
     */
    private String accountLoginName;

    /**
     * 机器人名称
     */
    private String botName;
    private Date createTime;
    private Date updateTime;
    private String botKbId;
    private Integer botType;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 机器人昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 状态   0禁用   1启用  2不可用(申请中)
     */
    private Integer status;

    /**
     * 描述
     */
    private String description;

}
