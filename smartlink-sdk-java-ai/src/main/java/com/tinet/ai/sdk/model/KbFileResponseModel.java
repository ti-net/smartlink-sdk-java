package com.tinet.ai.sdk.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 文件库返回实体
 *
 * @author huwk
 * @date 2019/10/16
 **/
@Data
@ToString
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
}
