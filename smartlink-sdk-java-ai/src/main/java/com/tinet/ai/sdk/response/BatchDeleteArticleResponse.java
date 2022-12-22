package com.tinet.ai.sdk.response;

import com.tinet.smartlink.sdk.core.response.BaseResponse;

import java.util.List;

/**
 * 批量删除文章响应
 *
 * @author feizq
 * @date 2022/12/08
 **/
public class BatchDeleteArticleResponse extends BaseResponse {

    private List result;

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }
}
