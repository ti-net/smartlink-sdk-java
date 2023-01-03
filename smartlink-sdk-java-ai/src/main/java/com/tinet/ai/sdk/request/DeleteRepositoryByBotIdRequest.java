package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.DeleteRepositoryByBotIdResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 根据机器人ID删除知识库请求
 *
 * @author feizq
 * @date 2022/11/29
 **/
public class DeleteRepositoryByBotIdRequest extends BaseRequest<DeleteRepositoryByBotIdResponse> {

    /**
     * 机器人ID
     */
    private String botId;

    public String getBotId() {
        return botId;
    }

    public void setBotId(String botId) {
        this.botId = botId;
        if (botId != null) {
            putQueryParameter("botId", botId);
        }
    }

    public DeleteRepositoryByBotIdRequest() {
        super("/api/deleteByBotId", HttpMethodType.DELETE);
    }

    @Override
    public Class getResponseClass() {
        return DeleteRepositoryByBotIdResponse.class;
    }
}
