package com.tinet.smartlink.commons.sdk;

import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

public class UserPostRequest extends BaseRequest<UserPostResponse> {

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        if (name != null) {
            putBodyParameter("name", name);
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        if (password != null) {
            putBodyParameter("password", password);
        }
    }

    public UserPostRequest() {
        super("/user", HttpMethodType.POST);
    }

    @Override
    public Class<UserPostResponse> getResponseClass() {
        return UserPostResponse.class;
    }
}
