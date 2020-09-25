package com.tinet.ai.sdk.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 最优话术点赞点踩响应
 *
 * @author zhaojy
 * @date 2020/9/9
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class CallScriptLikeResponse extends BaseResponse {

    private Boolean result;

}
