package com.tinet.ai.sdk.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zangshoubao
 * @date 2022/12/06
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EnterpriseSyncResponse extends BaseResponse {

    private String result;
    private String message;

    private Integer status;


}
