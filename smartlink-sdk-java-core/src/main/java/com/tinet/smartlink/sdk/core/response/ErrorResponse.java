package com.tinet.smartlink.sdk.core.response;

import com.tinet.smartlink.sdk.core.exceptions.ErrorModel;

/**
 * @author houfc
 * @date 2018/11/27
 */
public class ErrorResponse extends BaseResponse {

    private ErrorModel error;

    public ErrorModel getError() {
        return error;
    }

    public void setError(ErrorModel error) {
        this.error = error;
    }
}