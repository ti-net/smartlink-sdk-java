package com.tinet.ai.sdk.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;

/**
 * 创建知识库响应
 *
 * @author feizq
 * @date 2022/12/08
 **/
public class CreateRepositoryResponse extends BaseResponse {
    private Integer result;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
