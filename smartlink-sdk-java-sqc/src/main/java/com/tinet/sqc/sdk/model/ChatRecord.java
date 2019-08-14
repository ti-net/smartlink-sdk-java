package com.tinet.sqc.sdk.model;

import lombok.Data;

/**
 * 顺丰对话记录实体
 *
 * @author liuhy
 * @date 2019/8/12 17:54
 */
@Data
public class ChatRecord {

    /**
     * 外键(conversation 表id)
     */
    private String refUUID;
    /**
     * 系统标识
     */
    private String sysFlag;
    /**
     * 类型
     */
    private String type;
    /**
     * 消息落地时间
     */
    private long startTime;
    /**
     * 发送人角色：对于机器人【 ask , ans】;对于人工：【user,admin】
     */
    private String role;
    /**
     * 对话内容
     */
    private String text;
    /**
     * 原始消息内容
     */
    private String srcText;

    /** 竹间附加信息*/
    /**
     * 问题ID
     */
    private String questionID;
    /**
     * 回答ID
     */
    private String answerID;
    /**
     * 置信度
     */
    private int moduleScore;
    /**
     * 回答类型  faq/task_enqine/chat
     */
    private String module;
    /**
     * 客服名
     */
    private String opLoginId;
}
