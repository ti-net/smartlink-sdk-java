package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.AnswerResponseModel;
import com.tinet.smartlink.sdk.core.response.BaseResponse;

/**
 * 创建答案响应实体
 *
 * @author feizq
 * @date 2022/06/15
 **/
public class CreateAnswerResponse extends BaseResponse {

    private AnswerResponseModel answer;

    public AnswerResponseModel getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerResponseModel answer) {
        this.answer = answer;
    }
}
