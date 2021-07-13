package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.KbArticleResponseModel;
import com.tinet.smartlink.sdk.core.response.BaseResponse;

/**
 * 文章详情响应类
 *
 * @author feizq
 * @date 2021/06/26
 **/
public class KbDescribeArticleResponse extends BaseResponse {

    private KbArticleResponseModel article;

    public KbArticleResponseModel getArticle() {
        return article;
    }

    public void setArticle(KbArticleResponseModel article) {
        this.article = article;
    }
}
