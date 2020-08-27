package com.tinet.sqc.sdk.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tinet.smartlink.sdk.core.response.PagedResponse;
import com.tinet.sqc.sdk.model.CustomerPortrait;
import lombok.Data;

import java.util.List;

/**
 * Class for:
 * <p>
 * 客户画像外放接口，
 *
 * @author yinzk
 * @date 2020/8/24
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerPortraitResponse extends PagedResponse {
    /**
     * 请求id
     */
    private String requestId;
    /**
     * 分页结果
     */
    private List<CustomerPortrait> data;
}
