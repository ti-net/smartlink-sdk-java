package com.tinet.asr.sdk.request;


import com.tinet.asr.sdk.response.GetAsrTaskResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 转写结果查询request
 * @author 王大宝
 */
public class GetAsrTaskRequest extends BaseRequest<GetAsrTaskResponse> {


    /**
     * 企业id(内部平台的任务必传)
     */
    private String userId;
    /**
     * 录音的唯一标识（内部凭条必传）
     */
    private String uniqueId;
    /**
     * 如果录音做了分轨，该录音是双轨录音的一侧，必须指定该录音文件是 agent/client ，便于区分两侧。agent是坐席侧client是客户侧，
     * 不传值默认是单轨录音.
     */
    private String recordSide;
    /**
     * 可以自主选择转写引擎，不传值默认是天润自建引擎，（具体支持哪种转写引擎，可以后期商定）
     */
    private String asrProvider;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
        if (userId != null) {
            putQueryParameter("userId", userId);
        }
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
        if (uniqueId != null) {
            putQueryParameter("uniqueId", uniqueId);
        }
    }

    public String getRecordSide() {
        return recordSide;
    }

    public void setRecordSide(String recordSide) {
        this.recordSide = recordSide;
        if (recordSide != null) {
            putQueryParameter("recordSide", recordSide);
        }
    }

    public String getAsrProvider() {
        return asrProvider;
    }

    public void setAsrProvider(String asrProvider) {
        this.asrProvider = asrProvider;
        if (asrProvider != null) {
            putQueryParameter("asrProvider", asrProvider);
        }
    }

    public GetAsrTaskRequest() {

        super("/asr/task/", HttpMethodType.GET);
    }

    @Override
    public Class<GetAsrTaskResponse> getResponseClass() {
        return GetAsrTaskResponse.class;
    }
}
