package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.KbAnswerQueryResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

import java.util.List;

/**
 * 知识库根据答案查询匹配
 *
 * @author feizq
 * @date 2021/09/26
 **/
public class KbAnswerQueryRequest extends BaseRequest<KbAnswerQueryResponse> {

    /**
     * 企业id
     */
    private String enterpriseId;

    /**
     * 查询内容
     */
    private String query;

    /**
     * 知识库类型
     */
    private Integer kbType;

    /**
     * 偏移量
     */
    private Integer offset;

    /**
     * 页中数据大小
     */
    private Integer limit;

    /**
     * 队列列表
     */
    private List<String> qnos;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putQueryParameter("enterpriseId", enterpriseId);
        }
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
        if (query != null) {
            putQueryParameter("query", query);
        }
    }

    public Integer getKbType() {
        return kbType;
    }

    public void setKbType(Integer kbType) {
        this.kbType = kbType;
        if (kbType != null) {
            putQueryParameter("kbType", kbType);
        }
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
        if (offset != null) {
            putQueryParameter("offset", offset);
        }
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
        if (limit != null) {
            putQueryParameter("limit", limit);
        }
    }

    public List<String> getQnos() {
        return qnos;
    }

    public void setQnos(List<String> qnos) {
        this.qnos = qnos;
        if (qnos != null) {
            putQueryParameter("qnos", qnos);
        }
    }

    public KbAnswerQueryRequest() {
        super("/api/articles/articlesByQuery", HttpMethodType.GET);
    }

    @Override
    public Class getResponseClass() {
        return KbAnswerQueryResponse.class;
    }
}
