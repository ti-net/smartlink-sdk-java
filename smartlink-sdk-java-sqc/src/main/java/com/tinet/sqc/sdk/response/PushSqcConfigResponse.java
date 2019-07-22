package com.tinet.sqc.sdk.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * class for
 * 推送的SQC数据库配置信息的返回结果
 *
 * @author yinzk
 * @date 2019/6/11
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PushSqcConfigResponse extends BaseResponse {

    private String result;
    private String message;
}
