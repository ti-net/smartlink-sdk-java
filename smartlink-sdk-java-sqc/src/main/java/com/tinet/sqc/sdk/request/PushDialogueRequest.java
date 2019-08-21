package com.tinet.sqc.sdk.request;


import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;
import com.tinet.sqc.sdk.model.ChatRecord;
import com.tinet.sqc.sdk.response.PushDialogueResponse;

import java.util.List;

/**
 * 顺丰在线质检推送请求实体
 *
 * @author liuhy
 * @date 2019/8/13 9:50
 */
public class PushDialogueRequest extends BaseRequest<PushDialogueResponse> {

    private String uniqueId;

    private String accountLoginName;

    private String userId;

    private String customerProvince;

    private String customerCity;

    private String customerIp;

    private String browserUserAgent;

    private String cno;

    private String agentName;

    private String qno;

    private String qname;

    private Long startTime;

    private Long sendChatTime;

    private Long chatBeginTime;

    private Long chatEndTime;

    private Long endTime;

    private Long robotEndTime;

    private Integer endReason;

    private String investigation;

    private List<ChatRecord> chatAgent;

    private List<ChatRecord> chatCustomer;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
        if (uniqueId != null) {
            putBodyParameter("uniqueId", uniqueId);
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
        if (userId != null) {
            putBodyParameter("userId", userId);
        }
    }

    public String getCustomerProvince() {
        return customerProvince;
    }

    public void setCustomerProvince(String customerProvince) {
        this.customerProvince = customerProvince;
        if (customerProvince != null) {
            putBodyParameter("customerProvince", customerProvince);
        }
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
        if (customerCity != null) {
            putBodyParameter("customerCity", customerCity);
        }
    }

    public String getCustomerIp() {
        return customerIp;
    }

    public void setCustomerIp(String customerIp) {
        this.customerIp = customerIp;
        if (customerIp != null) {
            putBodyParameter("customerIp", customerIp);
        }
    }

    public String getBrowserUserAgent() {
        return browserUserAgent;
    }

    public void setBrowserUserAgent(String browserUserAgent) {
        this.browserUserAgent = browserUserAgent;
        if (browserUserAgent != null) {
            putBodyParameter("browserUserAgent", browserUserAgent);
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

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
        if (agentName != null) {
            putBodyParameter("agentName", agentName);
        }
    }

    public String getQno() {
        return qno;
    }

    public void setQno(String qno) {
        this.qno = qno;
        if (qno != null) {
            putBodyParameter("qno", qno);
        }
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
        if (qname != null) {
            putBodyParameter("qname", qname);
        }
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
        if (startTime != null) {
            putBodyParameter("startTime", startTime);
        }
    }

    public Long getSendChatTime() {
        return sendChatTime;
    }

    public void setSendChatTime(Long sendChatTime) {
        this.sendChatTime = sendChatTime;
        if (sendChatTime != null) {
            putBodyParameter("sendChatTime", sendChatTime);
        }
    }

    public Long getChatBeginTime() {
        return chatBeginTime;
    }

    public void setChatBeginTime(Long chatBeginTime) {
        this.chatBeginTime = chatBeginTime;
        if (chatBeginTime != null) {
            putBodyParameter("chatBeginTime", chatBeginTime);
        }
    }

    public Long getChatEndTime() {
        return chatEndTime;
    }

    public void setChatEndTime(Long chatEndTime) {
        this.chatEndTime = chatEndTime;
        if (chatEndTime != null) {
            putBodyParameter("chatEndTime", chatEndTime);
        }
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
        if (endTime != null) {
            putBodyParameter("endTime", endTime);
        }
    }

    public Long getRobotEndTime() {
        return robotEndTime;
    }

    public void setRobotEndTime(Long robotEndTime) {
        this.robotEndTime = robotEndTime;
        if (robotEndTime != null) {
            putBodyParameter("robotEndTime", robotEndTime);
        }
    }

    public Integer getEndReason() {
        return endReason;
    }

    public void setEndReason(Integer endReason) {
        this.endReason = endReason;
        if (endReason != null) {
            putBodyParameter("endReason", endReason);
        }
    }

    public String getInvestigation() {
        return investigation;
    }

    public void setInvestigation(String investigation) {
        this.investigation = investigation;
        if (investigation != null) {
            putBodyParameter("investigation", investigation);
        }
    }

    public List<ChatRecord> getChatAgent() {
        return chatAgent;
    }

    public void setChatAgent(List<ChatRecord> chatAgent) {
        this.chatAgent = chatAgent;
        if (chatAgent != null) {
            putBodyParameter("chatAgent", chatAgent);
        }
    }

    public List<ChatRecord> getChatCustomer() {
        return chatCustomer;
    }

    public void setChatCustomer(List<ChatRecord> chatCustomer) {
        this.chatCustomer = chatCustomer;
        if (chatCustomer != null) {
            putBodyParameter("chatCustomer", chatCustomer);
        }
    }

    public PushDialogueRequest() {
        super("/sqc/pushDialogue", HttpMethodType.POST);
    }

    @Override
    public Class<PushDialogueResponse> getResponseClass() {
        return PushDialogueResponse.class;
    }
}
