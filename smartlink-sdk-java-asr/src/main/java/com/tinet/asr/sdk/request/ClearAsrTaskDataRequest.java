package com.tinet.asr.sdk.request;


import com.tinet.asr.sdk.response.ClearAsrTaskDataResponse;
import com.tinet.asr.sdk.response.GetAsrTaskResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 清理AsrTaskData缓存request
 * @author Ailos
 */
public class ClearAsrTaskDataRequest extends BaseRequest<ClearAsrTaskDataResponse> {


    /**
     * 是否清理
     */
    private Boolean clearFlag;

    public Boolean getClearFlag() {
        return clearFlag;
    }

    public void setClearFlag(Boolean clearFlag) {
        this.clearFlag = clearFlag;
        if (clearFlag != null) {
            putQueryParameter("clearFlag", clearFlag);
        }
    }

    public ClearAsrTaskDataRequest() {
        super("/asr/clearAsrTaskData", HttpMethodType.GET);
    }

    @Override
    public Class<ClearAsrTaskDataResponse> getResponseClass() {
        return ClearAsrTaskDataResponse.class;
    }
}
