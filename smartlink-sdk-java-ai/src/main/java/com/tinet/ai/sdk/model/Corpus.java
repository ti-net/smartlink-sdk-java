package com.tinet.ai.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author tinet-yuhq
 * @description
 * @createTime 2022/4/27 14:38
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Corpus {

    private String corpus_id;
    private String inputs;
    private String outputs;
    private String type;
    private String text;
}