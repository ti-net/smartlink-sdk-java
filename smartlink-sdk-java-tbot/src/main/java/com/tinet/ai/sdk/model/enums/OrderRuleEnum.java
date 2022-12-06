package com.tinet.ai.sdk.model.enums;

/**
 * 知识库文章排序规则
 *
 * @author zhaojianyu
 */

public enum OrderRuleEnum {

    /**
     * 默认不排序
     * heat: 按热度排序
     */
    NONE("none"),
    HEAT("heat"),
    LIKE("like"),
    DISLIKE("dislike");

    private String rule;

    OrderRuleEnum(String rule) {
        this.rule = rule;
    }

    public String getRule() {
        return rule;
    }
}
