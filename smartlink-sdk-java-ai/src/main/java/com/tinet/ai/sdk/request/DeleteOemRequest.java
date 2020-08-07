package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.DeleteOemResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;


/**
 * 推送oem
 *
 * @author wenjd
 * @date 2019/04/11
 */
public class DeleteOemRequest extends BaseRequest<DeleteOemResponse> {


    /**
     * oemAccountId 账户标志。该账户在clink2标志信息
     */
    private String oemAccountId;

    public String getOemAccountId() {
        return oemAccountId;
    }

    public void setOemAccountId(String oemAccountId) {
        this.oemAccountId = oemAccountId;
        if (oemAccountId != null) {
            putQueryParameter("oemAccountId", oemAccountId);
        }
    }

    public DeleteOemRequest() {
        super("/api/deleteOem", HttpMethodType.GET);
    }

    @Override
    public Class<DeleteOemResponse> getResponseClass() {
        return DeleteOemResponse.class;
    }
}
