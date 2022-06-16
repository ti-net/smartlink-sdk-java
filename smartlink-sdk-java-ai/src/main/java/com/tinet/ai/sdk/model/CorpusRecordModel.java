package com.tinet.ai.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * @author feizq
 * @date 2022/06/15
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CorpusRecordModel {

    /**
     * 标准问ID
     */
    private Integer sqId;
    /**
     * 标准问ID
     */
    private List<Corpus> corpusList;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Corpus {

        /**
         * 语料名
         */
        private String corpusName;
    }
}
