package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.KbArticleImageUrlResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 知识库文章图片链接生成请求
 *
 * @author huwk
 * @date 2019/9/18
 **/
public class KbArticleImageUrlRequest extends BaseRequest<KbArticleImageUrlResponse> {

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

    public KbArticleImageUrlRequest() {
        super("/api/articles/images", HttpMethodType.GET);
    }

    @Override
    public Class getResponseClass() {
        return KbArticleImageUrlResponse.class;
    }
}
