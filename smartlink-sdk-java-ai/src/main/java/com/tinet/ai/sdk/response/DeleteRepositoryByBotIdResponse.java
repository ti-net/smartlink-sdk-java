package com.tinet.ai.sdk.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;

/**
 * 根据机器人ID删除知识库响应
 *
 * @author feizq
 * @date 2022/11/29
 **/
public class DeleteRepositoryByBotIdResponse extends BaseResponse {

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
