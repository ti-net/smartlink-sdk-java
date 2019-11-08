package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.KbRepositoryResponseModel;
import com.tinet.smartlink.sdk.core.response.BaseResponse;

import java.util.List;

/**
 * 知识库仓库列表响应
 *
 * @author huwk
 * @date 2019/9/19
 **/
public class KbRepositoryResponse extends BaseResponse {

    private List<KbRepositoryResponseModel> repositories;

    public List<KbRepositoryResponseModel> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<KbRepositoryResponseModel> repositories) {
        this.repositories = repositories;
    }
}
