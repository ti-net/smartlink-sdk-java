package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.KbDirectoryResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 目录删除请求
 *
 * @author feizq
 * @date 2021/12/21
 **/
public class DeleteKbDirectoryRequest extends BaseRequest<KbDirectoryResponse> {

    /**
     * 企业ID
     */
    private String enterpriseId;

    /**
     * 目录ID
     */
    private Integer id;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putQueryParameter("enterpriseId", enterpriseId);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        if (id != null) {
            putQueryParameter("id", id);
        }
    }

    public DeleteKbDirectoryRequest() {
        super("/api/directories", HttpMethodType.DELETE);
    }

    @Override
    public Class<KbDirectoryResponse> getResponseClass() {
        return KbDirectoryResponse.class;
    }
}
