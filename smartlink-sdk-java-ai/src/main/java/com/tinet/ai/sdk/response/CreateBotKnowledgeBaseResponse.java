package com.tinet.ai.sdk.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;

/**
 * 添加知识库和机器人关联关系响应
 *
 * @author feizq
 * @date 2022/11/29
 **/
public class CreateBotKnowledgeBaseResponse extends BaseResponse {

    private Integer result;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
