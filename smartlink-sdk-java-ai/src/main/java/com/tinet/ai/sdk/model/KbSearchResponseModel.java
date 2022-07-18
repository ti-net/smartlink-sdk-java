package com.tinet.ai.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * 知识搜索响应实体
 *
 * @author feizq
 * @date 2022/07/01
 **/
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class KbSearchResponseModel {

    /**
     * 知识ID
     */
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
     * 所属知识库类型，冗余kbId对应库的类型
     * 0 表示 问答库
     * 1 文档库
     */
    private Integer kbType;

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
    private List<KbArticleResponseModel.Answer> answers;

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

    /**
     * 文档库-关联知识点
     */
    private List<KbArticleResponseModel.RelatedQuestion> relatedQuestions;

    /**
     * 机器人厂商
     */
    private String provider;

    /**
     * 文件大小(K)
     */
    private Long fileSize;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 搜索出的文档片段
     */
    private List<String> contentList;

    /**
     * 文件说明
     */
    private String description;

}
