package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.model.CorpusRecordModel;
import com.tinet.ai.sdk.response.CreateCorpusResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

import java.util.List;

/**
 * 创建语料请求
 *
 * @author feizq
 * @date 2022/06/15
 **/
public class CreateCorpusRequest extends BaseRequest<CreateCorpusResponse> {

    /**
     * 企业ID
     */
    private String enterpriseId;
    /**
     * 机器人ID
     */
    private String botId;
    /**
     * 语料记录集合
     */
    private List<CorpusRecordModel> records;

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

    public List<CorpusRecordModel> getRecords() {
        return records;
    }

    public void setRecords(List<CorpusRecordModel> records) {
        this.records = records;
        if (records != null) {
            putBodyParameter("records", records);
        }
    }

    public CreateCorpusRequest() {
        super("/api/botKnowledgeBase/emotibot/corpus", HttpMethodType.POST);
    }

    @Override
    public Class<CreateCorpusResponse> getResponseClass() {
        return CreateCorpusResponse.class;
    }
}
