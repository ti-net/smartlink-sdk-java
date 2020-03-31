package com.tinet.ai.sdk.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 知识库仓库响应参数
 *
 * @author huwk
 * @date 2019/10/23
 **/
@Data
public class KbDirectoryResponseModel {
    
    private Integer id;
    /**
     * 知识库名称
     */
    private String name;
    
    /**
     * 知识库类型
     */
    private Integer type;
    
    /**
     * 是否绑定机器人
     */
    private Boolean hasBundleBot;
    
    
    /**
     * 企业ID，在机器人中对应的userId
     */
    private String enterpriseId;
    
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
     * 知识库仓库列表排名位置
     */
    private Integer ranking;
    /**
     * 知识库下的目录路径
     */
    private List<KbDirectory> subDirectories;
}
