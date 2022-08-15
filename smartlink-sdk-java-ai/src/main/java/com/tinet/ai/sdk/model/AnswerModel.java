package com.tinet.ai.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * 竹间答案实体
 *
 * @author feizq
 * @date 2022/07/26
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnswerModel {

    /**
     * 答案ID
     */
    private Integer id;
    /**
     * 标准问ID
     */
    private Integer sqId;
    /**
     * 答案
     */
    private String answer;
    /**
     * 有效开始时间
     */
    private String startTime;
    /**
     * 有效结束时间
     */
    private String endTime;
    /**
     * 类型；1：每天，0：无
     */
    private Integer periodType;

    /**
     * 相关问集合
     */
    private List<RelatedQuestion> relatedQuestionList;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RelatedQuestion {
        /**
         * 相关问ID
         */
        private Integer relatedQuestionId;
        /**
         * 相关问标题
         */
        private String relatedQuestionTitle;
    }
}
