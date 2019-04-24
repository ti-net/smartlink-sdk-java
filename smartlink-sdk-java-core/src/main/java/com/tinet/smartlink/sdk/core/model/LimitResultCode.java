package com.tinet.smartlink.sdk.core.model;

/**
 * LimitResult code的返回值
 * PASS 则不限制
 * LIMIT_BY_FREQUENCY 呼叫频率受限
 *
 * @author mucw
 */
public enum LimitResultCode {

    /**
     * 呼叫不受限
     */
    PASS("Pass", "通过"),

    /**
     * 外显号码
     * 呼叫频次受限
     */
    LIMIT_BY_CALLING_FREQUENCY("LimitByCallingFrequency", "主叫外呼受限-被RMS禁止了"),

    /**
     * 被rms平台黑名单禁拨
     */
    LIMIT_BY_PLATFORM_BLACKLIST("LimitByPlatformBlackList", "客户号码被平台禁止拨打 ---被RMS禁止了"),

    /**
     * 被系统被黑名单禁拨,特指只能汇智平台。
     */
    LIMIT_BY_SYSTEM_BLACKLIST("LimitBySystemBlackList", "客户号码被系统禁止拨打 ---被智能风控系统禁止了"),

    /**
     * 座席侧外显超频
     */
    LIMIT_BY_CALLING_SEAT_FREQUENCY("LimitByCallingSeatFrequency", "座席侧主叫外呼受限-被RMS禁止了"),

    /**
     * 客户侧外显超频
     */
    LIMIT_BY_CALLING_CUSTOMER_FREQUENCY("LimitByCallingCustomerFrequency", "客户侧主叫外呼受限-被RMS禁止了"),

    /**
     * 企业开启了禁拨时间限制
     */
    LIMIT_BY_FORBIDDEN_CALL_TIME("LimitByForbiddenCallTime", "企业禁拨时间限制");




    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    LimitResultCode() {
    }

    LimitResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

//    @Override
//    public String toString() {
//        return "LimitResultCode{" +
//                "code=" + code +
//                ", msg='" + msg + '\'' +
//                '}';
//    }
}
