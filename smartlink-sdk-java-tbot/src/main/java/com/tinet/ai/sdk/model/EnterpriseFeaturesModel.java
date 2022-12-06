package com.tinet.ai.sdk.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * enterprise
 * @author 
 */
@Data
public class EnterpriseFeaturesModel implements Serializable {

    /**
     * 功能代号
     */
    private String code;

    /**
     * 功能描述
     */
    private String name;

    /**
     * 功能开关
     */
    private String openFlag;

    /**
     * 功能扩展配置
     */
    private List<String> config;

    private static final long serialVersionUID = 1L;
}