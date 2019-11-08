package com.tinet.ai.sdk.request;

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

    private Integer offset;

    private Integer limit;

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
        super("/api/files", HttpMethodType.GET);
    }

    @Override
    public Class getResponseClass() {
        return KbFileResponse.class;
    }
}
