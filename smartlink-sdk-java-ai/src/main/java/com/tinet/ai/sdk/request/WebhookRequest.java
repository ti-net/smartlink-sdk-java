package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.model.EventData;
import com.tinet.ai.sdk.response.WebhookResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * @author feizq
 * @date 2022/05/27
 **/
public class WebhookRequest extends BaseRequest<WebhookResponse> {

    /**
     * 事件：
     *  开户：clink2-account-managet
     */
    private String event;

    /**
     * 数据：
     */
    private EventData data;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
        if (event != null) {
            putBodyParameter("event", event);
        }
    }

    public EventData getData() {
        return data;
    }

    public void setData(EventData data) {
        this.data = data;
        if (data != null) {
            putBodyParameter("data", data);
        }
    }

    public WebhookRequest() {
        super("/api/webhook", HttpMethodType.POST);
    }

    @Override
    public Class getResponseClass() {
        return WebhookResponse.class;
    }
}
