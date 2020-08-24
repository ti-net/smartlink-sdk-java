package com.tinet.sqc.sdk.request;

import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;
import com.tinet.sqc.sdk.response.CustomerPortraitResponse;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class for:
 *
 * @author yinzk
 * @date 2020/8/24
 */
public class CustomerPortraitRequest extends BaseRequest<CustomerPortraitResponse> {

    /**
     * 分页起始，默认为 0
     **/
    protected Integer offset = 0;

    /**
     * 分页大小，默认为 10
     **/
    protected Integer limit;
    /**
     * 客户号码
     */
    private Set<String> customerNumber = new HashSet<>();
    /**
     * 必须包含的标签
     */
    private List<String> portraits;

    public void setOffset(Integer offset) {
        this.offset = offset;
        if (offset != null) {
            putQueryParameter("offset", offset);
        }
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
        if (limit != null) {
            putQueryParameter("limit", limit);
        }
    }

    public void setCustomerNumber(Set<String> customerNumber) {
        this.customerNumber = customerNumber;
        if (customerNumber != null) {
            putQueryParameter("customerNumber", customerNumber);
        }
    }

    public void setPortraits(List<String> portraits) {
        this.portraits = portraits;
        if (portraits != null) {
            putQueryParameter("portraits", portraits);
        }
    }

    public CustomerPortraitRequest() {
        super("/sqc/customerPortrait", HttpMethodType.GET);
    }

    @Override
    public Class<CustomerPortraitResponse> getResponseClass() {
        return CustomerPortraitResponse.class;
    }
}
