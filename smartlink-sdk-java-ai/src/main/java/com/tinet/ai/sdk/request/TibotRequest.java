package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.TibotResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 查询机器人列表
 *
 * @author huwk
 * @date 2019/9/19
 */
public class TibotRequest extends BaseRequest<TibotResponse> {

    /**
     * 企业ID，也就是用户标识
     */
    private String userId;

    /**
     * 机器人类型
     */
    private Integer botType;

    /**
     * 机器人提供商
     */
    private String provider;

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
        if (provider != null) {
            putQueryParameter("provider", provider);
        }
    }

    public TibotRequest() {
        super("/api/tibots", HttpMethodType.GET, "2022-10-31");
    }

    public Integer getBotType() {
        return botType;
    }

    public String getUserId() {
        return userId;
    }

    public void setBotType(Integer botType) {
        this.botType = botType;
        if (botType != null) {
            putQueryParameter("botType", botType);
        }
    }
    public void setUserId(String userId) {
        this.userId = userId;
        if (userId != null) {
            putQueryParameter("userId", userId);
        }
    }

    @Override
    public Class<TibotResponse> getResponseClass() {
        return TibotResponse.class;
    }
}
