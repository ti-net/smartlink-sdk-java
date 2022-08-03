package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.DescribeKbSettingResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 知识库设置详情请求
 *
 * @author feizq
 * @date 2022/08/03
 **/
public class DescribeKbSettingRequest extends BaseRequest<DescribeKbSettingResponse> {

    /**
     * 企业ID
     */
    private String enterpriseId;

    /**
     * 所属人
     */
    private Integer type;

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

    public DescribeKbSettingRequest() {
        super("/api/setting", HttpMethodType.GET);
    }

    @Override
    public Class<DescribeKbSettingResponse> getResponseClass() {
        return DescribeKbSettingResponse.class;
    }
}
