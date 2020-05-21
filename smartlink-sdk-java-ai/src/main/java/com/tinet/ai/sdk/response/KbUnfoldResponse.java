package com.tinet.ai.sdk.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 点击展开
 *
 * @author huwk
 * @date 2019/9/18
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class KbUnfoldResponse extends BaseResponse {

    private String message;

}
