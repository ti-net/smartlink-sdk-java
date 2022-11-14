package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.CreateEnterpriseMappingResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 创建企业映射请求
 *
 * @author feizq
 * @date 2022/11/08
 **/
public class CreateEnterpriseMappingRequest extends BaseRequest<CreateEnterpriseMappingResponse> {

    /**
     * 企业ID
     */
    private String enterpriseId;

    /**
     * PAAS平台企业ID
     */
    private String paasId;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putBodyParameter("enterpriseId", enterpriseId);
        }
    }

    public String getPaasId() {
        return paasId;
    }

    public void setPaasId(String paasId) {
        this.paasId = paasId;
        if (paasId != null) {
            putBodyParameter("paasId", paasId);
        }
    }

    public CreateEnterpriseMappingRequest() {
        super("/api/enterpriseMapping", HttpMethodType.POST);
    }

    @Override
    public Class<CreateEnterpriseMappingResponse> getResponseClass() {
        return CreateEnterpriseMappingResponse.class;
    }
}
