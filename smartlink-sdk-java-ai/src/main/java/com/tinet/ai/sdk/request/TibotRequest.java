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

    public TibotRequest() {
        super("/robot/list", HttpMethodType.GET);
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