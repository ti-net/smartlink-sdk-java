package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.EmotibotEnterpriseModel;
import com.tinet.smartlink.sdk.core.response.BaseResponse;

/**
 * 竹间企业信息响应实体
 *
 * @author feizq
 * @date 2021/12/06
 **/
public class EmotibotEnterpriseResponse extends BaseResponse {

    private EmotibotEnterpriseModel result;

    public EmotibotEnterpriseModel getResult() {
        return result;
    }

    public void setResult(EmotibotEnterpriseModel result) {
        this.result = result;
    }
}
