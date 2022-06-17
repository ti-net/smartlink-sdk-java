package com.tinet.ai.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

/**
 * @author feizq
 * @date 2022/05/27
 **/
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventData {

    /**
     * 租户id
     */
    private Long enterpriseId;
    /**
     * 租户名称（开户时必填，其他情况非必填）
     */
    private String name;
    /**
     * 状态：1开户，3暂停服务
     */
    private Integer status;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 更新人
     */
    private String updateUser;
}
