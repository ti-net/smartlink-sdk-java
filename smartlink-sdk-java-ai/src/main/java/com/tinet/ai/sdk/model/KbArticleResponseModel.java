package com.tinet.ai.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * 文章响应实体
 *
 * @author huwk
 * @date 2019/9/3
 **/
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class KbArticleResponseModel {
    private String id;

    /**
     * 企业ID
     */
    private String enterpriseId;

    /**
     * 标题
     */
    private String title;

    /**
     * 相似文章
     */
    private String similars;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 电话回复内容
     */
    private String phoneContent;
    /**
     * 在线回复文章内容
     */
    private String onlineContent;
    /**
     * 微信回复文章内容
     */
    private String wechatContent;
    /**
     * app回复文章内容
     */
    private String appContent;
    /**
     * 网页回复文章内容
     */
    private String webContent;

    /**
     * 目录ID
     */
    private Integer directoryId;

    /**
     * 知识库ID
     */
    private Integer kbId;

    /**
     * 有效起始日期
     */
    private Date validDateFrom;

    /**
     * 有效终止时间
     */
    private Date validDateTo;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 平台登录名
     */
    private String accountLoginName;
    /**
     * 目录路径
     */
    private List<String> path;

    /**
     * 文章点赞数量
     */
    private Integer likeCount;

    /**
     * 文章点踩数量
     */
    private Integer dislikeCount;

    /**
     * 0 已点赞 1 已点踩  null 未被点击
     */
    private String status;

    /**
     * 问答库 多个答案
     */
    private List<Answer> answers;

    /**
     * 机器人ID
     */
    private String botId;
    /**
     * 机器人配置-标签
     */
    private String[] botTag;

    /**
     * 机器人配置-标签
     */
    private String[] botAction;

    @Data
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Answer {
        private String answer;

        private String[] recommendQuestion;

        private String startTime;
        private String endTime;

        /**
         * 转人工 0不选中 1选中
         */
        private Integer transfer;

    }
}
