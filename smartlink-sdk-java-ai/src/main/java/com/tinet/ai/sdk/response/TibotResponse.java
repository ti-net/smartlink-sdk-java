package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.Bot;
import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Json输出封装类
 * @author hy
 *
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TibotResponse extends BaseResponse {

    private List<Bot> tibots;
}
