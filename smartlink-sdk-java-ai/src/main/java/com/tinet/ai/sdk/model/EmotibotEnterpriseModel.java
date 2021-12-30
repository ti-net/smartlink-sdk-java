package com.tinet.ai.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * 竹间企业实体模型
 *
 * @author feizq
 * @date 2021/12/06
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmotibotEnterpriseModel {

    /**
     *  第三方企业ID
     */
    private String enterpriseThirdPartyId;

    /**
     *  企业管理员
     */
    private String enterpriseAdmin;
}
