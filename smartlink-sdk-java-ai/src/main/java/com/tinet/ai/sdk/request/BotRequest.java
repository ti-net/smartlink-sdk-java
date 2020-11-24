package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.BotResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 获取机器人
 *
 * @author zhaojy
 * @date 2020,11,24
 **/
public class BotRequest extends BaseRequest<BotResponse> {

    /**
     * 企业id
     */
    private String enterpriseId;

    /**
     * 机器人id
     */
    private String botId;


    public String getEnterpriseId() {
        return enterpriseId;
    }

    public String getBotId() {
        return botId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putQueryParameter("enterpriseId", enterpriseId);
        }
    }

    public void setBotId(String botId) {
        this.botId = botId;
        if (botId != null) {
            putQueryParameter("botId", botId);
        }
    }
    public BotRequest() {
        super("/api/tibots/bot", HttpMethodType.GET);
    }

    @Override
    public Class getResponseClass() {
        return BotResponse.class;
    }
}
