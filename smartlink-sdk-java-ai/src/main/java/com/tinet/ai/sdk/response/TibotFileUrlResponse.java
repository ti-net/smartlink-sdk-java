package com.tinet.ai.sdk.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;

/**
 * 机器人消息附件链接生成响应
 *
 * @author huwk
 * @date 2021/3/10
 **/
public class TibotFileUrlResponse extends BaseResponse {

    private String fileUrl;

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
