package com.tinet.ai.sdk.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;

/**
 * 知识库文章图片链接生成响应
 *
 * @author huwk
 * @date 2019/9/18
 **/
public class KbFileUrlResponse extends BaseResponse {

    private String fileUrl;

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
