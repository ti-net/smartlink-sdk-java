package com.tinet.ai.sdk.model;

import lombok.Data;

/**
 * @author tinet-yuhq
 * @description 追一随路参数
 * @createTime 2021/8/13 10:58
 */
@Data
public class AdditionalParam {
    /**
     * 追一随路参数：手机号
     */
    private String phNumber;

    /**
     * 追一随路参数：归属省份
     */
    private String phProvince;

    /**
     * 追一随路参数：归属城市
     */
    private String phCity;

    /**
     * 追一随路参数：业务标识
     */
    private String businessFlag;
}
