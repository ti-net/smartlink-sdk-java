package com.tinet.ai.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author feizq
 * @date 2022/06/15
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StandardQuestionResponseModel {

    /**
     * 标准问ID
     */
    private Integer id;
    /**
     * 标准问状态
     */
    private Integer status;
    /**
     * 标准问问题
     */
    private String title;
}
