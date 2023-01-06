package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.KbDirectoryResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 目录修改请求
 *
 * @author feizq
 * @date 2021/12/21
 **/
public class UpdateKbDirectoryRequest extends BaseRequest<KbDirectoryResponse> {

    /**
     * 目录ID
     */
    private Integer id;

    /**
     * 企业ID
     */
    private String enterpriseId;

    /**
     * 目录名称
     */
    private String name;

    /**
     * 知识库ID
     */
    private Integer kbId;

    /**
     * 父节点ID
     */
    private Integer parentId;

    /**
     * 是否叶子节点 0 非叶子节点 1 叶子
     */
    private Integer leaf;

    /**
     * 所属人
     */
    private String owner;

    /**
     * 该节点所在的同级目录的节点id，排序
     */
    private String sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        if (id != null) {
            putBodyParameter("id", id);
        }
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putBodyParameter("enterpriseId", enterpriseId);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        if (name != null) {
            putBodyParameter("name", name);
        }
    }

    public Integer getKbId() {
        return kbId;
    }

    public void setKbId(Integer kbId) {
        this.kbId = kbId;
        if (kbId != null) {
            putBodyParameter("kbId", kbId);
        }
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
        if (parentId != null) {
            putBodyParameter("parentId", parentId);
        }
    }

    public Integer getLeaf() {
        return leaf;
    }

    public void setLeaf(Integer leaf) {
        this.leaf = leaf;
        if (leaf != null) {
            putBodyParameter("leaf", leaf);
        }
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
        if (owner != null) {
            putBodyParameter("owner", owner);
        }
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
        if (sort != null) {
            putBodyParameter("sort", sort);
        }
    }

    public UpdateKbDirectoryRequest() {
        super("/api/directories", HttpMethodType.PUT);
    }

    @Override
    public Class<KbDirectoryResponse> getResponseClass() {
        return KbDirectoryResponse.class;
    }
}
