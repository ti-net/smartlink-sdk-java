package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.BatchDeleteArticleResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 批量删除文章
 *
 * @author feizq
 * @date 2022/12/08
 **/
public class BatchDeleteArticleRequest extends BaseRequest<BatchDeleteArticleResponse> {

    /**
     * 主键ID
     */
    private String[] ids;

    /**
     * 知识库ID
     */
    private Integer kbId;

    /**
     * 知识库类型
     */
    private Integer kbType;

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
        if (ids != null) {
            putBodyParameter("ids", ids);
        }
    }

    public Integer getKbId() {
        return kbId;
    }

    public void setKbId(Integer kbId) {
        this.kbId = kbId;
        if (kbId != null) {
            putBodyParameter("kbId", kbId);
        }
    }

    public Integer getKbType() {
        return kbType;
    }

    public void setKbType(Integer kbType) {
        this.kbType = kbType;
        if (kbType != null) {
            putBodyParameter("kbType", kbType);
        }
    }

    public BatchDeleteArticleRequest() {
        super("/api/articles/batch", HttpMethodType.DELETE);
    }

    @Override
    public Class<BatchDeleteArticleResponse> getResponseClass() {
        return BatchDeleteArticleResponse.class;
    }
}
