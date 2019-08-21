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
    

    public PushTicketRequest() {
        super("/sqc/pushTicket", HttpMethodType.POST);
    }

    @Override
    public Class<PushTicketResponse> getResponseClass() {
        return PushTicketResponse.class;
    }
}
