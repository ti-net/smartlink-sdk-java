package com.tinet.ai.sdk.model.enums;

/**
 * ClassFor:
 * ChatRequest.type
 * 对话类型(此字段供CC的asr转写结果使用)
 *
 * @author zhaojy
 * @date 19/11/4
 */
public enum AsrTypeEnum {

    /**
     * intermediateResult  中间结果
     */
    INTERMEDIATE_RESULT("intermediateResult"),
    /**
     * sentenceEnd 一个完整的句子
     */
    SENTENCE_END("sentenceEnd"),
    /**
     * 按键交互
     */
    DTMF("dtmf");


    private String value;

    AsrTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
