package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.CallScriptRecommendationResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 话术推荐请求
 *
 * @author huwk
 * @date 2019/11/1
 **/
public class CallScriptRecommendationRequest extends BaseRequest<CallScriptRecommendationResponse> {


    /**
     * 机器人ID
     */
    private String botId;

    /**
     * 问题查询
     */
    private String query;

    /**
     *分数取多少条
     */
    private Integer top;

    /**
     * 置信度
     */
    private Float score;

    /**
     * 供应商
     */
    private String provider;

    public CallScriptRecommendationRequest() {
        super("/api/recommendations", HttpMethodType.POST, "2021-09-16");
    }

    public String getBotId() {
        return botId;
    }
    public String getQuery() {
        return query;
    }
    public Integer getTop() {
        return top;
    }
    public Float getScore() {
        return score;
    }
    public String getProvider() {
        return provider;
    }


    public void setBotId(String botId) {
        this.botId = botId;
        if (botId != null) {
            putBodyParameter("botId", botId);
        }
    }
    public void setQuery(String query) {
        this.query = query;
        if (query != null) {
            putBodyParameter("query", query);
        }
    }
    public void setTop(Integer top) {
        this.top = top;
        if (top != null) {
            putBodyParameter("top", top);
        }
    }
    public void setScore(Float score) {
        this.score = score;
        if (score != null) {
            putBodyParameter("score", score);
        }
    }

    public void setProvider(String provider) {
        this.provider = provider;
        if (provider != null) {
            putBodyParameter("provider", provider);
        }
    }

    @Override
    public Class<CallScriptRecommendationResponse> getResponseClass() {
        return CallScriptRecommendationResponse.class;
    }
}
