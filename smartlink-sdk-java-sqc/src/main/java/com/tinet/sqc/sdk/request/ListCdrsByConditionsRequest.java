package com.tinet.sqc.sdk.request;

import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;
import com.tinet.sqc.sdk.response.ListCdrsByConditionsResponse;

import java.util.List;

public class ListCdrsByConditionsRequest extends BaseRequest<ListCdrsByConditionsResponse> {

    private List<String> uniqueIdList;

    private String startChannelTime;

    private String endChannelTime;

    public List<String> getUniqueIdList() {
        return uniqueIdList;
    }

    public void setUniqueIdList(List<String> uniqueIdList) {
        this.uniqueIdList = uniqueIdList;
        if(uniqueIdList != null){
            putQueryParameter("uniqueIdList",uniqueIdList);
        }
    }

    public String getStartChannelTime() {
        return startChannelTime;
    }

    public void setStartChannelTime(String startChannelTime) {
        this.startChannelTime = startChannelTime;
        if(startChannelTime != null){
            putQueryParameter("startChannelTime",startChannelTime);
        }
    }

    public String getEndChannelTime() {
        return endChannelTime;
    }

    public void setEndChannelTime(String endChannelTime) {
        this.endChannelTime = endChannelTime;
        if(endChannelTime != null){
            putQueryParameter("endChannelTime",endChannelTime);
        }
    }

    public ListCdrsByConditionsRequest() {
        super("/sqc/listCdrsByConditions", HttpMethodType.GET);
    }

    @Override
    public Class<ListCdrsByConditionsResponse> getResponseClass() {
        return ListCdrsByConditionsResponse.class;
    }
}
