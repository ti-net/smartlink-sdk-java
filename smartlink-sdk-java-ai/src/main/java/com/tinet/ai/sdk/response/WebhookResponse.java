package com.tinet.ai.sdk.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;

/**
 * 回调
 *
 * @author feizq
 * @date 2022/05/27
 **/
public class WebhookResponse extends BaseResponse {

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
