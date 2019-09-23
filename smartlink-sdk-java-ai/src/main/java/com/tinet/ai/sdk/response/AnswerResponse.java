package com.tinet.ai.sdk.response;

import lombok.Data;

import java.util.List;

@Data
public class AnswerResponse {
    /**
     * 文本内容
     */
    private String text;
    /**
     * 答案类型
     */
    private String type;

    /*
     *选项列表
     */
    private List<String> cards;

}
