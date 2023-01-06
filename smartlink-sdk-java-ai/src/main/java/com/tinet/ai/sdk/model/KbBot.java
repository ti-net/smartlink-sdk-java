package com.tinet.ai.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

/**
 * 机器人知识库关联表
 *
 * @author huwk
 * @date 2019/10/18
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class KbBot {

    /**
     * 主键
     */
    private Integer id;

    private String requestId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private String botId;

    private Integer kbId;

    private Integer accountId;

    private String createUser;

    private String updateUser;
}
