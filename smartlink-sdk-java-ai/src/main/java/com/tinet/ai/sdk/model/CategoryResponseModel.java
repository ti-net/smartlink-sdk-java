package com.tinet.ai.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author feizq
 * @date 2022/06/20
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryResponseModel {
    /**
     * 分类ID
     */
    private Integer id;
    /**
     * 等级
     */
    private Integer level;
    /**
     * 名称
     */
    private String name;
    /**
     * 父类ID
     */
    private Integer parentId;
    /**
     * 路径
     */
    private Integer[] path;
}
