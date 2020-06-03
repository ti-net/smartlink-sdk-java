package com.tinet.assistant.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class TibotResponse extends BaseResponse {

    private String requestId;

    private List<Bot> tbots;
}
