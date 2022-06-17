package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.BotAvatarUrlResponse;
import com.tinet.ai.sdk.response.KbArticleImageUrlResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 获取机器人头像url 请求
 *
 * @author zhaojy
 * @date 2019/10/8
 **/
public class BotAvatarUrlRequest extends BaseRequest<BotAvatarUrlResponse> {

    /**
     * 机器人id
     */
    private Long botId;

    /**
     * 企业id
     */
    private String enterpriseId;

    /**
     * 机器人厂商
     */
    private String provider;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public Long getBotId() {
        return botId;
    }

    public String getProvider() {
        return provider;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putQueryParameter("enterpriseId", enterpriseId);
        }
    }

    public void setBotId(Long botId) {
        this.botId = botId;
        if (botId != null) {
            putQueryParameter("botId", botId);
        }
    }

    public void setProvider(String provider) {
        this.provider = provider;
        if (provider != null) {
            putQueryParameter("provider", provider);
        }
    }

    public BotAvatarUrlRequest() {
        super("/api/tibots/avatar_by_id", HttpMethodType.GET);
    }

    @Override
    public Class getResponseClass() {
        return BotAvatarUrlResponse.class;
    }
}
