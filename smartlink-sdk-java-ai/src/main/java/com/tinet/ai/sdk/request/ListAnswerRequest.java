package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.ListAnswerResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * @author feizq
 * @date 2022/07/26
 **/
public class ListAnswerRequest extends BaseRequest<ListAnswerResponse> {

    /**
     * 企业ID
     */
    private String enterpriseId;

    /**
     * 机器人ID
     */
    private String botId;

    /**
     * 标准问ID
     */
    private Integer sqId;

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

    public Integer getSqId() {
        return sqId;
    }

    public void setSqId(Integer sqId) {
        this.sqId = sqId;
        if (sqId != null) {
            putQueryParameter("sqId", sqId);
        }
    }

    public ListAnswerRequest() {
        super("/api/botKnowledgeBase/emotibot/listAnswer", HttpMethodType.GET);
    }

    @Override
    public Class<ListAnswerResponse> getResponseClass() {
        return ListAnswerResponse.class;
    }
}
