package com.tinet.ai.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 企业映射响应结果实体
 *
 * @author feizq
 * @date 2022/11/08
 **/
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnterpriseMappingModel {

    /**
     * ID
     */
    private Integer id;

    /**
     * 企业ID
     */
    private String enterpriseId;

    /**
     * PAAS平台企业ID
     */
    private String paasId;

    /**
     * 创建时间
     */
    private Date createTime;
}
