package com.tinet.ai.sdk.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * bot_ocs_answer
 * 最优话术-答案  Optimal Call Script
 * @author zhaojy
 */
@Data
public class BotOcsAnswerModel implements Serializable {
    /**
     * 答案主键ID
     */
    private Integer id;

    private String enterpriseId;

    /**
     * 类别主键id 依赖于 question 中的类别 id
     */
    private Long categoryId;

    private String cno;

    private String cname;

    /**
     * 答案
     */
    private String answer;

    /**
     * 点赞量
     */
    private Integer likeCount;

    /**
     * 点踩量
     */
    private Integer dislikeCount;

    /**
     * 使用量
     */
    private Integer usedCount;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}