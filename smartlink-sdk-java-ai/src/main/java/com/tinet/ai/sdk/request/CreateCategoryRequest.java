package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.CreateCategoryResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * @author feizq
 * @date 2022/06/20
 **/
public class CreateCategoryRequest extends BaseRequest<CreateCategoryResponse> {

    /**
     * 企业ID
     */
    private String enterpriseId;
    /**
     * 机器人ID
     */
    private String botId;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 父类ID，一级分类，父类ID为0
     */
    private Integer parentId;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putBodyParameter("enterpriseId", enterpriseId);
        }
    }

    public String getBotId() {
        return botId;
    }

    public void setBotId(String botId) {
        this.botId = botId;
        if (botId != null) {
            putBodyParameter("botId", botId);
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
        if (parentId != null) {
            putBodyParameter("parentId", parentId);
        }
    }

    public CreateCategoryRequest() {
        super("/api/botKnowledgeBase/emotibot/category", HttpMethodType.POST);
    }

    @Override
    public Class<CreateCategoryResponse> getResponseClass() {
        return CreateCategoryResponse.class;
    }
}
