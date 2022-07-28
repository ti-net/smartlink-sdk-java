package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.InputAssociationModel;
import com.tinet.smartlink.sdk.core.response.BaseResponse;

import java.util.List;

/**
 * 输入联想响应实体
 *
 * @author feizq
 * @date 2021/09/01
 **/
public class InputAssociationResponse  extends BaseResponse {

    private List<InputAssociationModel> inputAssociationResponseModels;

    public List<InputAssociationModel> getInputAssociationResponseModels() {
        return inputAssociationResponseModels;
    }

    public void setInputAssociationResponseModels(List<InputAssociationModel> inputAssociationResponseModels) {
        this.inputAssociationResponseModels = inputAssociationResponseModels;
    }
}
