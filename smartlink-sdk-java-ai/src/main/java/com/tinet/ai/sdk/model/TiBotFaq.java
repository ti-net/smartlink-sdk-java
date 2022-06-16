package com.tinet.ai.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * @author feizq
 * @date 2022/06/07
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TiBotFaq {
    /**
     * faq主键ID
     */
    private Long faqId;

    /**
     * faq问答目录
     */
    private String[] catalog;

    /**
     * 标准问
     */
    private String standardQuestion;

    /**
     * 答案
     */
    private List<TiBotAnswer> answers;

    /**
     * 相似问
     */
    private String[] similarQuestions;

    /**
     * 操作类型；delete: 删除；update：更新
     */
    private String operType;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TiBotAnswer {
        /**
         * 答案类型：text文本；rtf富文本；指令(transfer转人工/voice语音/customer自定义类型)
         */
        private String answersType;

        /**
         * 答案内容(string)
         *
         * 注意：（类型转人工时：内容为jsonString   commandsContent :指令内容 commands：指令）
         */
        private String answersContent;
    }
}
