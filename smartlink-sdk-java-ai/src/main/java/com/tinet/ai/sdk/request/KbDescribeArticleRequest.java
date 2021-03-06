package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.KbDescribeArticleResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 查询文章详情请求
 *
 * @author feizq
 * @date 2021/06/26
 **/
public class KbDescribeArticleRequest extends BaseRequest<KbDescribeArticleResponse> {

    /**
     * 企业Id
     */
    private Integer enterpriseId;

    /**
     * 文章Id
     */
    private String id;

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putQueryParameter("enterpriseId", enterpriseId);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        if (id != null) {
            putQueryParameter("id", id);
        }
    }

    public KbDescribeArticleRequest() {
        super("/api/article/detail", HttpMethodType.GET);
    }

    @Override
    public Class getResponseClass() {
        return KbDescribeArticleResponse.class;
    }
}
