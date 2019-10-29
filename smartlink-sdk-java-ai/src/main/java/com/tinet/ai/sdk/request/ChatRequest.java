package com.tinet.ai.sdk.request;

import lombok.Data;

/**
 * CC调用TiBot的请求体封装
 * 
 * @author Jiangsl
 *
 */
@Data
public class ChatRequest {

	/**
	 * 会话唯一标识
	 */
	private String uniqueId;
	/**
	 * 对话类型(此字段供CC的asr转写结果使用)
	 * intermediateResult  中间结果
	 * sentenceEnd 一个完整的句子
	 */
	private String type;
	/**
	 * 用户说的话
	 */
	private String query;
	/**
	 * 播放状态
	 */
	private Boolean playStatus;
	/**
	 * 意图
	 */
	private String intent;

}
