package com.tinet.sqc.sdk.request;

import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;
import com.tinet.sqc.sdk.model.AsrText;
import com.tinet.sqc.sdk.response.PushAsrTextResponse;

/**
 * 推送AsrText文件
 *
 * @author wenjd
 * @date 2019/04/01
 */
public class PushAsrTextRequest extends BaseRequest<PushAsrTextResponse> {

    /**
     * 记录唯一标识
     */
    private String uniqueId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 转写文本对象
     */
    private AsrText asrText;

    /**
     * N：双轨先说话侧 ，OUT：双轨后说话侧，ALL：单轨不分侧
     */
    private String recordSide;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
        if (uniqueId != null) {
            putBodyParameter("uniqueId", uniqueId);
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

    public AsrText getAsrText() {
        return asrText;
    }

    public void setAsrText(AsrText asrText) {
        this.asrText = asrText;
        if (asrText != null) {
            putBodyParameter("asrText", asrText);
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

    public PushAsrTextRequest() {
        super("/sqc/asr_text", HttpMethodType.POST);
    }

    @Override
    public Class<PushAsrTextResponse> getResponseClass() {
        return PushAsrTextResponse.class;
    }
}
