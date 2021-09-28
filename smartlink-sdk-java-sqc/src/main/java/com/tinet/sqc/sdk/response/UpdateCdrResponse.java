package com.tinet.sqc.sdk.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: liurf
 * @Date: 2021/9/22 18:23
*/
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateCdrResponse extends BaseResponse {

    private String result;
    private String message;


}
