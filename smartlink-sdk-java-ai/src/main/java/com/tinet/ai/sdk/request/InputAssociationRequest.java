package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.InputAssociationResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 输入联想请求
 *
 * @author feizq
 * @date 2021/09/01
 **/
public class InputAssociationRequest extends BaseRequest<InputAssociationResponse> {

    /**
     * 企业ID
     */
    private String enterpriseId;

    /**
     * 机器人ID
     */
    private String botId;

    /**
     * 答案查询
     */
    private String text;

    /**
     * 取多少条
     */
    private Integer top;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putBodyParameter("enterpriseId", enterpriseId);
        }
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        if (text != null) {
            putBodyParameter("text", text);
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

    public InputAssociationRequest() {
        super("/api/inputAssociation", HttpMethodType.POST);
    }

    @Override
    public Class<InputAssociationResponse> getResponseClass() {
        return InputAssociationResponse.class;
    }
}
