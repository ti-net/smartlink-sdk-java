package com.tinet.ai.sdk.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tinet.ai.sdk.model.Bot;
import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Json输出封装类
 * @author zhaojy
 *
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BotResponse extends BaseResponse {

    private String requestId;

    private Bot bot;
}
