package com.tinet.ai.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 知识实体类
 * ● 热门问知识ID
 * ● 推荐问知识ID
 * ● 关联问知识ID
 * ● 多轮会话选项列表知识ID：选项列表知识ID可为空；若选项列表添加为意图时，回传意图ID；若选项列表为变量判断时，回传知识ID为空。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Knowledge {

    /**
     * 知识id
     */
    String id;

    /**
     * 知识类型
     */
    String type;

    /**
     * 知识内容
     */
    String content;
}
