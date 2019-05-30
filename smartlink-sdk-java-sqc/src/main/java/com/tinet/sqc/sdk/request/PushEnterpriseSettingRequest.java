package com.tinet.sqc.sdk.request;

import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;
import com.tinet.sqc.sdk.response.PushEnterpriseSettingResponse;

/**
 * @author 王大宝
 * @date 2019/4/30
 */
public class PushEnterpriseSettingRequest extends BaseRequest<PushEnterpriseSettingResponse> {

    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 用户登录名，即账户
     */
    private String accountLoginName;
    /**
     * 企业Id
     */
    private String enterpriseId;
    /**
     * 隐藏类型 0：不隐藏   1：中间四位隐藏  2：后四位隐藏 3：后八位隐藏 4：全部隐藏';
     */
    private Integer hiddenType;
    /**
     * 慧智产品开通状态  1：开启 0：关闭
     * 用4位状态描述开通的产品，4位依次代表：asr、sqc、rms、tibot
     * 例如：[1,0,0,0] 代表仅开asr，
     * [0,1,0,1] 代表仅开启 sqc和tibot
     */
    private Integer[] status;
    /**
     * 配置状态  0：不生效  1：生效
     */
    private Integer active;
    /**
     * 获取录音访问地址的接口
     */
    private String recordUrl;
    /**
     * token
     */
    private String token;


  public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        if (id != null) {
            putBodyParameter("id", id);
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

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putBodyParameter("enterpriseId", enterpriseId);
        }
    }

    public Integer getHiddenType() {
        return hiddenType;
    }

    public void setHiddenType(Integer hiddenType) {
        this.hiddenType = hiddenType;
        if (hiddenType != null) {
            putBodyParameter("hiddenType", hiddenType);
        }
    }

    public Integer[] getStatus() {
        return status;
    }

    public void setStatus(Integer[] status) {
        this.status = status;
        if (status != null) {
            putBodyParameter("status", status);
        }
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
        if (active != null) {
            putBodyParameter("active", active);
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

    public PushEnterpriseSettingRequest() {
        super("/sqc/enterprise", HttpMethodType.POST);
    }


    @Override
    public Class<PushEnterpriseSettingResponse> getResponseClass() {
        return PushEnterpriseSettingResponse.class;
    }
}
