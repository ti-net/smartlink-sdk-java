package com.tinet.sqc.sdk.request;

import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;
import com.tinet.sqc.sdk.response.ListCdrSqcDetailsResponse;

/**
 * 根据质检时间查询ES数据
 *
 * @author liuhongyu
 * @date 2019/12/20
 **/
public class ListCdrSqcDetailsRequest extends BaseRequest<ListCdrSqcDetailsResponse> {


    private String qcDate;

    private String scrollId;

    private Integer limit;

    private String userId;

    public String getQcDate() {
        return qcDate;
    }

    public void setQcDate(String qcDate) {
        this.qcDate = qcDate;
        if (qcDate != null) {
            putBodyParameter("qcDate", qcDate);
        }
    }

    public String getScrollId() {
        return scrollId;
    }

    public void setScrollId(String scrollId) {
        this.scrollId = scrollId;
        if (scrollId != null) {
            putBodyParameter("scrollId", scrollId);
        }
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
        if (userId != null) {
            putBodyParameter("userId", userId);
        }
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
        if (limit != null) {
            putBodyParameter("limit", limit);
        }
    }

    public ListCdrSqcDetailsRequest() {
        super("/sqc/listCdrSqcDetails", HttpMethodType.POST);
    }

    @Override
    public Class<ListCdrSqcDetailsResponse> getResponseClass() {
        return ListCdrSqcDetailsResponse.class;
    }
}
