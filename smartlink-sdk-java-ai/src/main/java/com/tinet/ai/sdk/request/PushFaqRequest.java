package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.model.TiBotFaq;
import com.tinet.ai.sdk.response.PushFaqResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

import java.util.List;

/**
 * @author feizq
 * @date 2022/06/07
 **/
public class PushFaqRequest extends BaseRequest<PushFaqResponse> {

    /**
     * 请求唯一ID
     */
    private String uuid;

    /**
     * 发送时间
     */
    private String senderTime;

    /**
     * 企业ID
     */
    private Long enterpriseId;

    /**
     * 机器人ID
     */
    private Long botId;

    /**
     * faq数据列表
     */
    private List<TiBotFaq> faqList;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
        if (uuid != null) {
            putBodyParameter("uuid", uuid);
        }
    }

    public String getSenderTime() {
        return senderTime;
    }

    public void setSenderTime(String senderTime) {
        this.senderTime = senderTime;
        if (senderTime != null) {
            putBodyParameter("senderTime", senderTime);
        }
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putBodyParameter("enterpriseId", enterpriseId);
        }
    }

    public Long getBotId() {
        return botId;
    }

    public void setBotId(Long botId) {
        this.botId = botId;
        if (botId != null) {
            putBodyParameter("botId", botId);
        }
    }

    public List<TiBotFaq> getFaqList() {
        return faqList;
    }

    public void setFaqList(List<TiBotFaq> faqList) {
        this.faqList = faqList;
        if (faqList != null) {
            putBodyParameter("faqList", faqList);
        }
    }

    public PushFaqRequest() {
        super("/api/tibot/push/faq", HttpMethodType.POST);
    }

    @Override
    public Class<PushFaqResponse> getResponseClass() {
        return PushFaqResponse.class;
    }
}
