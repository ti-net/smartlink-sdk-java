package com.tinet.ai.sdk.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 文章响应实体
 *
 * @author huwk
 * @date 2019/9/3
 **/
@Data
@ToString
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
}
