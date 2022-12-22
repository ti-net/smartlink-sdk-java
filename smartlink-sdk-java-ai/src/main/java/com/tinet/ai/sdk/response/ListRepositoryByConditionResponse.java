package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.KbRepositoryResponseModel;
import com.tinet.smartlink.sdk.core.response.BaseResponse;

import java.util.List;

/**
 * 根据条件查询知识库列表响应
 *
 * @author feizq
 * @date 2022/12/08
 **/
public class ListRepositoryByConditionResponse extends BaseResponse {

    private List<KbRepositoryResponseModel> repositories;

    public List<KbRepositoryResponseModel> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<KbRepositoryResponseModel> repositories) {
        this.repositories = repositories;
    }
}
