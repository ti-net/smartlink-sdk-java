package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.DeleteCategoryResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 删除分类请求
 *
 * @author feizq
 * @date 2022/06/20
 **/
public class DeleteCategoryRequest extends BaseRequest<DeleteCategoryResponse> {

    /**
     * 企业ID
     */
    private String enterpriseId;
    /**
     * 机器人ID
     */
    private String botId;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        if (id != null) {
            putBodyParameter("id", id);
        }
    }

    public DeleteCategoryRequest() {
        super("/api/botKnowledgeBase/emotibot/deleteCategory", HttpMethodType.POST);
    }

    @Override
    public Class<DeleteCategoryResponse> getResponseClass() {
        return DeleteCategoryResponse.class;
    }
}
