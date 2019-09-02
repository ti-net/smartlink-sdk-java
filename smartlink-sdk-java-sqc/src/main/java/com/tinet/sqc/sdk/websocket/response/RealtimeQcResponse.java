package com.tinet.sqc.sdk.websocket.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tinet.sqc.sdk.websocket.model.AutoDpResult;
import com.tinet.sqc.sdk.websocket.model.AutoItem;
import com.tinet.sqc.sdk.websocket.model.KeywordMark;
import com.tinet.sqc.sdk.websocket.model.QcResultScore;
import lombok.Data;

import java.util.List;

/**
 * @author houfc
 * @date 2019/08/20
 */
@Data
public class RealtimeQcResponse {

    /**
     * uniqueId
     */
    private String uniqueId;


    /**
     * 当前识别到的文本对应的识别编号
     */
    private String sentenceId;

    /**
     * 实时转写文本
     */
    private String text;

    /**
     * 质检得分
     */
    private Double qcScore;

    /**
     * 质检项得分
     */
    private List<QcResultScore> qcResultScores;

    /**
     * 对话分析标签
     */
    private List<AutoDpResult> autoDpResults;

    /**
     * 关键词组标记数
     */
    private List<KeywordMark> keywordMarks;

    /**
     * 自动质检详情
     */
    private List<AutoItem> autoItems;
}
