package com.tinet.ai.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

/**
 * 知识库设置响应实体类
 *
 * @author feizq
 * @date 2022/08/03
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class KbSettingResponseModel {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 企业ID，在机器人中对应的userId
     */
    private String enterpriseId;

    /**
     * 类型；0：座席端，1：管理员端
     */
    private Integer type;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 文档库内容保护；0：关闭，1：开启，默认关闭
     */
    private Integer documentProtection;
}
