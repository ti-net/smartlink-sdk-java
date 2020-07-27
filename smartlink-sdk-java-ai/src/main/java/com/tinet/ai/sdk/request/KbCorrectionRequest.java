package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.KbCorrectionResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 知识库搜索更正
 *
 * @author huwk
 * @date 2019/9/18
 **/
public class KbCorrectionRequest extends BaseRequest<KbCorrectionResponse> {
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
    private String keyword;

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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
        if (keyword != null) {
            putQueryParameter("keyword", keyword);
        }
    }

    public KbCorrectionRequest() {
        super("/api/correction", HttpMethodType.GET);
    }

    @Override
    public Class getResponseClass() {
        return KbCorrectionResponse.class;
    }
}
