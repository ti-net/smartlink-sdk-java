package com.tinet.asr.sdk.model;


import lombok.Data;

import java.util.Date;

/**
 * task任务的实体类
 * @author 王大宝
 * @date 2018-11-26
 */
@Data
public class AsrTaskData {

    /**
     * 自增主键
     */
    private Integer id;
    /**
     * 按时间分表key
     */
    private Date partitionKey;
    /**
     *  用户登录名
     */
    private String accountLoginName;
    /**
     * 企业ID
     */
    private String enterpriseId;
    /**
     * 内部用户录音的唯一标识，第三方命名规则“唯一标识+"-" + 秒级时间戳 +"."+5位随机数”（）
     * 但是数据库中存储的值是拼接了其他信息的。因为有双轨IN/OUT的情况，为了确定uniqueId是唯一的，需要在uniquId前面拼接上转写引擎和转写侧.
     * 例如：3000001_Tinet_IN_10.10.62.138-1554964748.121328
     */
    private String uniqueId;
    /**
     * 转写任务Id
     */
    private String taskId;
    /**
     * 录音文件名
     */
    private String fileName;
    /**
     * * 如果录音做了分轨，该录音是双轨录音的一侧，必须指定该录音文件是 agent/client ，便于区分两侧。agent是坐席侧client是客户侧，
     * 不传值默认是单轨录音.
     */
    private String recordSide;
    /**
     * 转写结果json字符串
     */
    private String asrText;
    /**
     * 转写录音时长(毫秒)
     */
    private Integer asrDuration;
    /**
     * 计费时长（分钟）：不满一分钟按照一分钟去算。取模加一
     */
    private Integer billingDuration;
    /**
     * 企业转写回调地址
     */
    private String callbackUrl;
    /**
     * 选择转型引擎，默认是天润自建：Tinet
     */
    private String asrProvider;
    /**
     * 文件录音下载地址
     */
    private String fileUrl;
    /**
     * uniqueId中的秒级时间戳
     */
    private Long time;
    /**
     * 转写状态。成功/失败
     */
    private String status;

    /**
     * 是否开启慧智。默认不开启，开启慧智后转写结果会推送到慧智一份
     */
    private Boolean enableSqc = false;

    /**
     * 录音来源类型、默认是类型 1
     * 1：平台自计费话单录音。（一般这种情况转写后不需要推送bigboss计费）
     * 2：质检平台第三方用户（90开头的企业）
     * 3：客户通过接口对接质检，（例如vnc的一些企业）
     * 4：页面上传录平台第三方客户话单音做质检的话单
     */
    private Integer cdrSource = 1;

    /**
     * 失败原因
     */
    private String failedMessage;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建时间
     */
    private Date updateTime;

}
