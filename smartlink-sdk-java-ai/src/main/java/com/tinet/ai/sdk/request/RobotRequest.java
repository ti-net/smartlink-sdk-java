package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.RobotResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 查询对话日志
 * @author houfc
 * @date 2019/3/14
 */
public class RobotRequest extends BaseRequest<RobotResponse> {

    private Integer userId;

    public RobotRequest() {
        super("/robot/list", HttpMethodType.GET);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
        if (userId!=null){
            putQueryParameter("userId", userId);
        }
    }

    @Override
    public Class<RobotResponse> getResponseClass() {
        return RobotResponse.class;
    }
}
