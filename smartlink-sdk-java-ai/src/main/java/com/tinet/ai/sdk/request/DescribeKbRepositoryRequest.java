package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.DescribeKbRepositoryResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 知识库详情请求
 *
 * @author feizq
 * @date 2021/12/21
 **/
public class DescribeKbRepositoryRequest extends BaseRequest<DescribeKbRepositoryResponse> {

    /**
     * 企业ID
     */
    private String enterpriseId;

    /**
     * 所属人
     */
    private String owner;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putQueryParameter("enterpriseId", enterpriseId);
        }
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
        if (owner != null) {
            putQueryParameter("owner", owner);
        }
    }

    public DescribeKbRepositoryRequest() {
        super("/api/repository", HttpMethodType.GET);
    }

    @Override
    public Class<DescribeKbRepositoryResponse> getResponseClass() {
        return DescribeKbRepositoryResponse.class;
    }
}
