package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.UpdateStandardQuestionResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 更新标准问请求
 *
 * @author feizq
 * @date 2022/06/15
 **/
public class UpdateStandardQuestionRequest extends BaseRequest<UpdateStandardQuestionResponse> {

    /**
     * 标准问ID
     */
    private Integer id;
    /**
     * 企业ID
     */
    private String enterpriseId;
    /**
     * 机器人ID
     */
    private String botId;
    /**
     * 标准问问题
     */
    private String title;
    /**
     * 分类ID
     */
    private Integer categoryId;
    /**
     * 标签ID集合
     */
    private String[] tagIdList;
    /**
     * 状态
     */
    private Integer status;

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

    public String getBotId() {
        return botId;
    }

    public void setBotId(String botId) {
        this.botId = botId;
        if (botId != null) {
            putBodyParameter("botId", botId);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        if (title != null) {
            putBodyParameter("title", title);
        }
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        if (categoryId != null) {
            putBodyParameter("categoryId", categoryId);
        }
    }

    public String[] getTagIdList() {
        return tagIdList;
    }

    public void setTagIdList(String[] tagIdList) {
        this.tagIdList = tagIdList;
        if (tagIdList != null) {
            putBodyParameter("tagIdList", tagIdList);
        }
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
        if (status != null) {
            putBodyParameter("status", status);
        }
    }

    public UpdateStandardQuestionRequest() {
        super("/api/botKnowledgeBase/emotibot/standardQuestion", HttpMethodType.PUT);
    }

    @Override
    public Class<UpdateStandardQuestionResponse> getResponseClass() {
        return UpdateStandardQuestionResponse.class;
    }
}
