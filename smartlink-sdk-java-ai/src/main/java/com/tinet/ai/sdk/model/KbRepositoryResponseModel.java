package com.tinet.ai.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 知识库表实体类
 *
 * @author huwk
 * @date 2019/8/29
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class KbRepositoryResponseModel {

    private Integer id;
    /**
     * 知识库名称
     */
    private String name;

    /**
     * 知识库类型
     */
    private Integer type;

    /**
     * 企业ID，在机器人中对应的userId
     */
    private Integer enterpriseId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 平台登录名
     */
    private String accountLoginName;

    /**
     * 所属人
     */
    private String owner;
}
