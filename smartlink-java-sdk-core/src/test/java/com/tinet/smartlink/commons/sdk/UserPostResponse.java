package com.tinet.smartlink.commons.sdk;

import com.tinet.smartlink.sdk.core.response.BaseResponse;

public class UserPostResponse extends BaseResponse {

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
