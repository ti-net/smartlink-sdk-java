package com.tinet.assistant.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wenjd
 * @date 2019/04/01
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PushCdrResponse extends BaseResponse {

    private String result;
    private String message;


}
