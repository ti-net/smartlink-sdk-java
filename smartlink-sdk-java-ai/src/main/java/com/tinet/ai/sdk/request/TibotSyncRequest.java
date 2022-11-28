package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.TibotSyncResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 周先康
 * @create 2022/11/25 16:25
 */
public class TibotSyncRequest extends BaseRequest<TibotSyncResponse> {

    private String botThirdPartyId;

    private Integer status;

    public String getBotThirdPartyId() {
        return botThirdPartyId;
    }

    public void setBotThirdPartyId(String botThirdPartyId) {
        this.botThirdPartyId = botThirdPartyId;
        if (botThirdPartyId != null){
            putQueryParameter("botThirdPartyId",botThirdPartyId);
        }
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
        if (status != null){
            putQueryParameter("status",status);
        }
    }

    public TibotSyncRequest() {super("/api/tibots/status/sync", HttpMethodType.GET);}

    /**
     * @return 一组请求中对应的 Response ,需要实现 BaseResponse
     */
    @Override
    public Class<TibotSyncResponse> getResponseClass() {
        return TibotSyncResponse.class;
    }
}
