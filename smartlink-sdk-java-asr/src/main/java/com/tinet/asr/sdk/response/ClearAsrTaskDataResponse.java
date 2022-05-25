package com.tinet.asr.sdk.response;


import com.tinet.asr.sdk.model.AsrTaskData;
import com.tinet.asr.sdk.model.SentenceResult;
import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Map;

/**
 * 清理AsrTaskData缓存response
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ClearAsrTaskDataResponse extends BaseResponse {

    /**
     * 返回结果
     */
    private Map result;
}
