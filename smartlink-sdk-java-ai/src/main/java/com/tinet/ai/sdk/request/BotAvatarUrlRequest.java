package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.BotAvatarUrlResponse;
import com.tinet.ai.sdk.response.KbArticleImageUrlResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 获取机器人头像url 请求
 *
 * @author zhaojy
 * @date 2019/10/8
 **/
public class BotAvatarUrlRequest extends BaseRequest<BotAvatarUrlResponse> {

    /**
     * 文件路径
     */
    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
        if (filePath != null) {
            putQueryParameter("filePath", filePath);
        }
    }

    public BotAvatarUrlRequest() {
        super("/api/tibots/avatar", HttpMethodType.GET);
    }

    @Override
    public Class getResponseClass() {
        return BotAvatarUrlResponse.class;
    }
}
