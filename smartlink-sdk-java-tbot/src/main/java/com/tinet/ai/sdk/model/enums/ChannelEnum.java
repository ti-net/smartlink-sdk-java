package com.tinet.ai.sdk.model.enums;

/**
 * 平台类型
 *
 * @author 王大宝
 * @date 2020.03.12
 */
public enum ChannelEnum {
    
    /**
     * 默认回复内容
     */
    CONTENT("content"),
    /**
     * 电话回复内容
     */
    PHONE_CONTENT("phoneContent"),
    /**
     * 在线回复内容
     */
    ONLINE_CONTENT("onlineContent"),
    /**
     *微信 回复内容
     */
    WECHAT_CONTENT("wechatContent"),
    /**
     * app回复内容
     */
    APP_CONTENT("appContent"),

    /**
     * 网页回复内容
     */
    WEB_CONTENT("webContent");


    private String value;
    
    ChannelEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
