package com.tinet.asr.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author
 * @date
 */
@Data
public class SentenceResult {
    @JsonProperty("sentence_id")
    private Integer sentenceId;


    @JsonProperty("channel_id")
    private Integer channelId;

    @JsonProperty("begin_time")
    private Integer beginTime;

    @JsonProperty("end_time")
    private Integer endTime;

    @JsonProperty("emotion_value")
    private Integer emotionValue;

    @JsonProperty("silence_duration")
    private Integer silenceDuration;

    @JsonProperty("speech_rate")
    private Integer speechRate;

    @JsonProperty("text")
    private String text;


}
