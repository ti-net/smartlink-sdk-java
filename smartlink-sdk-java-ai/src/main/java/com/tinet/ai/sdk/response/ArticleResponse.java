package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.ArticleResponseModel;
import com.tinet.smartlink.sdk.core.response.BaseResponse;

/**
 * 文章响应
 *
 * @author feizq
 * @date 2021/11/26
 **/
public class ArticleResponse  extends BaseResponse {

    private ArticleResponseModel article;

    public ArticleResponseModel getArticle() {
        return article;
    }

    public void setArticle(ArticleResponseModel article) {
        this.article = article;
    }
}
