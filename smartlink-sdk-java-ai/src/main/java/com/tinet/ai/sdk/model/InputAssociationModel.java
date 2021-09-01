package com.tinet.ai.sdk.model;

import lombok.Data;
import lombok.ToString;

/**
 * 输入联想
 *
 * @author feizq
 * @date 2021/09/01
 **/
@Data
@ToString
public class InputAssociationModel {

    /**
     * 答案Id
     */
    private Integer id;

    /**
     * 回答
     */
    private String answer;

    /**
     * 问题
     */
    private String title;
}
