package com.tinet.assistant.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 实时转写 响应
 *
 * @author zhaojy
 * @date 2020/05/21
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(value = "true")
public class PushRealTimeAsrResponse extends BaseResponse {

    private String result;
    private String message;

}
