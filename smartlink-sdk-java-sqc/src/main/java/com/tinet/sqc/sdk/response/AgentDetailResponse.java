package com.tinet.sqc.sdk.response;


import com.tinet.smartlink.sdk.core.response.BaseResponse;
import com.tinet.sqc.sdk.model.AgentDetail;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author wenjd
 * @date 2019/04/01
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AgentDetailResponse extends BaseResponse {

    private List<AgentDetail> result;
    private String message;

}

