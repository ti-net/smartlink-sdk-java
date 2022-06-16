package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.UpdateCorpusResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * @author feizq
 * @date 2022/06/15
 **/
public class UpdateCorpusRequest extends BaseRequest<UpdateCorpusResponse> {

    /**
     * 企业ID
     */
    private String enterpriseId;
    /**
     * 机器人ID
     */
    private String botId;
    /**
     * 标准问ID
     */
    private Integer sqId;
    /**
     * 原始语料名称
     */
    private String sourceCorpusName;
    /**
     * 要修改语料名称
     */
    private String targetCorpusName;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putBodyParameter("enterpriseId", enterpriseId);
        }
    }

    public String getBotId() {
        return botId;
    }

    public void setBotId(String botId) {
        this.botId = botId;
        if (botId != null) {
            putBodyParameter("botId", botId);
        }
    }

    public Integer getSqId() {
        return sqId;
    }

    public void setSqId(Integer sqId) {
        this.sqId = sqId;
        if (sqId != null) {
            putBodyParameter("sqId", sqId);
        }
    }

    public String getSourceCorpusName() {
        return sourceCorpusName;
    }

    public void setSourceCorpusName(String sourceCorpusName) {
        this.sourceCorpusName = sourceCorpusName;
        if (sourceCorpusName != null) {
            putBodyParameter("sourceCorpusName", sourceCorpusName);
        }
    }

    public String getTargetCorpusName() {
        return targetCorpusName;
    }

    public void setTargetCorpusName(String targetCorpusName) {
        this.targetCorpusName = targetCorpusName;
        if (targetCorpusName != null) {
            putBodyParameter("targetCorpusName", targetCorpusName);
        }
    }

    public UpdateCorpusRequest() {
        super("/api/botKnowledgeBase/emotibot/corpus", HttpMethodType.PUT);
    }

    @Override
    public Class<UpdateCorpusResponse> getResponseClass() {
        return UpdateCorpusResponse.class;
    }
}
