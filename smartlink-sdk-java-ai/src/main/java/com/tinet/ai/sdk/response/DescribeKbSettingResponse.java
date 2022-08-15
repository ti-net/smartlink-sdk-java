package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.KbSettingResponseModel;
import com.tinet.smartlink.sdk.core.response.BaseResponse;

/**
 * 知识库设置详情响应
 *
 * @author feizq
 * @date 2022/08/03
 **/
public class DescribeKbSettingResponse extends BaseResponse {

    private KbSettingResponseModel result;

    public KbSettingResponseModel getResult() {
        return result;
    }

    public void setResult(KbSettingResponseModel result) {
        this.result = result;
    }
}
