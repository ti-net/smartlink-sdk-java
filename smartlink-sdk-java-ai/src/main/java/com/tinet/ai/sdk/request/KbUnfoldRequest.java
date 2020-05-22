package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.KbUnfoldResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 知识库搜索补全
 *
 * @author huwk
 * @date 2019/9/18
 **/
public class KbUnfoldRequest extends BaseRequest<KbUnfoldResponse> {
    /**
     * 企业id
     */
    private String enterpriseId;
    /**
     * 知识库id
     */
    private Integer kbId;
    /**
     * 关键词
     */
    private String id;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        if (id != null) {
            putQueryParameter("id", id);
        }
    }

    public KbUnfoldRequest() {
        super("/api/unfold", HttpMethodType.GET);
    }

    @Override
    public Class getResponseClass() {
        return KbUnfoldResponse.class;
    }
}
