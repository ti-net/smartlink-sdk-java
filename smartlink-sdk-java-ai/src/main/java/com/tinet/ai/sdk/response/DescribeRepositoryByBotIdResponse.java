package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.KbRepositoryResponseModel;
import com.tinet.smartlink.sdk.core.response.BaseResponse;

/**
 * 根据 机器人id 获取机器人绑定的问答库 响应
 *
 * @author feizq
 * @date 2022/12/08
 **/
public class DescribeRepositoryByBotIdResponse extends BaseResponse {

    private KbRepositoryResponseModel repository;

    public KbRepositoryResponseModel getRepository() {
        return repository;
    }

    public void setRepository(KbRepositoryResponseModel repository) {
        this.repository = repository;
    }
}
