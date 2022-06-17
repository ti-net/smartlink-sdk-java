package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.DeleteCorpusResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

import java.util.List;

/**
 * @author feizq
 * @date 2022/06/15
 **/
public class DeleteCorpusRequest extends BaseRequest<DeleteCorpusResponse> {

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
     * 语料名称
     */
    private List<String> corpusNames;

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

    public List<String> getCorpusNames() {
        return corpusNames;
    }

    public void setCorpusNames(List<String> corpusNames) {
        this.corpusNames = corpusNames;
        if (corpusNames != null) {
            putBodyParameter("corpusNames", corpusNames);
        }
    }

    public DeleteCorpusRequest() {
        super("/api/botKnowledgeBase/emotibot/deleteCorpus", HttpMethodType.POST);
    }

    @Override
    public Class<DeleteCorpusResponse> getResponseClass() {
        return DeleteCorpusResponse.class;
    }
}
