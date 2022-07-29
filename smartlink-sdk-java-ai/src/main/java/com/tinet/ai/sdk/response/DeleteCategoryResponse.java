package com.tinet.ai.sdk.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;

/**
 * 删除标准问响应实体
 *
 * @author feizq
 * @date 2022/06/20
 **/
public class DeleteCategoryResponse extends BaseResponse {

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
