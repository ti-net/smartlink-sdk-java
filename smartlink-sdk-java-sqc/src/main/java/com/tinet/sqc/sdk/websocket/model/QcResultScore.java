package com.tinet.sqc.sdk.websocket.model;

import lombok.Data;

/**
 * ClassFor:
 * 质检项分数统计字段。
 *
 * @author yinzk
 * @date 2019/08/19
 */
@Data
public class QcResultScore {

    /**
     * 质检项名称
     */
    private String item;
    /**
     * 父质检项
     */
    private String parentItem;
    /**
     * 权重
     */
    private Integer weight;
    /**
     * 评分
     */
    private Integer score;
    /**
     * 是否是致命项
     */
    private Integer hit;
    /**
     * 质检项纠正次数
     */
    private Integer reviseItemCount = 0;
    /**
     * 质检项追加评分次数
     */
    private Integer appendItemCount = 0;
    /**
     * 自动质检次数
     */
    private Integer qcItemCount = 0;
}
