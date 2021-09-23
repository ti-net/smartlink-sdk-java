package com.tinet.sqc.sdk.request;

import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;
import com.tinet.sqc.sdk.response.UpdateCdrResponse;

/**
 * @Author: liurf
 * @Description: 修改cdr信息
 * @Date: 2021/9/22 18:22
*/
public class UpdateCdrRequest extends BaseRequest<UpdateCdrResponse> {


    /**
     * 记录唯一标识
     */
    private String uniqueId;

    /**
     *  业务优先级
     */
    private String businessPriority;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getBusinessPriority() {
        return businessPriority;
    }

    public void setBusinessPriority(String businessPriority) {
        this.businessPriority = businessPriority;
    }

    public UpdateCdrRequest() {
        super("/sqc/cdr", HttpMethodType.PUT);
    }

    @Override
    public Class<UpdateCdrResponse> getResponseClass() {
        return UpdateCdrResponse.class;
    }
}
