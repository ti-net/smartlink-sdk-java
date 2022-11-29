package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.DeleteRepositoryByBotIdResponse;
import com.tinet.ai.sdk.response.ListBotIdsByRepositoryIdResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 通过 kbId 查找 botIds
 *
 * @author feizq
 * @date 2022/11/29
 **/
public class ListBotIdsByRepositoryIdRequest extends BaseRequest<ListBotIdsByRepositoryIdResponse> {

    /**
     * 知识库ID
     */
    private Integer kbId;

    public Integer getKbId() {
        return kbId;
    }

    public void setKbId(Integer kbId) {
        this.kbId = kbId;
        if (kbId != null) {
            putQueryParameter("kbId", kbId);
        }
    }

    public ListBotIdsByRepositoryIdRequest() {
        super("/api/listBotIdsByRepositoryId", HttpMethodType.GET);
    }

    @Override
    public Class getResponseClass() {
        return ListBotIdsByRepositoryIdResponse.class;
    }
}
