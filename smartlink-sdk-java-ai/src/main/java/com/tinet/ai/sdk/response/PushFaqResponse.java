package com.tinet.ai.sdk.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;

/**
 * @author feizq
 * @date 2022/06/07
 **/
public class PushFaqResponse extends BaseResponse {

    /**
     * 结果
     */
    private String result;
    /**
     * 描述信息
     */
    private String message;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
