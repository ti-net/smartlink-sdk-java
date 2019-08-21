package com.tinet.sqc.sdk.request;


import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;
import com.tinet.sqc.sdk.model.ChatRecord;
import com.tinet.sqc.sdk.response.PushDialogueResponse;
import com.tinet.sqc.sdk.response.PushTicketResponse;

import java.util.List;

/**
 * 工单质检推送请求实体
 *
 * @author wnagdabao
 * @date 2019/8/13 9:50
 */
public class PushTicketRequest extends BaseRequest<PushTicketResponse> {
    
    private String accountLoginName;
    
    private String enterpriseId;
    
    /**
     * 工单 ID
     */
    private String ticketId;
    
    /**
     * 是否是结束结点，1 为结束结点
     */
    private Integer finished;
    
    private String cno;
    
    private String agentName;
    
    private String qno;
    
    private String qname;
    
    private Long createTime;
    
    private Long updateTime;

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

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
        if (ticketId != null) {
            putBodyParameter("ticketId", ticketId);
        }
    }

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
        if (finished != null) {
            putBodyParameter("finished", finished);
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

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
        if (createTime != null) {
            putBodyParameter("createTime", createTime);
        }
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
        if (updateTime != null) {
            putBodyParameter("updateTime", updateTime);
        }
    }

    public PushTicketRequest() {
        super("/sqc/pushTicket", HttpMethodType.POST);
    }

    @Override
    public Class<PushTicketResponse> getResponseClass() {
        return PushTicketResponse.class;
    }
}
