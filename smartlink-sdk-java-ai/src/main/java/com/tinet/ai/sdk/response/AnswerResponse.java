package com.tinet.ai.sdk.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnswerResponse {
    /**
     * 文本内容
     */
    private String text;
    /**
     * 答案类型
     */
    private String type;

    /**
     * DOCS/VOICE/VIDEO的附件名称
     */
    private String name;
    /**
     *选项列表
     */
    private List<String> cards;

    /**
     * 子类型 similar相似问、recommend推荐问
     */
    private String subType;

    /**
     * 公用数据对象
     */
    private Object data;
}
