package com.tinet.ai.sdk.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;

import java.util.List;

/**
 * 根据条件查询知识库目录列表响应
 *
 * @author feizq
 * @date 2022/12/08
 **/
public class ListDirectoryByConditionResponse extends BaseResponse {

    private List<KbDirectoriesResponse> directories;

    public List<KbDirectoriesResponse> getDirectories() {
        return directories;
    }

    public void setDirectories(List<KbDirectoriesResponse> directories) {
        this.directories = directories;
    }
}
