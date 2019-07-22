package com.tinet.sqc.sdk.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 王大宝
 * @date 2019/7/22
 */
@Data
public class Record implements Serializable {

    /**
     * 录音下载地址
     */
    private String fileUrl;

    /**
     * 如果录音做了分轨，该录音是双轨录音的一侧，必须指定该录音文件是 agent/client ，便于区分两侧。agent是坐席侧client是客户侧，不传值默认是单轨录音.
     */
    private String recordSide;
}
