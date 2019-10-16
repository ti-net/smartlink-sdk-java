package com.tinet.ai.sdk.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;

/**
 * 获取机器人头像url 响应
 *
 * @author zhaojy
 * @date 2019/10/8
 **/
public class BotAvatarUrlResponse extends BaseResponse {

    private String fileUrl;

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
