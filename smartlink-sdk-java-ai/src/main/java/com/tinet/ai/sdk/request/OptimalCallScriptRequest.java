package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.OptimalCallScriptResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 查询最优话术
 *
 * @author zhaojy
 * @date 2020/9/9
 **/
public class OptimalCallScriptRequest extends BaseRequest<OptimalCallScriptResponse> {

    private String enterpriseId;
    private String query;

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putQueryParameter("enterpriseId", enterpriseId);
        }
    }

    public void setQuery(String query) {
        this.query = query;
        if (query != null) {
            putQueryParameter("query", query);
        }
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public String getQuery() {
        return query;
    }

    public OptimalCallScriptRequest() {
        super("/api/optimalCallScript", HttpMethodType.GET);
    }

    @Override
    public Class getResponseClass() {
        return OptimalCallScriptResponse.class;
    }
}
