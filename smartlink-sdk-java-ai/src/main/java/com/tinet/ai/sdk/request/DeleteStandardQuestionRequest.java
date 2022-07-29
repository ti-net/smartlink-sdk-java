package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.DeleteStandardQuestionResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 删除标准问请求
 *
 * @author feizq
 * @date 2022/06/15
 **/
public class DeleteStandardQuestionRequest extends BaseRequest<DeleteStandardQuestionResponse> {

    /**
     * 企业ID
     */
    private String enterpriseId;
    /**
     * 机器人ID
     */
    private String botId;
    /**
     * 标准问id数组
     */
    private Integer[] ids;

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

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
        if (ids != null) {
            putBodyParameter("ids", ids);
        }
    }

    public DeleteStandardQuestionRequest() {
        super("/api/botKnowledgeBase/emotibot/deleteStandardQuestion", HttpMethodType.POST);
    }

    @Override
    public Class<DeleteStandardQuestionResponse> getResponseClass() {
        return DeleteStandardQuestionResponse.class;
    }
}
