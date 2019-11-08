package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.RecommendationQa;
import com.tinet.smartlink.sdk.core.response.BaseResponse;

import java.util.List;

/**
 * 话术推荐响应
 *
 * @author huwk
 * @date 2019/11/1
 **/
public class CallScriptRecommendationResponse extends BaseResponse {

    private List<RecommendationQa> recommendations;

    public List<RecommendationQa> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<RecommendationQa> recommendations) {
        this.recommendations = recommendations;
    }
}
