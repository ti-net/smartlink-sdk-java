package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.model.Knowledge;
import lombok.Data;

import java.util.Map;

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

	/**
	 * ● 热门问知识ID
	 * ● 推荐问知识ID
	 * ● 关联问知识ID
	 * ● 多轮会话选项列表知识ID：选项列表知识ID可为空；若选项列表添加为意图时，回传意图ID；若选项列表为变量判断时，回传知识ID为空。
	 */
	private Knowledge knowledge;

	/**
	 * 语音元数据透传 tibot用
	 * caller_number 主叫号码
	 * callee_number 被叫
	 */
	private Map<String, Object> voiceMetadata;
}
