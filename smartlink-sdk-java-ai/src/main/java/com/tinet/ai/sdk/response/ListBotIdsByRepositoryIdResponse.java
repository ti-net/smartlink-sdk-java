package com.tinet.ai.sdk.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;

import java.util.List;

/**
 * 通过 kbId 查找 botIds 响应
 *
 * @author feizq
 * @date 2022/11/29
 **/
public class ListBotIdsByRepositoryIdResponse extends BaseResponse {

    private List<String> result;

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }
}
