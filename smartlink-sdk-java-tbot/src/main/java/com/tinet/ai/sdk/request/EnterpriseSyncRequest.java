package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.model.EnterpriseFeaturesModel;
import com.tinet.ai.sdk.response.EnterpriseSyncResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 企业信息同步接口请求参数类
 *
 * @author zangshoubao
 * @date 2022/12/06
 **/
public class EnterpriseSyncRequest extends BaseRequest<EnterpriseSyncResponse> {

    /**
     * 账户登录名
     */
    private String accountLoginName;

    /**
     * 企业id
     */
    private String enterpriseId;

    /**
     * 企业名称
     */
    private String enterpriseName;

    /**
     * 录音地址
     */
    private String recordUrl;

    /**
     * token
     */
    private String token;

    /**
     * 企业状态；sqc：慧智，tibot：机器人，kb：知识库
     */
    private List<String> status;

    /**
     * 配置状态  0：不生效  1：生效
     */
    private Short active;

    /**
     * 平台标识：cticloud1、cticloud2、cticloud5、cticloud6、cticloud8、cticloud9、clink2_bj、clink2_sh
     */
    private String platform;

    /**
     * 转写平台；Alibaba：阿里asr平台，Iflytek：科大讯飞asr平台，Baidu：百度asr平台，Tinet：天润自建asr平台
     */
    private String asrProvider;

    /**
     * 号码隐藏方式；0不隐藏 1中间四位隐藏  2后四位隐藏  3后八位隐藏  4全部隐藏
     */
    private Short hiddenType;

    /**
     * 企业logo标识
     */
    private String logo;

    private String platformArea;

    /**
     * 企业创建时间
     */
    private LocalDateTime createTime;

    /**
     * 企业更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 开关
     */
    private List<EnterpriseFeaturesModel> enterpriseFeatures;

    public String getAccountLoginName() {
        return accountLoginName;
    }

    public void setAccountLoginName(String accountLoginName) {
        this.accountLoginName = accountLoginName;

        if (accountLoginName != null) {
            putBodyParameter("accountLoginName", accountLoginName);
        }
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;

        if (enterpriseId != null) {
            putBodyParameter("enterpriseId", enterpriseId);
        }
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;

        if (enterpriseName != null) {
            putBodyParameter("enterpriseName", enterpriseName);
        }
    }

    public String getRecordUrl() {
        return recordUrl;
    }

    public void setRecordUrl(String recordUrl) {
        this.recordUrl = recordUrl;

        if (recordUrl != null) {
            putBodyParameter("recordUrl", recordUrl);
        }
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;

        if (token != null) {
            putBodyParameter("token", token);
        }
    }

    public List<String> getStatus() {
        return status;
    }

    public void setStatus(List<String> status) {
        this.status = status;

        if (status != null) {
            putBodyParameter("status", status);
        }
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;

        if (active != null) {
            putBodyParameter("active", active);
        }
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;

        if (platform != null) {
            putBodyParameter("platform", platform);
        }
    }

    public String getAsrProvider() {
        return asrProvider;
    }

    public void setAsrProvider(String asrProvider) {
        this.asrProvider = asrProvider;

        if (asrProvider != null) {
            putBodyParameter("asrProvider", asrProvider);
        }
    }

    public Short getHiddenType() {
        return hiddenType;
    }

    public void setHiddenType(Short hiddenType) {
        this.hiddenType = hiddenType;

        if (hiddenType != null) {
            putBodyParameter("hiddenType", hiddenType);
        }
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;

        if (logo != null) {
            putBodyParameter("logo", logo);
        }
    }

    public String getPlatformArea() {
        return platformArea;
    }

    public void setPlatformArea(String platformArea) {
        this.platformArea = platformArea;

        if (platformArea != null) {
            putBodyParameter("platformArea", platformArea);
        }
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;

        if (createTime != null) {
            putBodyParameter("createTime", createTime);
        }
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;

        if (updateTime != null) {
            putBodyParameter("updateTime", updateTime);
        }
    }

    public List<EnterpriseFeaturesModel> getEnterpriseFeatures() {
        return enterpriseFeatures;
    }

    public void setEnterpriseFeatures(List<EnterpriseFeaturesModel> enterpriseFeatures) {
        this.enterpriseFeatures = enterpriseFeatures;

        if (enterpriseFeatures != null) {
            putBodyParameter("enterpriseFeatures", enterpriseFeatures);
        }
    }

    public EnterpriseSyncRequest() {
        super("/api/enterprise/sync", HttpMethodType.POST);
    }

    @Override
    public Class getResponseClass() {
        return EnterpriseSyncResponse.class;
    }
}
