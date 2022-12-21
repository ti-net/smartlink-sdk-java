package com.tinet.ai.sdk.request;


import com.tinet.ai.sdk.response.EnterpriseGrayQKResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;


/**
 * Created by IntelliJ IDEA.
 *
 * @Author 周先康
 * @create 2022/12/21 3:13
 */
public class EnterpriseGrayQKRequest extends BaseRequest<EnterpriseGrayQKResponse> {

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putQueryParameter("enterpriseId", enterpriseId);
        }
    }

    private String enterpriseId;


    public EnterpriseGrayQKRequest() {
        super("/api/qk/enterprise/gray", HttpMethodType.GET);
    }


    /**
     * @return 一组请求中对应的 Response ,需要实现 BaseResponse
     */
    @Override
    public Class<EnterpriseGrayQKResponse> getResponseClass() {
        return EnterpriseGrayQKResponse.class;
    }
}
