package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.CorpusModel;
import com.tinet.smartlink.sdk.core.response.BaseResponse;

import java.util.List;

/**
 * @author feizq
 * @date 2022/07/26
 **/
public class ListCorporaResponse extends BaseResponse {

    private List<CorpusModel> corpora;

    public List<CorpusModel> getCorpora() {
        return corpora;
    }

    public void setCorpora(List<CorpusModel> corpora) {
        this.corpora = corpora;
    }
}
