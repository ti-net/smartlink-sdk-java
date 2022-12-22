package com.tinet.ai.sdk.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tinet.ai.sdk.model.Knowledge;
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

    /**
     * ● 热门问知识ID
     * ● 推荐问知识ID
     * ● 关联问知识ID
     * ● 多轮会话选项列表知识ID：选项列表知识ID可为空；若选项列表添加为意图时，回传意图ID；若选项列表为变量判断时，回传知识ID为空。
     */
    private Knowledge knowledge;
}
