package com.tinet.sqc.sdk.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Ailos
 * @date 2021-11-29 21:32:37
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RepushAsrResponse extends BaseResponse {

    private String result;
    private String message;


}
