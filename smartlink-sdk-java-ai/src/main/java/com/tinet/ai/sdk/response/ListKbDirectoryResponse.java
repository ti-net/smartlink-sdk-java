package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.KbDirectory;
import com.tinet.smartlink.sdk.core.response.BaseResponse;

import java.util.List;

/**
 * 获取个人知识库的目录列表响应
 *
 * @author feizq
 * @date 2021/12/21
 **/
public class ListKbDirectoryResponse extends BaseResponse {

    private List<KbDirectory> result;

    public List<KbDirectory> getResult() {
        return result;
    }

    public void setResult(List<KbDirectory> result) {
        this.result = result;
    }
}
