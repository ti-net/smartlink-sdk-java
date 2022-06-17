package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.StandardQuestionResponseModel;
import com.tinet.smartlink.sdk.core.response.BaseResponse;

/**
 * @author feizq
 * @date 2022/06/15
 **/
public class CreateStandardQuestionResponse extends BaseResponse {

    private StandardQuestionResponseModel standardQuestion;

    public StandardQuestionResponseModel getStandardQuestion() {
        return standardQuestion;
    }

    public void setStandardQuestion(StandardQuestionResponseModel standardQuestion) {
        this.standardQuestion = standardQuestion;
    }
}
