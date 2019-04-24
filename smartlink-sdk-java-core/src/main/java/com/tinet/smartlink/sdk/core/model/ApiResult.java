package com.tinet.smartlink.sdk.core.model;

/**
 * 返回结果提示
 *
 * @author huwk
 * @date 2018/12/1
 **/
public class ApiResult {
    private String code = "Pass";
    private String message = "通过";

    public ApiResult() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
