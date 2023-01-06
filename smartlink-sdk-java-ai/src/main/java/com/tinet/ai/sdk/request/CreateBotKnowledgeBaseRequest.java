package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.model.KbBot;
import com.tinet.ai.sdk.response.CreateBotKnowledgeBaseResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

import java.util.List;

/**
 * 添加知识库和机器人关联关系请求
 *
 * @author feizq
 * @date 2022/11/29
 **/
public class CreateBotKnowledgeBaseRequest extends BaseRequest<CreateBotKnowledgeBaseResponse> {

    /**
     * 关联对象
     */
    private List<KbBot> botKnowledgeList;

    public List<KbBot> getBotKnowledgeList() {
        return botKnowledgeList;
    }

    public void setBotKnowledgeList(List<KbBot> botKnowledgeList) {
        this.botKnowledgeList = botKnowledgeList;
        if (botKnowledgeList != null) {
            putBodyParameter("botKnowledgeList", botKnowledgeList);
        }
    }

    public CreateBotKnowledgeBaseRequest() {
        super("/api/createBotKnowledgeBase", HttpMethodType.POST);
    }

    @Override
    public Class getResponseClass() {
        return CreateBotKnowledgeBaseResponse.class;
    }

}
