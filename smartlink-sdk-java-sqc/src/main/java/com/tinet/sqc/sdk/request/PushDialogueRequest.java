package com.tinet.sqc.sdk.request;



import com.alibaba.fastjson.JSONArray;
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


    private String id;

    /**
     * 唯一标识
     */
    private String uniqueId;
    /**
     * 账号名
     */
    private String accountLoginName;
    /**
     * 企业编号
     */
    private String enterpriseId;
    /**
     * 客户省份
     */
    private String customerProvince;
    /**
     * 客户城市
     */
    private String customerCity;
    /**
     * 客户号码
     */
    private String customerNumber;
    /**
     * 客户IP
     */
    private String customerIp;
    /**
     * 客户浏览器标识
     */
    private String browserUserAgent;
    /**
     * 座席编号
     */
    private String cno;
    /**
     * 座席名称
     */
    private String agentName;
    /**
     * 队列编号
     */
    private String qno;
    /**
     * 队列名称
     */
    private String qname;
    /**
     * 进入系统时间
     */
    private Long startTime;
    /**
     * 转人工时间
     */
    private Long sendChatTime;
    /**
     * 接通人工时间
     */
    private Long chatBeginTime;
    /**
     * 最后一次人工交互时间
     */
    private Long chatEndTime;
    /**
     * 最后一次机器人交互时间
     */
    private Long robotEndTime;
    /**
     * 结束原因
     */
    private Integer endReason;
    /**
     * 满意度
     */
    private String investigation;
    /**
     * 预警规则名
     */
    private String[] alarmRule;
    /**
     * 预警
     */
    private String alarmResult;
    /**
     * 质检评语
     */
    private String qcComment;
    /**
     * 质检得分
     */
    private Double qcScore;
    /**
     * 人工质检得分
     */
    private Double qcReviewScore;
    /**
     * 人工质检评级
     */
    private String qcReviewStatus;
    /**
     * 质检评级
     */
    private String qcLevel;
    /**
     * 人工质检评级
     */
    private String qcReviewLevel;
    /**
     * 质检模板名称
     */
    private String qcTemplate;
    /**
     * 质检模板类型
     */
    private Integer qcTemplateType;
    /**
     * 质检状态(1未质检,2已自动质检,3已人工复核,4待座席确认,5申诉中,6座席已确认,7重新质检中,8已重新质检)
     */
    private Integer qcStatus;
    /**
     * 质检项得分
     */
    private JSONArray qcResult;
    /**
     * 质检项得分
     */
    private JSONArray qcResultScore;
    /**
     * 自动质检详细
     */
    private JSONArray autoItems;
    /**
     * 对话分析标签
     */
    private JSONArray dpTag;
    /**
     * 关键词组标记数
     */
    private JSONArray statMark;
    /**
     * 座席侧聊天内容
     */
    private JSONArray chatAgent;
    /**
     * 客户侧聊天内容
     */
    private JSONArray chatCustomer;

    /**
     * 通话记录列表
     */
    List<ChatRecord> chatRecordList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        if (id != null) {
            putBodyParameter("id", id);
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

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
        if (customerNumber != null) {
            putBodyParameter("customerNumber", customerNumber);
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

    public String[] getAlarmRule() {
        return alarmRule;
    }

    public void setAlarmRule(String[] alarmRule) {
        this.alarmRule = alarmRule;
        if (alarmRule != null) {
            putBodyParameter("alarmRule", alarmRule);
        }
    }

    public String getAlarmResult() {
        return alarmResult;
    }

    public void setAlarmResult(String alarmResult) {
        this.alarmResult = alarmResult;
        if (alarmResult != null) {
            putBodyParameter("alarmResult", alarmResult);
        }
    }

    public String getQcComment() {
        return qcComment;
    }

    public void setQcComment(String qcComment) {
        this.qcComment = qcComment;
        if (qcComment != null) {
            putBodyParameter("qcComment", qcComment);
        }
    }

    public Double getQcScore() {
        return qcScore;
    }

    public void setQcScore(Double qcScore) {
        this.qcScore = qcScore;
        if (qcScore != null) {
            putBodyParameter("qcScore", qcScore);
        }
    }

    public Double getQcReviewScore() {
        return qcReviewScore;
    }

    public void setQcReviewScore(Double qcReviewScore) {
        this.qcReviewScore = qcReviewScore;
        if (qcReviewScore != null) {
            putBodyParameter("qcReviewScore", qcReviewScore);
        }
    }

    public String getQcReviewStatus() {
        return qcReviewStatus;
    }

    public void setQcReviewStatus(String qcReviewStatus) {
        this.qcReviewStatus = qcReviewStatus;
        if (qcReviewStatus != null) {
            putBodyParameter("qcReviewStatus", qcReviewStatus);
        }
    }

    public String getQcLevel() {
        return qcLevel;
    }

    public void setQcLevel(String qcLevel) {
        this.qcLevel = qcLevel;
        if (qcLevel != null) {
            putBodyParameter("qcLevel", qcLevel);
        }
    }

    public String getQcReviewLevel() {
        return qcReviewLevel;
    }

    public void setQcReviewLevel(String qcReviewLevel) {
        this.qcReviewLevel = qcReviewLevel;
        if (qcReviewLevel != null) {
            putBodyParameter("qcReviewLevel", qcReviewLevel);
        }
    }

    public String getQcTemplate() {
        return qcTemplate;
    }

    public void setQcTemplate(String qcTemplate) {
        this.qcTemplate = qcTemplate;
        if (qcTemplate != null) {
            putBodyParameter("qcTemplate", qcTemplate);
        }
    }

    public Integer getQcTemplateType() {
        return qcTemplateType;
    }

    public void setQcTemplateType(Integer qcTemplateType) {
        this.qcTemplateType = qcTemplateType;
        if (qcTemplateType != null) {
            putBodyParameter("qcTemplateType", qcTemplateType);
        }
    }

    public Integer getQcStatus() {
        return qcStatus;
    }

    public void setQcStatus(Integer qcStatus) {
        this.qcStatus = qcStatus;
        if (qcStatus != null) {
            putBodyParameter("qcStatus", qcStatus);
        }
    }

    public JSONArray getQcResult() {
        return qcResult;
    }

    public void setQcResult(JSONArray qcResult) {
        this.qcResult = qcResult;
        if (qcResult != null) {
            putBodyParameter("qcResult", qcResult);
        }
    }

    public JSONArray getQcResultScore() {
        return qcResultScore;
    }

    public void setQcResultScore(JSONArray qcResultScore) {
        this.qcResultScore = qcResultScore;
        if (qcResultScore != null) {
            putBodyParameter("qcResultScore", qcResultScore);
        }
    }

    public JSONArray getAutoItems() {
        return autoItems;
    }

    public void setAutoItems(JSONArray autoItems) {
        this.autoItems = autoItems;
        if (qcResultScore != null) {
            putBodyParameter("autoItems", autoItems);
        }
    }

    public JSONArray getDpTag() {
        return dpTag;
    }

    public void setDpTag(JSONArray dpTag) {
        this.dpTag = dpTag;
        if (dpTag != null) {
            putBodyParameter("dpTag", dpTag);
        }
    }

    public JSONArray getStatMark() {
        return statMark;
    }

    public void setStatMark(JSONArray statMark) {
        this.statMark = statMark;
        if (statMark != null) {
            putBodyParameter("statMark", statMark);
        }
    }

    public JSONArray getChatAgent() {
        return chatAgent;
    }

    public void setChatAgent(JSONArray chatAgent) {
        this.chatAgent = chatAgent;
        if (chatAgent != null) {
            putBodyParameter("chatAgent", chatAgent);
        }
    }

    public JSONArray getChatCustomer() {
        return chatCustomer;
    }

    public void setChatCustomer(JSONArray chatCustomer) {
        this.chatCustomer = chatCustomer;
        if (chatCustomer != null) {
            putBodyParameter("chatCustomer", chatCustomer);
        }
    }

    public List<ChatRecord> getChatRecordList() {
        return chatRecordList;
    }

    public void setChatRecordList(List<ChatRecord> chatRecordList) {
        this.chatRecordList = chatRecordList;
        if (chatRecordList != null) {
            putBodyParameter("chatRecordList", chatRecordList);
        }
    }

    public PushDialogueRequest() {
        super("/sqc/pushDialogue", HttpMethodType.POST);
    }

    @Override
    public Class<PushDialogueResponse> getResponseClass() {
        return null;
    }
}
