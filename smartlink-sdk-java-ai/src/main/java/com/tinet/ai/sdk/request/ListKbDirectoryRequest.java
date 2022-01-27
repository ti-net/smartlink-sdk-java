package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.ListKbDirectoryResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 获取个人知识库的目录列表请求
 *
 * @author feizq
 * @date 2021/12/21
 **/
public class ListKbDirectoryRequest extends BaseRequest<ListKbDirectoryResponse> {

    /**
     * 企业ID
     */
    private String enterpriseId;

    /**
     * 知识库ID
     */
    private Integer kbId;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putQueryParameter("enterpriseId", enterpriseId);
        }
    }

    public Integer getKbId() {
        return kbId;
    }

    public void setKbId(Integer kbId) {
        this.kbId = kbId;
        if (kbId != null) {
            putQueryParameter("kbId", kbId);
        }
    }

    public ListKbDirectoryRequest() {
        super("/api/directories/list", HttpMethodType.GET);
    }

    @Override
    public Class<ListKbDirectoryResponse> getResponseClass() {
        return ListKbDirectoryResponse.class;
    }
}
