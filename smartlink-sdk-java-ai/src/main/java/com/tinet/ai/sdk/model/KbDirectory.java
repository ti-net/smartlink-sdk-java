package com.tinet.ai.sdk.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 知识库目录
 *
 * @author huwk
 * @date 2019/8/29
 **/
@Data
public class KbDirectory {
    
    private Integer id;
    /**
     * 企业ID，在机器人中对应的userId
     */
    private String enterpriseId;

    /**
     * 目录名称
     */
    private String name;


    /**
     * 知识库ID
     */
    private Integer kbId;

    /**
     * 父节点ID
     */
    private Integer parentId;

    /**
     * 树物理路径
     */
    private String path;

    /**
     * 是否叶子节点 0 非叶子 1 叶子
     */
    private Integer leaf;

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
     * 知识库下的目录路径
     */
    private List<KbDirectory> subDirectories;
    
}
