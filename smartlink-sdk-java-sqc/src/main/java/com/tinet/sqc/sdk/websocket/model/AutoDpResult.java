package com.tinet.sqc.sdk.websocket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

/**
 * ClassFor:
 * 数据透视（打标签）细节对象
 *
 * @author: yinzk
 * @data: 2019/05/20
 */
@Data
public class AutoDpResult {
    /**
     * 标签名
     */
    private String name;
    /**
     * 被打上标签的话术对象的坐席侧客户侧属性（0：坐席侧，1：客户侧）。
     */
    private Integer asrSide;
    /**
     * 标签自身的属性（0：坐席侧，1：客户侧）。
     */
    private Integer tagSide;
    /**
     * 开始时间
     */
    private Long startTime;
    /**
     * 标签是否已被删除了
     */
    private Integer deleted = 0;
    /**
     * 表是否为新增标签
     */
    private Integer added = 0;
    /**
     * 打标签时进行标记的信息
     * todo 暂时不使用
     */
    private String message;

}
