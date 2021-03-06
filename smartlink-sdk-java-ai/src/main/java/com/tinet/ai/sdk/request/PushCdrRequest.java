package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.PushCdrResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

import java.util.List;


/**
 * 推送CDR文件
 *
 * @author wenjd
 * @date 2019/04/11
 */
public class PushCdrRequest extends BaseRequest<PushCdrResponse> {


    /**
     * 记录唯一标识
     */
    private String uniqueId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * cdr文件类型
     * cdr_ib： 呼入主话单
     * cdr_ob_agent：外呼先呼座席侧主话单
     * cdr_ob_customer：外呼先呼客户侧主话单
     */
    private String cdrType;

    /**
     * 呼叫类型
     * 1：呼入
     * 2：网上400呼入
     * 3：点击外呼呼座席的通道
     */
    private Integer callType;

    /**
     * 座席电话号码
     */
    private String agentNumber;

    /**
     * 开始时间  (单位：秒)
     */
    private Long startTime;

    /**
     * 应答时间  (单位：秒)
     */
    private Long answerTime;


    /**
     * 结束时间  (单位：秒)
     */
    private Long endTime;

    /**
     * 接通时间  (单位：秒)
     */
    private Long bridgeTime;

    /**
     * 通话时长  (单位：秒)
     */
    private Integer bridgeDuration;

    /**
     * 总时长  (单位：秒)
     */
    private Integer totalDuration;


    /**
     * 接听状态
     * <p>
     * 呼入
     * 1：座席接听
     * 2：已呼叫座席，座席未接听
     * 3：系统接听
     * 4：系统未接-IVR配置错误
     * 5：系统未接-停机
     * 6：系统未接-欠费
     * 7：系统未接-黑名单
     * 8：系统未接-未注册
     * 9：系统未接-彩铃
     * 11：系统未接-呼叫超出营帐中设置的最大限制
     * 12：系统未接-客户呼入系统后在系统未应答前挂机
     * 13：其他错误
     * <p>
     * 外呼
     * 20：webcall，TTS合成失败
     * 21：webcall，客户未接
     * 22：webcall，客户接听
     * 23：webcall，已呼叫
     * 24：webcall，双方接听
     * 30：座席未接听
     * 31：座席接听，未呼叫客户
     * 32：座席接听，客户未接听
     * 33：双方接听
     * 40：预测外呼，客户未接听
     * 41：预测外呼，客户接听
     * 42：预测外呼，已呼叫
     * 43：预测外呼，双方接听
     * 50：主叫外呼接听
     * 51：主叫外呼，客户未接听
     * 52：主叫外呼，双方接听
     */
    private Integer status;


    /**
     * 挂机原因  0：客户未挂机   1：客户挂机
     */
    private Integer endReason;

    /**
     * 座席标识
     */
    private String cno;

    /**
     * 座席名称
     */
    private String agentName;

    /**
     * 队列标识
     */
    private String qno;

    /**
     * 队列名称
     */
    private String qname;

    /**
     * 分机号
     */
    private String exten;

    /**
     * 主话单和从话单的关连键
     */
    private String mainUniqueId;


    /**
     * 客户号码
     */
    private String customerNumber;

    /**
     * 客户号码类型
     */
    private String customerNumberType;

    /**
     * 客户号码区号
     */
    private String customerAreaCode;

    /**
     * 客户省份
     */
    private String customerProvince;

    /**
     * 客户城市
     */
    private String customerCity;

    /**
     * 加入队列时间
     */
    private Long joinQueueTime;

    /**
     * 录音文件地址
     */
    private String recordFile;

    /**
     * 中继号码
     */
    private String numberTrunk;

    /**
     * 热线号码
     */
    private String hotline;

    /**
     * 外显号码
     */
    private String clid;

    private String accountLoginName;

    /**
     * 总重试次数（挂断拨打电话）
     */
    private Integer retryCount;

    /**
     * 当前重试次数
     */
    private Integer curRetryCount;

    /**
     * 外呼任务id
     */
    private Integer taskId;

    /**
     * 机器人通话时长
     */
    private Integer robotDuration;

    public Integer getRobotDuration() {
        return robotDuration;
    }

