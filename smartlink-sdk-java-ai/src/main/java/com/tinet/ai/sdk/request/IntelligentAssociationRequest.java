package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.IntelligentAssociationResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 智能联想请求
 *
 * @author huwk
 * @date 2019/11/1
 **/
public class IntelligentAssociationRequest extends BaseRequest<IntelligentAssociationResponse> {

    /**
     * 机器人ID
     */
    private String botId;

    /**
     * 企业 id
     */
    private String enterpriseId;

    /**
     * 取多少条
     */
    private Integer top;

    /**
     * 文本
     */
    private String text;

    /**
     * 供应商
     */
    private String provider;

    public IntelligentAssociationRequest() {
        super("/api/intelligentAssociation", HttpMethodType.POST);
    }

    public String getBotId() {
        return botId;
    }

    public void setBotId(String botId) {
        this.botId = botId;
        if (botId != null) {
            putBodyParameter("botId", botId);
        }
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putBodyParameter("enterpriseId", enterpriseId);
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        if (text != null) {
            putBodyParameter("text", text);
        }
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
        if (provider != null) {
            putBodyParameter("provider", provider);
        }
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
        if (top != null) {
            putBodyParameter("top", top);
        }
    }

    @Override
    public Class<IntelligentAssociationResponse> getResponseClass() {
        return IntelligentAssociationResponse.class;
    }
}
