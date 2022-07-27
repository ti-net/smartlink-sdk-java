package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.StandardQuestionModel;
import com.tinet.smartlink.sdk.core.response.BaseResponse;

import java.util.List;

/**
 * @author feizq
 * @date 2022/07/26
 **/
public class ListStandardQuestionResponse extends BaseResponse {

    private List<StandardQuestionModel> standardQuestions;

    public List<StandardQuestionModel> getStandardQuestions() {
        return standardQuestions;
    }

    public void setStandardQuestions(List<StandardQuestionModel> standardQuestions) {
        this.standardQuestions = standardQuestions;
    }
}
