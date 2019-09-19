package com.tinet.ai.sdk.model;

import lombok.Data;

@Data
public class SubscribeModel {
    private String uniqueId;
    private Integer enterpriseId;
    private String customerNumber;
    private String botId;
}
