package com.tinet.ai.sdk.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 搜索补全
 *
 * @author huwk
 * @date 2019/9/18
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class KbCorrectionResponse extends BaseResponse {

    private String result;

}
