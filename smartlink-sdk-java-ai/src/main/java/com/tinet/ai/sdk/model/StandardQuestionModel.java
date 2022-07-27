package com.tinet.ai.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * 竹间标准问实体
 *
 * @author feizq
 * @date 2022/07/26
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StandardQuestionModel {

    /**
     * 标准问ID
     */
    private Integer id;

    /**
     * 分类ID
     */
    private Integer categoryId;

    /**
     * 标准问标题
     */
    private String title;

    /**
     * 标准问状态
     */
    private Integer status;

    /**
     * 语料数量
     */
    private Integer corpusCount;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;
}
