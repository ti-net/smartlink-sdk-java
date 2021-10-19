package com.tinet.sqc.sdk.request;

import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.sqc.sdk.model.BusinessPriority;
import com.tinet.sqc.sdk.response.SaveCdrBusinessPriorityResponse;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

import java.util.List;

/**
 * @author： 许成
 * @date： 2021/10/14 15:38
 * @description：
 */
public class SaveCdrBusinessPriorityRequest extends BaseRequest<SaveCdrBusinessPriorityResponse> {
    private List<BusinessPriority> param;
    @Override
    public Class<SaveCdrBusinessPriorityResponse> getResponseClass() {
        return SaveCdrBusinessPriorityResponse.class;
    }

    public SaveCdrBusinessPriorityRequest() {
        super("/sqc/saveCdrBusinessPriority", HttpMethodType.POST);
    }

    public List<BusinessPriority> getParam() {
        return param;
    }

    public void setParam(List<BusinessPriority> param) {
        this.param = param;

        if (param != null) {
            putBodyParameter("param", param);
        }
    }
}
