package com.tinet.ai.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author feizq
 * @date 2022/06/15
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnswerResponseModel {

    /**
     * 答案ID
     */
    private Integer id;
    /**
     * 答案
     */
    private String answer;
}
