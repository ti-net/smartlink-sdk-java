package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.CorpusResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 查询机器人列表
 *
 * @author huwk
 * @date 2019/9/19
 */
public class CorpusRequest extends BaseRequest<CorpusResponse> {

    /**
     * 企业id
     */
    private Integer enterpriseId;

    /**
     * 机器人id
     */
    private String botId;

    public CorpusRequest() {
        super("/api/corpus", HttpMethodType.GET);
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
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

    @Override
    public Class<CorpusResponse> getResponseClass() {
        return CorpusResponse.class;
    }
}
