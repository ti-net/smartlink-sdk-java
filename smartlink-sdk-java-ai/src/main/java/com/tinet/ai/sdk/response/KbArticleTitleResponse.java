package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.TitleModel;
import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 搜索推荐相似问题
 *
 * @author huwk
 * @date 2019/9/18
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class KbArticleTitleResponse extends BaseResponse {

    private List<TitleModel> result;

}
