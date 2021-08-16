package com.tinet.ai.sdk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tinet-yuhq
 * @description 追一随路参数
 * @createTime 2021/8/13 10:58
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalParam {
    /**
     * 追一随路参数：手机号
     */
    private String number;

    /**
     * 追一随路参数：归属省份
     */
    private String province;

    /**
     * 追一随路参数：归属城市
     */
    private String city;

    /**
     * 追一随路参数：业务标识
     */
    private String flag;

    /**
     * 追一随路参数：号码类型(tel,mobile)
     */
    private String type;
}
