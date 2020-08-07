package com.tinet.ai.sdk.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 搜索补全
 *
 * @author huwk
 * @date 2019/9/18
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class KbSuggestResponse extends BaseResponse {

    private List<String> result;

}
