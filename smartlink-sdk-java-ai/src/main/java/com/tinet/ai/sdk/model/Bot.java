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
     * 平台登录名
     */
    private String accountLoginName;
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
     * sk
     */
    private String accessKey;
    private String secretKey;

    /**
     * 令牌
     */
    private String accessToken;

    /**
     * 机器人id
     * 第三方机器人id
     * 机器人名称
     * 机器人(会话)类型 0 呼叫中心(呼入) 1 呼叫中心(外呼) 2 在线客服
     */
    private String botId;
    private String botThirdPartyId;
    private String botName;
    private Integer botType;

    private String botKbId;


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
     * rasa 自定义 action 服务地址，其在创建机器人的时候生成
     * 云问机器人的sysNum
     */
    private String actionEndpoint;

    /**
     * 描述
     */
    private String description;


    private Date createTime;
    private Date updateTime;
    /**
     * 创建人
     * 更新人
     */
    private String createUser;
    private String updateUser;
}
