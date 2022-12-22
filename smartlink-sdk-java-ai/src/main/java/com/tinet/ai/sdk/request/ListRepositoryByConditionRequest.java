package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.ListRepositoryByConditionResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 根据条件查询知识库列表
 *
 * @author feizq
 * @date 2022/12/08
 **/
public class ListRepositoryByConditionRequest  extends BaseRequest<ListRepositoryByConditionResponse> {

    /**
     * 账号名称
     */
    private String accountLoginName;

    /**
     * 企业ID
     */
    private String enterpriseId;

    /**
     * 知识库名称
     */
    private String name;

    /**
     * 知识库类型
     */
    private Integer type;

    public String getAccountLoginName() {
        return accountLoginName;
    }

    public void setAccountLoginName(String accountLoginName) {
        this.accountLoginName = accountLoginName;
        if (accountLoginName != null) {
            putQueryParameter("accountLoginName", accountLoginName);
        }
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putQueryParameter("enterpriseId", enterpriseId);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        if (name != null) {
            putQueryParameter("name", name);
        }
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
        if (type != null) {
            putQueryParameter("type", type);
        }
    }

    public ListRepositoryByConditionRequest() {
        super("/api/listRepositoryByCondition", HttpMethodType.GET);
    }

    @Override
    public Class<ListRepositoryByConditionResponse> getResponseClass() {
        return ListRepositoryByConditionResponse.class;
    }
}
