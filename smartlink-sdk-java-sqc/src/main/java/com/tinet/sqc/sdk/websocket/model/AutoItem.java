package com.tinet.sqc.sdk.websocket.model;

import lombok.Data;

/**
 * @author 王大宝
 * @date 2019/5/28
 */
@Data
public class AutoItem {
    /**
     * 话术结束时间
     */
    private Long endTime;
    /**
     * 质检项名称
     */
    private String item;
    /**
     * 打标签时进行标记的信息
     */
    private String message;
    /**
     * 原始文本
     */
    private String originText;
    /**
     * 评分记录类型
     */
    private Integer recordType;
    /**
     * 纠正类型
     */
    private Integer reviseType;
    /**
     * 评分
     */
    private Integer score;
    /**
     * 标记文本为哪一侧
     */
    private Integer side;
    /**
     * 时间戳
     */
    private Long timestamp;
    /**
     * Block类型
     */
    private Integer type;
    /**
     * 权重
     */
    private Integer weight;
    /**
     * 纠正评语
     */
    private String commit;
    /**
     * 纠正文本
     */
    private String reviseText;


}
