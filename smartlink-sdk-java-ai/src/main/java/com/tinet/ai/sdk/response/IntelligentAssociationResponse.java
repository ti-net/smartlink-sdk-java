package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.IntelligentAssociationModel;
import com.tinet.smartlink.sdk.core.response.BaseResponse;

import java.util.List;

/**
 * 智能联想响应
 *
 * @author huwk
 * @date 2019/11/1
 **/
public class IntelligentAssociationResponse extends BaseResponse {

    private List<IntelligentAssociationModel> questions;

    public List<IntelligentAssociationModel> getQuestions() {
        return questions;
    }

    public void setQuestions(List<IntelligentAssociationModel> questions) {
        this.questions = questions;
    }
}
