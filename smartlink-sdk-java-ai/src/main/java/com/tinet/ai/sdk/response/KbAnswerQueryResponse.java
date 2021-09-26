package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.KbArticleResponseModel;
import com.tinet.smartlink.sdk.core.response.BaseResponse;

import java.util.List;

/**
 * @author feizq
 * @date 2021/09/26
 **/
public class KbAnswerQueryResponse extends BaseResponse {

    private List<KbArticleResponseModel> articles;

    public List<KbArticleResponseModel> getArticles() {
        return articles;
    }

    public void setArticles(List<KbArticleResponseModel> articles) {
        this.articles = articles;
    }
}
