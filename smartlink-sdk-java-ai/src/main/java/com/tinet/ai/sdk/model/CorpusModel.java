package com.tinet.ai.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author feizq
 * @date 2022/07/26
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CorpusModel {

    /**
     * 语料ID
     */
    private Integer id;
    /**
     * 标准问ID
     */
    private Integer sqId;
    /**
     * 语料名称
     */
    private String corpusName;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 状态；0：已训练，1：未训练
     */
    private Integer status;
}
