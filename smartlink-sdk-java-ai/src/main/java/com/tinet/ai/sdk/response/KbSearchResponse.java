package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.KbSearchResponseModel;
import com.tinet.smartlink.sdk.core.response.BaseResponse;

import java.util.List;

/**
 * @author feizq
 * @date 2022/07/05
 **/
public class KbSearchResponse extends BaseResponse {

    private int pageNumber;
    private int pageSize;
    private int totalCount;
    private int start;
    private int totalPageCount;
    private List<KbSearchResponseModel> articles;

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

    public List<KbSearchResponseModel> getArticles() {
        return articles;
    }

    public void setArticles(List<KbSearchResponseModel> articles) {
        this.articles = articles;
    }
}
