package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.ArticleResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 删除文章
 *
 * @author feizq
 * @date 2021/11/26
 **/
public class DeleteKbArticleRequest extends BaseRequest<ArticleResponse> {

    private Integer id;

    private String enterpriseId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        if (id != null) {
            putQueryParameter("id", id);
        }
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putQueryParameter("enterpriseId", enterpriseId);
        }
    }

    public DeleteKbArticleRequest() {
        super("/api/articles", HttpMethodType.DELETE);
    }

    @Override
    public Class getResponseClass() {
        return ArticleResponse.class;
    }
}
