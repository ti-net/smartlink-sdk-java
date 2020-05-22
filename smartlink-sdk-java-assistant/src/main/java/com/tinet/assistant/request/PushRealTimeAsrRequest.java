package com.tinet.assistant.request;

import com.tinet.assistant.response.PushRealTimeAsrResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;
import lombok.Getter;

/**
 * 推送 实时转写 请求
 *
 * @author zhaojy
 * @date 2020/05/21
 **/
@Getter
public class PushRealTimeAsrRequest extends BaseRequest<PushRealTimeAsrResponse> {

    private String enterpriseId;

    /**
     * 秒级时间戳
     */
    private String timestamp;

    /**
     *  md5{enterpriseId+token+timestamp)
     */
    private String sign;

    /**
     *  0:座席侧 1:客户侧
     */
    private Integer side;

    /**
     * 需要分析的文本  (转写结果)
     */
    private String text;

    /**
     * 转写结果类型  中间结果: intermediateResult 完整句子:sentenceEnd
     */
    private String type;


    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putBodyParameter("enterpriseId", enterpriseId);
        }
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        if (timestamp != null) {
            putBodyParameter("timestamp", timestamp);
        }
    }

    public void setSign(String sign) {
        this.sign = sign;
        if (sign != null) {
            putBodyParameter("sign", sign);
        }
    }

    public void setSide(Integer side) {
        this.side = side;
        if (side != null) {
            putBodyParameter("side", side);
        }
    }

    public void setText(String text) {
        this.text = text;
        if (text != null) {
            putBodyParameter("text", text);
        }
    }

    public void setType(String type) {
        this.type = type;
        if (type != null) {
            putBodyParameter("type", type);
        }
    }


    public PushRealTimeAsrRequest() {
        super("/api/asr", HttpMethodType.POST);
    }

    @Override
    public Class getResponseClass() {
        return PushRealTimeAsrResponse.class;
    }

}
