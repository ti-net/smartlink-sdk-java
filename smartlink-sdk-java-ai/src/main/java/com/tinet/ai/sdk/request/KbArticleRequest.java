package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.model.enums.ChannelEnum;
import com.tinet.ai.sdk.model.enums.OrderRuleEnum;
import com.tinet.ai.sdk.response.KbArticleResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 知识库文章列表请求
 *
 * @author huwk
 * @date 2019/9/18
 **/
public class KbArticleRequest extends BaseRequest<KbArticleResponse> {

    private String cno;

    private String enterpriseId;

    private Integer kbId;

    private Integer directoryId;

    private String channelType;

    private String keyword;

    private Boolean pinyinStatus;

    private String order;

    private Integer offset;

    private Integer limit;

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
        if (cno != null) {
            putQueryParameter("cno", cno);
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

    public Integer getKbId() {
        return kbId;
    }

    public void setKbId(Integer kbId) {
        this.kbId = kbId;
        if (kbId != null) {
            putQueryParameter("kbId", kbId);
        }
    }

    public Integer getDirectoryId() {
        return directoryId;
    }

    public void setDirectoryId(Integer directoryId) {
        this.directoryId = directoryId;
        if (directoryId != null) {
            putQueryParameter("directoryId", directoryId);
        }
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(ChannelEnum channelEnum) {
        this.channelType = channelEnum.getValue();
        if (channelType != null) {
            putQueryParameter("channelType", channelType);
        }
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
        if (keyword != null) {
            putQueryParameter("keyword", keyword);
        }
    }

    public Boolean getPinyinStatus() {
        return pinyinStatus;
    }

    public void setPinyinStatus(Boolean pinyinStatus) {
        this.pinyinStatus = pinyinStatus;
        if (pinyinStatus != null) {
            putQueryParameter("pinyinStatus", pinyinStatus);
        }
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(OrderRuleEnum orderRuleEnum) {
        this.order = orderRuleEnum.getRule();
        if (order != null) {
            putQueryParameter("order", order);
        }
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
        if (offset != null) {
            putQueryParameter("offset", offset);
        }
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
        if (limit != null) {
            putQueryParameter("limit", limit);
        }
    }

    public KbArticleRequest() {
        super("/api/articles", HttpMethodType.GET, "2020-09-01");
    }

    @Override
    public Class getResponseClass() {
        return KbArticleResponse.class;
    }
}
