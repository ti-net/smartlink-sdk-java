package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.BotOcsAnswerModel;
import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 最优话术推荐
 *
 * @author zhaojy
 * @date 2020/9/9
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class OptimalCallScriptResponse extends BaseResponse {

    private List<BotOcsAnswerModel> result;

}
