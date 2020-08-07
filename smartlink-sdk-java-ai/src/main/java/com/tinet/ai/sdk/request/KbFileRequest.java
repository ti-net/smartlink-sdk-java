package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.model.enums.ChannelEnum;
import com.tinet.ai.sdk.model.enums.OrderRuleEnum;
import com.tinet.ai.sdk.response.KbFileResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 知识库文件列表请求
 *
 * @author huwk
 * @date 2019/9/18
 **/
public class KbFileRequest extends BaseRequest<KbFileResponse> {

    private String enterpriseId;

    private Integer kbId;

    private Integer directoryId;

    private String keyword;

    private String channelType;

    private Boolean pinyinStatus;

    private String order;

    private Integer offset;

    private Integer limit;

    private String cno;

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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
        if (keyword != null) {
            putQueryParameter("keyword", keyword);
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

    public KbFileRequest() {
        super("/api/files", HttpMethodType.GET, "2020-05-21");
    }

    @Override
    public Class getResponseClass() {
        return KbFileResponse.class;
    }
}
