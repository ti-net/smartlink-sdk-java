package com.tinet.sqc.sdk.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author： 许成
 * @date： 2021/10/14 15:39
 * @description：
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SaveCdrBusinessPriorityResponse extends BaseResponse {

    private String result;
    private String message;
}
