package com.tinet.ai.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 文章响应实体
 *
 * @author feizq
 * @date 2021/11/26
 **/
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleResponseModel {

    /**
     * 文章id
     */
    private Integer id;

    /**
     * 企业ID
     */
    private String enterpriseId;

    /**
     * 知识库ID
     */
    private Integer kbId;

    /**
     * 知识库类型
     */
    private Integer kbType;

    /**
     * 目录ID
     */
    private Integer directoryId;

    /**
     * 标题
     */
    private String title;

    /**
     * 座席可用状态
     */
    private Integer agentEnabled;

    /**
     * 相似问题
     */
    private String[] similars;

    /**
     * 文档库 答案
     */
    private String content;

    /**
     * 置顶项
     */
    private Integer topStatus;

    /**
     * 机器人ID
     */
    private String botId;

    /**
     * 关联标题
     */
    private List<KbArticleResponseModel.RelatedQuestion> relatedQuestions;

    /**
     * 问答库 答案
     */
    private List<KbArticleResponseModel.Answer> answers;

}
