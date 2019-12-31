package com.tinet.sqc.sdk.request;

import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;
import com.tinet.sqc.sdk.response.ListCdrDetailsByUniqueIdListResponse;

import java.util.List;

/**
 * 根据uniqueId批量获取话单详情
 *
 * @author liuhongyu
 * @date 2019/12/20
 **/
public class ListCdrDetailsByUniqueIdListRequest extends BaseRequest<ListCdrDetailsByUniqueIdListResponse> {


    private List<String> uniqueIdList;

    private String userId;

    public List<String> getUniqueIdList() {
        return uniqueIdList;
    }

    public void setUniqueIdList(List<String> uniqueIdList) {
        this.uniqueIdList = uniqueIdList;
        if (uniqueIdList != null) {
            putQueryParameter("uniqueIdList", uniqueIdList);
        }
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
        if (userId != null) {
            putQueryParameter("userId", userId);
        }
    }

    public ListCdrDetailsByUniqueIdListRequest() {
        super("/sqc/listCdrDetailsByUniqueIdList", HttpMethodType.GET);
    }

    @Override
    public Class<ListCdrDetailsByUniqueIdListResponse> getResponseClass() {
        return ListCdrDetailsByUniqueIdListResponse.class;
    }
}
