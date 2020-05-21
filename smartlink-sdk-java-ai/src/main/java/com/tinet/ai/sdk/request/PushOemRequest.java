package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.PushOemResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;


/**
 * 推送oem
 *
 * @author wenjd
 * @date 2019/04/11
 */
public class PushOemRequest extends BaseRequest<PushOemResponse> {


    /**
     * 缩略图地址
     */
    private String thumbnailIconName;
    private String thumbnailIconUrl;
    /**
     * 展开图地址
     */
    private String expandIconName;
    private String expandIconUrl;
    /**
     * 标题图标地址
     */
    private String titleIconName;
    private String titleIconUrl;
    /**
     * 标题文字
     */
    private String titleText;
    /**
     * oemAccountId 账户标志。该账户在clink2标志信息
     */
    private String oemAccountId;
    /**
     * 账号名 accountloginname
     */
    private String accountLoginName;

    public String getThumbnailIconName() {
        return thumbnailIconName;
    }

    public void setThumbnailIconName(String thumbnailIconName) {
        this.thumbnailIconName = thumbnailIconName;
        if (thumbnailIconName != null) {
            putBodyParameter("thumbnailIconName", thumbnailIconName);
        }
    }

    public String getThumbnailIconUrl() {
        return thumbnailIconUrl;
    }

    public void setThumbnailIconUrl(String thumbnailIconUrl) {
        this.thumbnailIconUrl = thumbnailIconUrl;
        if (thumbnailIconUrl != null) {
            putBodyParameter("thumbnailIconUrl", thumbnailIconUrl);
        }
    }

    public String getExpandIconName() {
        return expandIconName;
    }

    public void setExpandIconName(String expandIconName) {
        this.expandIconName = expandIconName;
        if (expandIconName != null) {
            putBodyParameter("expandIconName", expandIconName);
        }
    }

    public String getExpandIconUrl() {
        return expandIconUrl;
    }

    public void setExpandIconUrl(String expandIconUrl) {
        this.expandIconUrl = expandIconUrl;
        if (expandIconUrl != null) {
            putBodyParameter("expandIconUrl", expandIconUrl);
        }
    }

    public String getTitleIconName() {
        return titleIconName;
    }

    public void setTitleIconName(String titleIconName) {
        this.titleIconName = titleIconName;
        if (titleIconName != null) {
            putBodyParameter("titleIconName", titleIconName);
        }
    }

    public String getTitleIconUrl() {
        return titleIconUrl;
    }

    public void setTitleIconUrl(String titleIconUrl) {
        this.titleIconUrl = titleIconUrl;
        if (titleIconUrl != null) {
            putBodyParameter("titleIconUrl", titleIconUrl);
        }
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
        if (titleText != null) {
            putBodyParameter("titleText", titleText);
        }
    }

    public String getOemAccountId() {
        return oemAccountId;
    }

    public void setOemAccountId(String oemAccountId) {
        this.oemAccountId = oemAccountId;
        if (oemAccountId != null) {
            putBodyParameter("oemAccountId", oemAccountId);
        }
    }

    public String getAccountLoginName() {
        return accountLoginName;
    }

    public void setAccountLoginName(String accountLoginName) {
        this.accountLoginName = accountLoginName;
        if (accountLoginName != null) {
            putBodyParameter("accountLoginName", accountLoginName);
        }
    }

    public PushOemRequest() {
        super("/api/pushOem", HttpMethodType.POST);
    }

    @Override
    public Class<PushOemResponse> getResponseClass() {
        return PushOemResponse.class;
    }
}
