package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.KbDirectoryResponseModel;
import com.tinet.ai.sdk.model.KbRepositoryResponseModel;
import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 知识库目录列表响应
 *
 * @author huwk
 * @date 2019/9/19
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class KbDirectoriesResponse extends BaseResponse {

    private List<KbDirectoryResponseModel> directories;

   
}
