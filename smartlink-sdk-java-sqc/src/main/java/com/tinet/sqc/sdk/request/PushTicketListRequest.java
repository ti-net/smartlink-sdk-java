package com.tinet.sqc.sdk.request;


import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;
import com.tinet.sqc.sdk.model.OriginData;
import com.tinet.sqc.sdk.model.TicketRecord;
import com.tinet.sqc.sdk.response.PushTicketListResponse;

import java.util.List;

/**
 * 工单质检推送请求实体
 *
 * @author wnagdabao
 * @date 2019/8/13 9:50
 */
public class PushTicketListRequest extends BaseRequest<PushTicketListResponse> {
    /**
     * 账号
     */
    private String accountLoginName;
    /**
     * 企业id
     */
    private String userId;
    /**
     * 第一个工单节点的创建时间
     */
    private Long createTime;
    /**
     * 是否是结束结点，0 为流转结点 1 为结束结点
     */
    private Integer finished;
    /**
     * 优先级 0: 低, 1: 中, 2: 高, 3: 紧急
     */
    private Integer priority;
    /**
     * 平台推送的工单id
     */
    private String ticketId;

    /**
     * 工单结束时间(时间戳，单位：s)
     */
    private Long ticketFinishedTime;
    /**
     * 工单1级声音类型
     */
    private String ticketVoiceType1;

    /**
     * 工单2级声音类型
     */
    private String ticketVoiceType2;

    /**
     * 工单3级声音类型
     */
    private String ticketVoiceType3;

    /**
     * 工单4级声音类型(可能为空)
     */
    private String ticketVoiceType4;



    /**
     * 工单节点内容
     */
    private List<TicketRecord> ticketRecord;

    /**
     * 自定义字段传值list
     */
    private List<OriginData> originDataList;


    public List<OriginData> getOriginDataList() {
        return originDataList;
    }

    public void setOriginDataList(List<OriginData> originDataList) {
        this.originDataList = originDataList;
        if (originDataList != null) {
            putBodyParameter("originDataList", originDataList);
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

    public String getAccountLoginName() {
        return accountLoginName;
    }

    public void setAccountLoginName(String accountLoginName) {
        this.accountLoginName = accountLoginName;
        if (accountLoginName != null) {
            putBodyParameter("accountLoginName", accountLoginName);
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

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
        if (finished != null) {
            putBodyParameter("finished", finished);
        }
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
        if (priority != null) {
            putBodyParameter("priority", priority);
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

    public Long getTicketFinishedTime() {
        return ticketFinishedTime;
    }

    public void setTicketFinishedTime(Long ticketFinishedTime) {
        this.ticketFinishedTime = ticketFinishedTime;
        if(ticketFinishedTime != null ){
            putBodyParameter("ticketFinishedTime", ticketFinishedTime);
        }
    }

    public String getTicketVoiceType1() {
        return ticketVoiceType1;
    }

    public void setTicketVoiceType1(String ticketVoiceType1) {
        this.ticketVoiceType1 = ticketVoiceType1;
        if(ticketVoiceType1 != null ){
            putBodyParameter("ticketVoiceType1", ticketVoiceType1);
        }
    }

    public String getTicketVoiceType2() {
        return ticketVoiceType2;
    }

    public void setTicketVoiceType2(String ticketVoiceType2) {
        this.ticketVoiceType2 = ticketVoiceType2;
        if(ticketVoiceType2 != null ){
            putBodyParameter("ticketVoiceType2", ticketVoiceType2);
        }
    }

    public String getTicketVoiceType3() {
        return ticketVoiceType3;
    }

    public void setTicketVoiceType3(String ticketVoiceType3) {
        this.ticketVoiceType3 = ticketVoiceType3;
        if(ticketVoiceType3 != null ){
            putBodyParameter("ticketVoiceType3", ticketVoiceType3);
        }
    }

    public String getTicketVoiceType4() {
        return ticketVoiceType4;
    }

    public void setTicketVoiceType4(String ticketVoiceType4) {
        this.ticketVoiceType4 = ticketVoiceType4;
        if(ticketVoiceType4 != null ){
            putBodyParameter("ticketVoiceType4", ticketVoiceType4);
        }
    }

    public List<TicketRecord> getTicketRecord() {
        return ticketRecord;
    }

    public void setTicketRecord(List<TicketRecord> ticketRecord) {
        this.ticketRecord = ticketRecord;
        if (ticketRecord != null) {
            putBodyParameter("ticketRecord", ticketRecord);
        }
    }

    public PushTicketListRequest() {
        super("/sqc/pushTicketList", HttpMethodType.POST);
    }

    @Override
    public Class<PushTicketListResponse> getResponseClass() {
        return PushTicketListResponse.class;
    }
}
