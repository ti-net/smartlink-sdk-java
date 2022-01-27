package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.KbRepositoryResponseModel;
import com.tinet.smartlink.sdk.core.response.BaseResponse;

/**
 * 知识库详情响应
 *
 * @author feizq
 * @date 2021/12/21
 **/
public class DescribeKbRepositoryResponse extends BaseResponse {

    private KbRepositoryResponseModel repository;

    public KbRepositoryResponseModel getRepository() {
        return repository;
    }

    public void setRepository(KbRepositoryResponseModel repository) {
        this.repository = repository;
    }
}
