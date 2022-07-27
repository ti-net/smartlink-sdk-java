package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.ListStandardQuestionResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * @author feizq
 * @date 2022/07/26
 **/
public class ListStandardQuestionRequest extends BaseRequest<ListStandardQuestionResponse> {

    /**
     * 企业ID
     */
    private String enterpriseId;

    /**
     * 机器人ID
     */
    private String botId;

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

    public ListStandardQuestionRequest() {
        super("/api/botKnowledgeBase/emotibot/listStandardQuestion", HttpMethodType.GET);
    }

    @Override
    public Class<ListStandardQuestionResponse> getResponseClass() {
        return ListStandardQuestionResponse.class;
    }
}
