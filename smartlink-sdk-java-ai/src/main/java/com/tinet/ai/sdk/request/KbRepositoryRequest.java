package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.KbRepositoryResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 知识库仓库列表请求
 *
 * @author huwk
 * @date 2019/9/18
 **/
public class KbRepositoryRequest extends BaseRequest<KbRepositoryResponse> {

    private String enterpriseId;

    private Integer type;

    private String name;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putQueryParameter("enterpriseId", enterpriseId);
        }
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
        if (type != null) {
            putQueryParameter("type", type);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        if (name != null) {
            putQueryParameter("name", name);
        }
    }

    public KbRepositoryRequest() {
        super("/api/repositories", HttpMethodType.GET);
    }

    @Override
    public Class getResponseClass() {
        return KbRepositoryResponse.class;
    }
}
