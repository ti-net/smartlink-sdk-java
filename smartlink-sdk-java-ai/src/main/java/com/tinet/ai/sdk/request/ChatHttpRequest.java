package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.SuccessResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * @author 侯法超
 * @date 2021/3/3
 */

public class ChatHttpRequest extends BaseRequest<SuccessResponse> {

    /**
     * 会话唯一标识
     */
    private String uniqueId;

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
        if (uniqueId != null) {
            putQueryParameter("uniqueId", uniqueId);
        }
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
        if (loginId != null) {
            putQueryParameter("loginId", loginId);
        }
    }

    public void setSentenceId(String sentenceId) {
        this.sentenceId = sentenceId;
        if (sentenceId != null) {
            putQueryParameter("sentenceId", sentenceId);
        }
    }

    public void setType(String type) {
        this.type = type;
        if (type != null) {
            putQueryParameter("type", type);
        }
    }

    public void setQuery(String query) {
        this.query = query;
        if (query != null) {
            putQueryParameter("query", query);
        }
    }

    public void setPlayStatus(Boolean playStatus) {
        this.playStatus = playStatus;
        if (playStatus != null) {
            putQueryParameter("playStatus", playStatus);
        }
    }

    public void setIntent(String intent) {
        this.intent = intent;
        if (intent != null) {
            putQueryParameter("intent", intent);
        }
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getSentenceId() {
        return sentenceId;
    }

    public String getType() {
        return type;
    }

    public String getQuery() {
        return query;
    }

    public Boolean getPlayStatus() {
        return playStatus;
    }

    public String getIntent() {
        return intent;
    }

    /**
     * 单词订阅唯一标识
     */
    private String loginId;

    /**
     * 单句话id
     */
    private String sentenceId;

    /**
     * 对话类型(此字段供CC的asr转写结果使用)
     * intermediateResult  中间结果
     * sentenceEnd 一个完整的句子
     */
    private String type;
    /**
     * 用户说的话
     */
    private String query;
    /**
     * 播放状态
     */
    private Boolean playStatus;
    /**
     * 意图
     */
    private String intent;

    public ChatHttpRequest() {
        super("/api/chat", HttpMethodType.POST);
    }

    @Override
    public Class getResponseClass() {
        return SuccessResponse.class;
    }


}
