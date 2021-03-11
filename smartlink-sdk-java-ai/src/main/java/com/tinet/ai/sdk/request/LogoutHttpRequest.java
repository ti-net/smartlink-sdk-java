package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.SuccessResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * @author 侯法超
 * @date 2021/3/9
 */
public class LogoutHttpRequest extends BaseRequest<SuccessResponse> {
    public LogoutHttpRequest() {
        super("/api/logout", HttpMethodType.DELETE);
    }

    private String loginId;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
        if (loginId != null) {
            putQueryParameter("loginId", loginId);
        }
    }

    @Override
    public Class<SuccessResponse> getResponseClass() {
        return SuccessResponse.class;
    }
}
