package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.PageFaqArticleResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 分页获取机器人问答库
 *
 * @author feizq
 * @date 2022/11/29
 **/
public class PageFaqArticleRequest extends BaseRequest<PageFaqArticleResponse> {

    /**
     * 机器人ID
     */
    private String botId;

    /**
     * 知识库类型；0 问答库，默认为0
     */
    private Integer kbType;

    /**
     * 偏移量
     */
    private Integer offset;

    /**
     * 查询记录条数
     */
    private Integer limit;

    public String getBotId() {
        return botId;
    }

    public void setBotId(String botId) {
        this.botId = botId;
        if (botId != null) {
            putQueryParameter("botId", botId);
        }
    }

    public Integer getKbType() {
        return kbType;
    }

    public void setKbType(Integer kbType) {
        this.kbType = kbType;
        if (kbType != null) {
            putQueryParameter("kbType", kbType);
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

    public PageFaqArticleRequest() {
        super("/api/article/pageFaqArticle", HttpMethodType.GET);
    }

    @Override
    public Class getResponseClass() {
        return PageFaqArticleResponse.class;
    }

}
