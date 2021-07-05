package com.tinet.ai.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 对会话进行点赞或点踩接口返回数据模型
 * 
 * @author feizq
 * @date 2021/06/22
 **/
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedbackModel implements Serializable {

    /**
     * 数据类型：text
     */
    private String type;

    /**
     *  子类型：text
     */
    private String subType;

    /**
     * 返回内容文本。
     */
    private String value;

    /**
     * 答案类型。
     */
    private String answerType;

    /**
     * 扩展响应数据
     */
    private List<Object> data;
}
