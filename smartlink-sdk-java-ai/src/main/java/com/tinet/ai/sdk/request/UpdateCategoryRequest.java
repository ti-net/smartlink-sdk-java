package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.UpdateCategoryResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * @author feizq
 * @date 2022/06/20
 **/
public class UpdateCategoryRequest extends BaseRequest<UpdateCategoryResponse> {

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
     * 分类ID
     */
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        if (id != null) {
            putBodyParameter("id", id);
        }
    }

    public UpdateCategoryRequest() {
        super("/api/botKnowledgeBase/emotibot/category", HttpMethodType.PUT);
    }

    @Override
    public Class<UpdateCategoryResponse> getResponseClass() {
        return UpdateCategoryResponse.class;
    }
}
