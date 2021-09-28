package com.tinet.ai.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

/**
 * 话术推荐QA实体
 *
 * @author huwk
 * @date 2019/11/1
 **/
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecommendationQa {

    /**
     * 文章ID
     */
    private String id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 相似问题
     */
    private String[] similars;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 文章评分
     */
    private Float score;

    /**
     * 供应商；emotibot 代表 竹间
     */
    private String provider;

}
