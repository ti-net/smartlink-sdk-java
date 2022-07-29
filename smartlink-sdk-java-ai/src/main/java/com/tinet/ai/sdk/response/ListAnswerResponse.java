package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.AnswerModel;
import com.tinet.smartlink.sdk.core.response.BaseResponse;

import java.util.List;

/**
 * 获取答案列表响应实体
 *
 * @author feizq
 * @date 2022/07/26
 **/
public class ListAnswerResponse extends BaseResponse {

    private List<AnswerModel> answers;

    public List<AnswerModel> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerModel> answers) {
        this.answers = answers;
    }
}
