package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.EnterpriseMappingModel;
import com.tinet.smartlink.sdk.core.response.BaseResponse;

/**
 * 创建企业映射响应
 *
 * @author feizq
 * @date 2022/11/08
 **/
public class CreateEnterpriseMappingResponse extends BaseResponse {

    private EnterpriseMappingModel result;

    public EnterpriseMappingModel getResult() {
        return result;
    }

    public void setResult(EnterpriseMappingModel result) {
        this.result = result;
    }
}
