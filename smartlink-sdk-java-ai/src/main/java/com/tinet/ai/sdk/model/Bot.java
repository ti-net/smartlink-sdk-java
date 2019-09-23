package com.tinet.ai.sdk.model;

import lombok.Data;

import java.util.Date;

@Data
public class Bot {

    private Integer id;
    private Integer userId; //企业id
    private String provider; //供应商 百度。。。
    private String accessUrl;//请求url
    private String accessKey;//ak
    private String secretKey;//sk
    private String accessToken;//令牌
    private String botId;//tibot机器人id
    private String botThirdPartyId;//第三方机器人id
    private String botName;//机器人名称
    private Date createTime;
    private Date updateTime;
    private String botKbId;
    private Integer botType;
}
