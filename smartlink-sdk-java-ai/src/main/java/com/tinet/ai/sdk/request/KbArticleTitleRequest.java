package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.KbArticleTitleResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 知识库文章相似问题推荐
 *
 * @author huwk
 * @date 2019/9/18
 **/
public class KbArticleTitleRequest extends BaseRequest<KbArticleTitleResponse> {
    /**
     * 企业id
     */
    private String enterpriseId;
    /**
     * 知识库id
     */
    private Integer kbId;
    /**
     * 目录id
     */
    private Integer directoryId;
    /**
     * 关键词
     */
    private String keyword;

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

    public KbArticleTitleRequest() {
        super("/api/article/title", HttpMethodType.GET);
    }

    @Override
    public Class getResponseClass() {
        return KbArticleTitleResponse.class;
    }
}
