package com.tinet.assistant.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 获取机器人头像url 响应
 *
 * @author zhaojy
 * @date 2019/10/8
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class PushRealTimeAsrResponse extends BaseResponse {

    private Integer status;
    private String result;
    private String message;

}
