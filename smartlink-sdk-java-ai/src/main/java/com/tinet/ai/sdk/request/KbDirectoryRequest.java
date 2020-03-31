package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.KbDirectoriesResponse;
import com.tinet.ai.sdk.response.KbRepositoryResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 知识库目录列表请求
 *
 * @author huwk
 * @date 2019/9/18
 **/
public class KbDirectoryRequest extends BaseRequest<KbDirectoriesResponse> {

    private String enterpriseId;

    private String keyword;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putQueryParameter("enterpriseId", enterpriseId);
        }
    }
    
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
        if (keyword != null) {
            putQueryParameter("keyword", keyword);
        }
    }

    public KbDirectoryRequest() {
        super("/api/directories", HttpMethodType.GET);
    }

    @Override
    public Class getResponseClass() {
        return KbDirectoriesResponse.class;
    }
}
