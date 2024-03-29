package com.tinet.ai.sdk.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;

/**
 * 删除标准问响应实体
 *
 * @author feizq
 * @date 2022/06/15
 **/
public class DeleteStandardQuestionResponse extends BaseResponse {

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
