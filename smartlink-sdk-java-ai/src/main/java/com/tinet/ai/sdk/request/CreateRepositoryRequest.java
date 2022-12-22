package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.CreateRepositoryResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 创建知识库
 *
 * @author feizq
 * @date 2022/12/08
 **/
public class CreateRepositoryRequest extends BaseRequest<CreateRepositoryResponse> {

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

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 应用场景  座席知识库:1   机器人知识库:2  座席和机器人均勾选:3
     */
    private Integer scenes;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
        if (type != null) {
            putBodyParameter("type", type);
        }
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
        if (createUser != null) {
            putBodyParameter("createUser", createUser);
        }
    }

    public Integer getScenes() {
        return scenes;
    }

    public void setScenes(Integer scenes) {
        this.scenes = scenes;
        if (scenes != null) {
            putBodyParameter("scenes", scenes);
        }
    }

    public CreateRepositoryRequest() {
        super("/api/createRepository", HttpMethodType.POST);
    }

    @Override
    public Class<CreateRepositoryResponse> getResponseClass() {
        return CreateRepositoryResponse.class;
    }
}
