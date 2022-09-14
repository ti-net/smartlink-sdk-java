package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.ApiMessageFeedbackResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

import java.util.List;

/**
 * 对会话进行点赞或点踩接口请求参数类
 *
 * @author feizq
 * @date 2021/06/23
 **/
public class ApiMessageFeedbackRequest  extends BaseRequest<ApiMessageFeedbackResponse> {

    /**
     * 机器人id
     */
    private String botId;

    /**
     * 企业ID
     */
    private Integer enterpriseId;

    /**
     * 对话ID
     */
    private String responseId;

    /**
     * 点赞（helpful）、点踩（unhelpful）、取消（cancel）
     */
    private String feedback;

    /**
     * 建议（反馈文字）
     */
    private String customFeedback;

    /**
     * 机器人厂商
     */
    private String provider;

    /**
     * 点踩项
     */
    private List<String> labels;

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
        if (provider != null) {
            putQueryParameter("provider", provider);
        }
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
        if (labels != null) {
            putQueryParameter("labels", labels);
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

    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
        if (responseId != null) {
            putQueryParameter("responseId", responseId);
        }
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
        if (feedback != null) {
            putQueryParameter("feedback", feedback);
        }
    }

    public String getCustomFeedback() {
        return customFeedback;
    }

    public void setCustomFeedback(String customFeedback) {
        this.customFeedback = customFeedback;
        if (customFeedback != null) {
            putQueryParameter("customFeedback", customFeedback);
        }
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

    public ApiMessageFeedbackRequest() {
        super("/api/tibots/message/feedback", HttpMethodType.GET);
    }

    @Override
    public Class getResponseClass() {
        return ApiMessageFeedbackResponse.class;
    }
}
