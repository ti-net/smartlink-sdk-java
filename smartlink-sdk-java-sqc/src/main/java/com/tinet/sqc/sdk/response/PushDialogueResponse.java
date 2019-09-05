package com.tinet.sqc.sdk.response;


import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 在线质检推送响应实体
 *
 * @author liuhy
 * @date 2019/8/13 9:51
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PushDialogueResponse extends BaseResponse {

    private String result;
    private String message;
}
