package com.tinet.asr.sdk.request;


import com.tinet.asr.sdk.response.PostAsrTaskResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 创建录音文件转写任务的request
 */
public class PostAsrTaskRequest extends BaseRequest<PostAsrTaskResponse> {

    /**
     * 录音访问地址
     */
    private String fileUrl;
    /**
     * 录音文件名
     */
    private String fileName;
    /**
     * 回调地址
     */
    private String callbackUrl;
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

    /**
     * 是否开启慧智
     */
    private Boolean enableSqc;

    public Boolean getEnableSqc() {
        return enableSqc;
    }

    public void setEnableSqc(Boolean enableSqc) {
        this.enableSqc = enableSqc;
        if (enableSqc != null) {
            putBodyParameter("enableSqc", enableSqc);
        }
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
        if (fileUrl != null) {
            putBodyParameter("fileUrl", fileUrl);
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        if (fileName != null) {
            putBodyParameter("fileName", fileName);
        }
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        if (callbackUrl != null) {
            putBodyParameter("callbackUrl", callbackUrl);
        }
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
        if (userId != null) {
            putBodyParameter("userId", userId);
        }
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
        if (uniqueId != null) {
            putBodyParameter("uniqueId", uniqueId);
        }
    }

    public String getRecordSide() {
        return recordSide;
    }

    public void setRecordSide(String recordSide) {
        this.recordSide = recordSide;
        if (recordSide != null) {
            putBodyParameter("recordSide", recordSide);
        }
    }

    public String getAsrProvider() {
        return asrProvider;
    }

    public void setAsrProvider(String asrProvider) {
        this.asrProvider = asrProvider;
        if (asrProvider != null) {
            putBodyParameter("asrProvider", asrProvider);
        }
    }

    public PostAsrTaskRequest() {
        super("/asr/task", HttpMethodType.POST);
    }

    @Override
    public Class getResponseClass() {
        return PostAsrTaskResponse.class;
    }
}
