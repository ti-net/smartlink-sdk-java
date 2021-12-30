package com.tinet.ai.sdk.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;

/**
 * 目录响应
 *
 * @author feizq
 * @date 2021/12/21
 **/
public class KbDirectoryResponse extends BaseResponse {

    private Integer result;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
