package com.tinet.ai.sdk.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tinet.ai.sdk.model.FeedbackModel;
import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;

import java.util.List;

/**
 * 对会话进行点赞或点踩接口返回数据模型
 *
 * @author feizq
 * @date 2021/06/23
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiMessageFeedbackResponse extends BaseResponse {

    private List<FeedbackModel> feedbacks;
}
