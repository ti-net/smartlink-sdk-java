package com.tinet.ai.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

/**
 * 文章响应实体
 *
 * @author huwk
 * @date 2019/9/3
 **/
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class TitleModel {

    private String id;
    /**
     * 标题
     */
    private String title;

}
