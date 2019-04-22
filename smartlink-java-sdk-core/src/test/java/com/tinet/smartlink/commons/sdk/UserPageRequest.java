package com.tinet.smartlink.commons.sdk;

import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

public class UserPageRequest extends BaseRequest<UserPageResponse> {
    public UserPageRequest() {
        super("/page_demo", HttpMethodType.GET);
    }

    @Override
    public Class<UserPageResponse> getResponseClass() {
        return UserPageResponse.class;
    }
}
