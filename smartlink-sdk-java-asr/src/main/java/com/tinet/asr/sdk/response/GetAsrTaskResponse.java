package com.tinet.asr.sdk.response;


import com.tinet.asr.sdk.model.SentenceResult;
import com.tinet.smartlink.commons.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 准写结果查询的response
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GetAsrTaskResponse extends BaseResponse {

    /**
     * 企业id(内部平台的任务必传)
     */
    private String userId;
    /**
     * 录音的唯一标识（内部凭条必传）
     */
    private String uniqueId;
    /**
     * 任务的Id
     */
    private String taskId;
    /**
     * 任务状态
     */
    private String status;
    /**
     * 转写时长
     */
    private Integer bizDuration;
    /**
     * 如果录音做了分轨，该录音是双轨录音的一侧，必须指定该录音文件是 agent/client ，便于区分两侧。agent是坐席侧client是客户侧，
     * 不传值默认是单轨录音.
     */
    private String recordSide;
    /**
     * 录音文件名
     */
    private String fileName;
    /**
     * 转写结果如果查询状态非成功状态时，此字段为null
     */
    private List<SentenceResult> result;
    /**
     * 错误码 如果查询状态成功或者转写中状态时，此字段为null
     */
    private Integer errorCode;


}
