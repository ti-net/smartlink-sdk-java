package com.tinet.sqc.sdk.request;

import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;
import com.tinet.sqc.sdk.response.PushAsrResponse;
import lombok.Data;

/**
 * BigBoss对接慧智平台asr计费 请求
 *
 * @author liuhy
 * @date 2019/10/15
 */
@Data
public class PushAsrRequest extends BaseRequest<PushAsrResponse> {

    /**
     * 账户登录名
     */
    private String accountLoginName;

    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 通话唯一标识
     */
    private String uniqueId;
    /**
     * 主通道通话唯一标识
     */
    private String mainUniqueId;

    /**
     * 话单文件类型
     */
    private String cdrType;
    /**
     * 呼叫类型
     */
    private String callType;
    /**
     * 坐席工号
     */
    private String cno;

    /**
     * ASR转写引擎
     */
    private String provider;
    /**
     * ASR转写计费时长，单位：秒
     */
    private Integer duration;
    /**
     * 发起转写时间，10位时间戳
     */
    private Long createTime;
    /**
     * 转写结束时间，10位时间戳
     */
    private Long finishTime;


    public String getAccountLoginName() {
        return accountLoginName;
    }

    public void setAccountLoginName(String accountLoginName) {
        this.accountLoginName = accountLoginName;
        if (accountLoginName != null) {
            putBodyParameter("accountLoginName", accountLoginName);
        }
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
        if (userId != null) {
            putBodyParameter("userId", userId);
        }
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
        if (uniqueId != null) {
            putBodyParameter("uniqueId", uniqueId);
        }
    }


    public String getMainUniqueId() {
        return mainUniqueId;
    }

    public void setMainUniqueId(String mainUniqueId) {
        this.mainUniqueId = mainUniqueId;
        if (mainUniqueId != null) {
            putBodyParameter("mainUniqueId", mainUniqueId);
        }
    }

    public String getCdrType() {
        return cdrType;
    }

    public void setCdrType(String cdrType) {
        this.cdrType = cdrType;
        if (cdrType != null) {
            putBodyParameter("cdrType", cdrType);
        }
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
        if (callType != null) {
            putBodyParameter("callType", callType);
        }
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
        if (cno != null) {
            putBodyParameter("cno", cno);
        }
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
        if (provider != null) {
            putBodyParameter("provider", provider);
        }
    }


    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
        if (duration != null) {
            putBodyParameter("duration", duration);
        }
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
        if (createTime != null) {
            putBodyParameter("createTime", createTime);
        }
    }


    public Long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Long finishTime) {
        this.finishTime = finishTime;
        if (finishTime != null) {
            putBodyParameter("finishTime", finishTime);
        }
    }

    public PushAsrRequest() {
        super("/sqc/bigBoss", HttpMethodType.POST);
    }

    @Override
    public Class<PushAsrResponse> getResponseClass() {
        return PushAsrResponse.class;
    }
}
