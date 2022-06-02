package com.tinet.ai.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author tinet-yuhq
 * @description
 * @createTime 2022/4/27 14:38
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Corpus {

    /**
     * 语料id（随机串）
     */
    private String corpusId;
    /**
     * 输入内容
     */
    private String inputs;
    /**
     * 输出内容
     */
    private String outputs;
    /**
     * 语料类型（中文）
     */
    private String type;
    /**
     * 流程节点名称
     */
    private String text;
}