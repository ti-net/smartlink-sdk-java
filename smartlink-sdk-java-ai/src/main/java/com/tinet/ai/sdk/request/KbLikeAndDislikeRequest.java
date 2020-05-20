package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.KbLikeAndDislikeResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * @author chenjg
 * @date 2020/5/14
 **/
public class KbLikeAndDislikeRequest extends BaseRequest<KbLikeAndDislikeResponse> {

    private String cno;

    private String agentName;

    private String enterpriseId;

    private String dataId;

    private Integer type;

    private String flag;

    private Integer operationType;

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

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
        if (enterpriseId != null) {
            putBodyParameter("enterpriseId", enterpriseId);
        }
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
        if (dataId != null) {
            putBodyParameter("dataId", dataId);
        }
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
        if (type != null) {
            putBodyParameter("type", type);
        }
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
        if (flag != null) {
            putBodyParameter("flag", flag);
        }
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
        if (operationType != null) {
            putBodyParameter("operationType", operationType);
        }
    }

    public KbLikeAndDislikeRequest() {
        super("/api/articles/updateLikeAndDislikeCount", HttpMethodType.POST);
    }
    @Override
    public Class getResponseClass() {
        return KbLikeAndDislikeResponse.class;
    }
}
