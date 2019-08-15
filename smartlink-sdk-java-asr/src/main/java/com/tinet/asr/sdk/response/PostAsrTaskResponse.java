package com.tinet.asr.sdk.response;


import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 创建录音文件转写response
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PostAsrTaskResponse extends BaseResponse {

    /**
     * 任务ID
     */
    private String taskId;

}
