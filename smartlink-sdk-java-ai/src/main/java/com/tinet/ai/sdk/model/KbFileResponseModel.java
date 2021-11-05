package com.tinet.ai.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * 文件库返回实体
 *
 * @author huwk
 * @date 2019/10/16
 **/
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class KbFileResponseModel {

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
     * 目录ID
     */
    private Integer directoryId;

    /**
     * 知识库ID
     */
    private Integer kbId;

    /**
     * 所属知识库类型，冗余kbId对应库的类型
     */
    private Integer kbType;

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
     * 文件点赞数量
     */
    private Integer likeCount;

    /**
     * 文件点踩数量
     */
    private Integer dislikeCount;

    /**
     * 0 已点赞 1 已点踩  null 未被点击
     */
    private String status;

    /**
     * 有效性（0~无效，1~有效）
     */
    private Integer validity;

    /**
     * 标签（0~内部标签，1~外部标签）
     */
    private Integer label;
}