    public void setRobotDuration(Integer robotDuration) {
        this.robotDuration = robotDuration;
        if (robotDuration != null) {
            putBodyParameter("robotDuration", robotDuration);
        }
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
        if (taskId != null) {
            putBodyParameter("taskId", taskId);
        }
    }

    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
        if (retryCount != null) {
            putBodyParameter("retryCount", retryCount);
        }
    }

    public void setCurRetryCount(Integer curRetryCount) {
        this.curRetryCount = curRetryCount;
        if (curRetryCount != null) {
            putBodyParameter("curRetryCount", curRetryCount);
        }
    }
    public Integer getTaskId() {
        return taskId;
    }
    public Integer getRetryCount() {
        return retryCount;
    }
    public Integer getCurRetryCount() {
        return curRetryCount;
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


    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
        if (uniqueId != null) {
            putBodyParameter("uniqueId", uniqueId);
        }
    }



    public void setUserId(String userId) {
        this.userId = userId;
        if (userId != null) {
            putBodyParameter("userId", userId);
        }
    }


    public void setCdrType(String cdrType) {
        this.cdrType = cdrType;
        if (cdrType != null) {
            putBodyParameter("cdrType", cdrType);
        }
    }

    public Integer getCallType() {
        return callType;
    }
    public String getUserId() {
        return userId;
    }
    public String getUniqueId() {
        return uniqueId;
    }
    public String getCdrType() {
        return cdrType;
    }

    public void setCallType(Integer callType) {
        this.callType = callType;
        if (callType != null) {
            putBodyParameter("callType", callType);
        }
    }

    public String getAgentNumber() {
        return agentNumber;
    }

    public void setAgentNumber(String agentNumber) {
        this.agentNumber = agentNumber;
        if (agentNumber != null) {
            putBodyParameter("agentNumber", agentNumber);
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

    public Long getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Long answerTime) {
        this.answerTime = answerTime;
        if (answerTime != null) {
            putBodyParameter("answerTime", answerTime);
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

    public Long getBridgeTime() {
        return bridgeTime;
    }

    public void setBridgeTime(Long bridgeTime) {
        this.bridgeTime = bridgeTime;
        if (bridgeTime != null) {
            putBodyParameter("bridgeTime", bridgeTime);
        }
    }

    public Integer getBridgeDuration() {
        return bridgeDuration;
    }

    public void setBridgeDuration(Integer bridgeDuration) {
        this.bridgeDuration = bridgeDuration;
        if (bridgeDuration != null) {
            putBodyParameter("bridgeDuration", bridgeDuration);
        }
    }

    public Integer getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(Integer totalDuration) {
        this.totalDuration = totalDuration;
        if (totalDuration != null) {
            putBodyParameter("totalDuration", totalDuration);
        }
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
        if (status != null) {
            putBodyParameter("status", status);
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

    public String getExten() {
        return exten;
    }

    public void setExten(String exten) {
        this.exten = exten;
        if (exten != null) {
            putBodyParameter("exten", exten);
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

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
        if (customerNumber != null) {
            putBodyParameter("customerNumber", customerNumber);
        }
    }

    public String getCustomerNumberType() {
        return customerNumberType;
    }

    public void setCustomerNumberType(String customerNumberType) {
        this.customerNumberType = customerNumberType;
        if (customerNumberType != null) {
            putBodyParameter("customerNumberType", customerNumberType);
        }
    }

    public String getCustomerAreaCode() {
        return customerAreaCode;
    }

    public void setCustomerAreaCode(String customerAreaCode) {
        this.customerAreaCode = customerAreaCode;
        if (customerAreaCode != null) {
            putBodyParameter("customerAreaCode", customerAreaCode);
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

    public Long getJoinQueueTime() {
        return joinQueueTime;
    }

    public void setJoinQueueTime(Long joinQueueTime) {
        this.joinQueueTime = joinQueueTime;
        if (joinQueueTime != null) {
            putBodyParameter("joinQueueTime", joinQueueTime);
        }
    }

    public String getRecordFile() {
        return recordFile;
    }

    public void setRecordFile(String recordFile) {
        this.recordFile = recordFile;
        if (recordFile != null) {
            putBodyParameter("recordFile", recordFile);
        }
    }

    public String getNumberTrunk() {
        return numberTrunk;
    }

    public void setNumberTrunk(String numberTrunk) {
        this.numberTrunk = numberTrunk;
        if (numberTrunk != null) {
            putBodyParameter("numberTrunk", numberTrunk);
        }
    }

    public String getHotline() {
        return hotline;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline;
        if (hotline != null) {
            putBodyParameter("hotline", hotline);
        }
    }

    public String getClid() {
        return clid;
    }

    public void setClid(String clid) {
        this.clid = clid;
        if (clid != null) {
            putBodyParameter("clid", clid);
        }
    }

    public PushCdrRequest() {
        super("/api/tbot/cdr", HttpMethodType.POST);
    }

    @Override
    public Class<PushCdrResponse> getResponseClass() {
        return PushCdrResponse.class;
    }
}
