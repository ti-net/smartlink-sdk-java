package com.tinet.ai.sdk.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tinet.ai.sdk.model.Corpus;
import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Json输出封装类
 *
 * @author hy
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CorpusResponse extends BaseResponse {

    private String requestId;

    private List<Corpus> corpus;
}
