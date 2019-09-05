package com.tinet.sqc.sdk.websocket.model;

import lombok.Data;

/**
 * ES 中关键词标记数结构
 * todo mark由于匹配的是记录了两种不同的标记，
 * 是否有必要，新增字段进行区分。
 * @author 侯法超
 * @date 2017年10月26日
 */
@Data
public class KeywordMark {

	/**
	 * 关键词所在语句的id
	 */
	private String id;

	/**
	 * 关键词在句中的起始位置
	 */
	private Integer index;

	/**
	 * 关键词长度
	 */
	private Integer length;

	/**
	 * 关键词
	 */
	private String keyword;

	/**
	 * 关键词组名
	 */
	private String group;

	/**
	 * 客户侧或者座席侧标识，0:座席侧 1:客户侧
	 */
	private int type;
}
