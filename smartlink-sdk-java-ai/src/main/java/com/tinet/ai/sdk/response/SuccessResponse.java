package com.tinet.ai.sdk.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 侯法超
 * @date 2021/3/3
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SuccessResponse extends BaseResponse {
    private String result;
}
