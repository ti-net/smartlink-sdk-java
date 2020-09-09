package com.tinet.sqc.sdk.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author 王大宝
 * @date 2019/4/30
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class EnableBiFunctionResponse extends BaseResponse {

    private String result;
    private String message;
}
