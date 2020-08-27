package com.tinet.ai.sdk.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @author 王大宝
 */
@Data
@ToString
public class IntelligentAssociationModel {

    private String id;

    /**
    *企业ID
    */
    private String enterpriseId;
    /**
    * Tbot平台上的机器人唯一标识
    */
    private String botId;
    /**
     * 问题集合
     */
    private List<String> questions;
    /**
    * 回答
    */
    private String answers;


    private Date createTime;

}