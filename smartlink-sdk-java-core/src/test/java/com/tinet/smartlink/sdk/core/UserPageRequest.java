package com.tinet.smartlink.sdk.core;

import com.tinet.smartlink.sdk.core.request.BaseRequest;

public class UserPageRequest extends BaseRequest<UserPageResponse> {
    public UserPageRequest() {
        super("/", HttpMethodType.GET);
    }

    @Override
    public Class<UserPageResponse> getResponseClass() {
        return UserPageResponse.class;
    }
}
