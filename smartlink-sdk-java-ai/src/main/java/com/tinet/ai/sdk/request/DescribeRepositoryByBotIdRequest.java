package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.DescribeRepositoryByBotIdResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 根据 机器人id 获取机器人绑定的问答库
 *
 * @author feizq
 * @date 2022/12/08
 **/
public class DescribeRepositoryByBotIdRequest extends BaseRequest<DescribeRepositoryByBotIdResponse> {

    /**
     * 账号名称
     */
    private String accountLoginName;

    /**
     * 企业ID
     */
    private String enterpriseId;

    /**
     * 机器人ID
     */
    private String botId;

    public String getAccountLoginName() {
        return accountLoginName;
    }

    public void setAccountLoginName(String accountLoginName) {
        this.accountLoginName = accountLoginName;
        if (accountLoginName != null) {
            putQueryParameter("accountLoginName", accountLoginName);
        }
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putQueryParameter("enterpriseId", enterpriseId);
        }
    }

    public String getBotId() {
        return botId;
    }

    public void setBotId(String botId) {
        this.botId = botId;
        if (botId != null) {
            putQueryParameter("botId", botId);
        }
    }

    public DescribeRepositoryByBotIdRequest() {
        super("/api/describeKbRepository", HttpMethodType.GET);
    }

    @Override
    public Class<DescribeRepositoryByBotIdResponse> getResponseClass() {
        return DescribeRepositoryByBotIdResponse.class;
    }
}
