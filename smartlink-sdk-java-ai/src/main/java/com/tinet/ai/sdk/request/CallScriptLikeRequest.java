package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.CallScriptLikeResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 话术的点赞点踩,使用操作请求
 *
 * @author zhaojy
 * @date 2020/9/9
 **/
public class CallScriptLikeRequest extends BaseRequest<CallScriptLikeResponse> {

    private Integer id;
    private Boolean like;
    private Boolean dislike;
    private Boolean used;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        if (id != null) {
            putQueryParameter("id", id);
        }
    }

    public void setLike(Boolean like) {
        this.like = like;
        if (like != null) {
            putQueryParameter("like", like);
        }
    }

    public void setDislike(Boolean dislike) {
        this.dislike = dislike;
        if (dislike != null) {
            putQueryParameter("dislike", dislike);
        }
    }

    public void setUsed(Boolean used) {
        this.used = used;
        if (used != null) {
            putQueryParameter("used", used);
        }
    }

    public Boolean getDislike() {
        return dislike;
    }

    public Boolean getLike() {
        return like;
    }

    public Boolean getUsed() {
        return used;
    }


    public CallScriptLikeRequest() {
        super("/api/optimalCallScript/operate", HttpMethodType.PUT);
    }

    @Override
    public Class getResponseClass() {
        return CallScriptLikeResponse.class;
    }
}
