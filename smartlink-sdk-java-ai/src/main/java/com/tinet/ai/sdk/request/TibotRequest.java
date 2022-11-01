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

    /**
     * 呼入机器人开关；0：关闭，1：开启
     */
    private Integer ibRobotOpenFlag;

    /**
     * 外呼机器人开关；0：关闭，1：开启
     */
    private Integer obRobotOpenFlag;

    /**
     * 协呼机器人开关；0：关闭，1：开启
     */
    private Integer abRobotOpenFlag;

    /**
     * 语音机器人开关；0：关闭，1：开启
     */
    private Integer callRobotOpenFlag;

    /**
     * 文本机器人开关；0：关闭，1：开启
     */
    private Integer chatRobotOpenFlag;

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

    public Integer getIbRobotOpenFlag() {
        return ibRobotOpenFlag;
    }

    public void setIbRobotOpenFlag(Integer ibRobotOpenFlag) {
        this.ibRobotOpenFlag = ibRobotOpenFlag;
        if (ibRobotOpenFlag != null) {
            putQueryParameter("ibRobotOpenFlag", ibRobotOpenFlag);
        }
    }

    public Integer getObRobotOpenFlag() {
        return obRobotOpenFlag;
    }

    public void setObRobotOpenFlag(Integer obRobotOpenFlag) {
        this.obRobotOpenFlag = obRobotOpenFlag;
        if (obRobotOpenFlag != null) {
            putQueryParameter("obRobotOpenFlag", obRobotOpenFlag);
        }
    }

    public Integer getAbRobotOpenFlag() {
        return abRobotOpenFlag;
    }

    public void setAbRobotOpenFlag(Integer abRobotOpenFlag) {
        this.abRobotOpenFlag = abRobotOpenFlag;
        if (abRobotOpenFlag != null) {
            putQueryParameter("abRobotOpenFlag", abRobotOpenFlag);
        }
    }

    public Integer getCallRobotOpenFlag() {
        return callRobotOpenFlag;
    }

    public void setCallRobotOpenFlag(Integer callRobotOpenFlag) {
        this.callRobotOpenFlag = callRobotOpenFlag;
        if (callRobotOpenFlag != null) {
            putQueryParameter("callRobotOpenFlag", callRobotOpenFlag);
        }
    }

    public Integer getChatRobotOpenFlag() {
        return chatRobotOpenFlag;
    }

    public void setChatRobotOpenFlag(Integer chatRobotOpenFlag) {
        this.chatRobotOpenFlag = chatRobotOpenFlag;
        if (chatRobotOpenFlag != null) {
            putQueryParameter("chatRobotOpenFlag", chatRobotOpenFlag);
        }
    }

    @Override
    public Class<TibotResponse> getResponseClass() {
        return TibotResponse.class;
    }
}
