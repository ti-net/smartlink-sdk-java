package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.EmotibotEnterpriseResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 获取竹间企业信息请求实体
 *
 * @author feizq
 * @date 2021/12/06
 **/
public class EmotibotEnterpriseRequest extends BaseRequest<EmotibotEnterpriseResponse> {

    /**
     * 企业ID
     */
    private String enterpriseId;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putQueryParameter("enterpriseId", enterpriseId);
        }
    }

    public EmotibotEnterpriseRequest() {
        super("/api/tibots/emotibot/enterprise", HttpMethodType.GET);
    }

    @Override
    public Class<EmotibotEnterpriseResponse> getResponseClass() {
        return EmotibotEnterpriseResponse.class;
    }
}
