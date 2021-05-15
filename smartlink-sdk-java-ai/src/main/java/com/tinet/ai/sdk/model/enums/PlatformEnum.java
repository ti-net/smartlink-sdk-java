package com.tinet.ai.sdk.model.enums;

/**
 * 平台客户端标识
 *
 * @author huwk
 * @date 2021/5/15
 **/
public enum PlatformEnum {
    /**
     * CLINK2平台
     */
    CLINK2("clink2"),
    /**
     * CTICLOUD平台
     */
    CTICLOUD("cticloud"),
    /**
     * CXCLOUD平台
     */
    CXCLOUD("cxcloud");


    private String value;

    PlatformEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
