package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.KbArticleResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 智能知识库请求实体
 *
 * @author feizq
 * @date 2021/11/23
 **/
public class IntelligentKnowledgeBaseRequest extends BaseRequest<KbArticleResponse> {

    /**
     * 企业ID
     */
    private String enterpriseId;

    /**
     * 机器人ID
     */
    private String botId;

    /**
     * 搜索内容
     */
    private String query;

    /**
     * 偏移量
     */
    private Integer offset;

    /**
     * 一页数量
     */
    private Integer limit;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putQueryParameter("enterpriseId", enterpriseId);
        }
    }

    public String getBotId() {
        return botId;
    }

    public void setBotId(String botId) {
        this.botId = botId;
        if (botId != null) {
            putQueryParameter("botId", botId);
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

    public IntelligentKnowledgeBaseRequest(){
        super("/api/intelligentKnowledgeBase", HttpMethodType.POST);
    }

    @Override
    public Class<KbArticleResponse> getResponseClass() {
        return KbArticleResponse.class;
    }
}
