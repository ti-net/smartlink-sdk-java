package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.model.enums.ChannelEnum;
import com.tinet.ai.sdk.model.enums.OrderRuleEnum;
import com.tinet.ai.sdk.response.KbSearchResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

import java.util.List;

/**
 * 知识库搜索请求
 *
 * @author feizq
 * @date 2022/07/05
 **/
public class KbSearchRequest extends BaseRequest<KbSearchResponse> {

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

    private String[] highlight;

    private Integer repositoryType;

    private List<String> qnos;

    public List<String> getQnos() {
        return qnos;
    }

    public void setQnos(List<String> qnos) {
        this.qnos = qnos;
        if (qnos != null) {
            putQueryParameter("qnos", qnos);
        }
    }

    public Integer getRepositoryType() {
        return repositoryType;
    }

    public void setRepositoryType(Integer repositoryType) {
        this.repositoryType = repositoryType;
        if (repositoryType != null) {
            putQueryParameter("type", repositoryType);
        }
    }

    public String[] getHighlight() {
        return highlight;
    }

    public void setHighlight(String[] highlight) {
        this.highlight = highlight;
        if (highlight != null) {
            putQueryParameter("highlight", highlight);
        }
    }

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

    public KbSearchRequest() {
        super("/api/articles", HttpMethodType.GET, "2022-07-04");
    }

    @Override
    public Class getResponseClass() {
        return KbSearchResponse.class;
    }
}
