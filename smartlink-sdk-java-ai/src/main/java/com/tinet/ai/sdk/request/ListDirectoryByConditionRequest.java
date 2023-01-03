package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.ListDirectoryByConditionResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 根据条件查询知识库目录列表
 *
 * @author feizq
 * @date 2022/12/08
 **/
public class ListDirectoryByConditionRequest extends BaseRequest<ListDirectoryByConditionResponse> {

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
     * 知识库路径
     */
    private String path;

    /**
     * 知识库ID
     */
    private Integer kbId;

    /**
     * 父ID
     */
    private Integer parentId;

    /**
     * 是否是叶子节点
     */
    private Integer leaf;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
        if (path != null) {
            putQueryParameter("path", path);
        }
    }

    public Integer getKbId() {
        return kbId;
    }

    public void setKbId(Integer kbId) {
        this.kbId = kbId;
        if (kbId != null) {
            putQueryParameter("kbId", kbId);
        }
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
        if (parentId != null) {
            putQueryParameter("parentId", parentId);
        }
    }

    public Integer getLeaf() {
        return leaf;
    }

    public void setLeaf(Integer leaf) {
        this.leaf = leaf;
        if (leaf != null) {
            putQueryParameter("leaf", leaf);
        }
    }

    public ListDirectoryByConditionRequest() {
        super("/api/listDirectoryByCondition", HttpMethodType.GET);
    }

    @Override
    public Class<ListDirectoryByConditionResponse> getResponseClass() {
        return ListDirectoryByConditionResponse.class;
    }
}
