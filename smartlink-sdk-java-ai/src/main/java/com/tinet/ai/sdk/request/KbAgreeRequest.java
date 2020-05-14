package com.tinet.ai.sdk.request;

import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;
import com.tinet.smartlink.sdk.core.response.BaseResponse;

/**
 * @author chenjg
 * @date 2020/5/14
 **/
public class KbAgreeRequest extends BaseRequest {

    private String cno;

    private String agentName;

    private String enterpriseId;

    private String dataId;

    private Integer type;

    private String flag;

    private Integer operationType;

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
        if(operationType != null){
            putQueryParameter("operationType", operationType);
        }
    }

    public void setCno(String cno) {
        this.cno = cno;
        if (cno != null) {
            putQueryParameter("order", cno);
        }
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
        if(agentName != null){
            putQueryParameter("agentName",agentName);
        }
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        if(enterpriseId != null){
            putQueryParameter("enterpriseId",enterpriseId);
        }
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
        if(dataId != null){
            putQueryParameter("dataId",dataId);
        }
    }

    public void setType(Integer type) {
        this.type = type;
        if(type != null){
            putQueryParameter("type",type);
        }
    }

    public void setFlag(String flag) {
        this.flag = flag;
        if(flag != null){
            putQueryParameter("flag",flag);
        }
    }

    public String getCno() {
        return cno;
    }

    public String getAgentName() {
        return agentName;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public String getDataId() {
        return dataId;
    }

    public Integer getType() {
        return type;
    }

    public String getFlag() {
        return flag;
    }

    public KbAgreeRequest() {
        super("/api/articles/updateAgreeCount", HttpMethodType.PUT);
    }
    @Override
    public Class getResponseClass() {
        return BaseResponse.class;
    }
}
