package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.KbArticleResponseModel;
import com.tinet.smartlink.sdk.core.response.BaseResponse;

import java.util.List;

/**
 * 知识库文章列表响应
 *
 * @author huwk
 * @date 2019/9/18
 **/
public class KbArticleResponse extends BaseResponse {
    private int pageNumber;
    private int pageSize;
    private int totalCount;
    private int start;
    private int totalPageCount;
    private List<KbArticleResponseModel> articles;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public List<KbArticleResponseModel> getArticles() {
        return articles;
    }

    public void setArticles(List<KbArticleResponseModel> articles) {
        this.articles = articles;
    }
}
