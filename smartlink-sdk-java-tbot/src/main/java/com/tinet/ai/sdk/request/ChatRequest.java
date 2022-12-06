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
	 * 单词订阅唯一标识
	 */
	private String loginId;

	/**
	 * 单句话id
	 */
	private String sentenceId;

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

	/**
	 * 平台客户端服务器唯一标识，作为订阅路径
	 * 一旦采用新版本的SDK后，此参数不为空，老版本为null。
	 */
	private String platformClientId;

}
