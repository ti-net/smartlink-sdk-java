package com.tinet.ai.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

/**
 * 机器人配置
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bot {

    private Integer id;

    /**
     * 平台登录名
     * 账户 id
     * 企业ID，在机器人中对应的userId
     */
    private String accountLoginName;
    private Integer accountId;
    private Integer enterpriseId;

    /**
     * 机器人id
     * 机器人名称
     * 机器人(会话)类型
     *   语音：1、11
     *   协呼：18、21
     *   呼入：12、16
     *   外呼：13、17、20
     * 第三方机器人id
     * 供应商
     *   芒果：mango
     *   竹间：zhujian
     *   百应：baiying
     *   自研：tibot
     *
     * 机器人昵称
     * 机器人头像
     * 描述
     */
    private String botId;
    private String botName;
    private Integer botType;
    private String botThirdPartyId;
    private String provider;
    private String nickname;
    private String avatar;
    private String description;

    /**
     * 状态；0:禁用，1:启用
     */
    private Integer status;
    /**
     * 机器人并发数  (默认不进行限制)
     */
    private Integer concurrent;

    /**
     * 访问连接
     * ak
     * sk
     * 访问token
     */
    private String accessUrl;
    private String accessKey;
    private String secretKey;
    private String accessToken;



    /**
     * rasa 自定义 action 服务地址，其在创建机器人的时候生成
     * 云问机器人的sysNum
     */
    private String actionEndpoint;



    private Date createTime;
    private Date updateTime;
    /**
     * 创建人
     * 更新人
     */
    private String createUser;
    private String updateUser;

    /**
     * PAAS平台企业ID
     */
    private String paasId;
}
