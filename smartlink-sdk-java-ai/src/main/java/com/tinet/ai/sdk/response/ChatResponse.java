package com.tinet.ai.sdk.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * CC调用TiBot的响应体封装
 *
 * @author Jiangsl
 *
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatResponse {
	/**
	 * 企业Id
	 */
	private Integer userId;
	/**
	 * Cdr 中的 uniqueId
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
	 * 机器人唯一标识
	 */
	private String botId;

	/**
	 * 会话标签
	 */
	private List<String> userTag;

	/**
	 * 错误码，非0代表有系统错误
	 */
	private Integer errorCode;

	/**
	 * 有错误时返回出错信息
	 */
	private String errorMessage;

	/**
	 * 是否等待前一个语音播放完成再播放当前语音
	 */
	private Boolean playWait = true;

	/**
	 * 机器人的话是否可打断
	 */
	private Boolean playInterrupt;

	/**
	 * 是否播放多个响应
	 * true:时 playObjects存在
	 * false:时 playType,playObject存在
	 */
	private Boolean isMultiPlay;

	/**
	 * 播放类型：tts、voice、url、tts_variable
	 */
	private String playType;

	/**
	 * 播放对象，针对上述播放类型，分别是：TTS文本、录音文件ID、录音文件URL地址
	 */
	private String playObject;

	/**
	 * 多个响应
	 * [{"playType":"tts","playObject":"你好"},{"playType":"voice","playObject":"3123123/23131"}]
	 * [{"playType":"tts", "playObject":"您好您是","playType":"tts_variable", "playObject":"${name}","playType":"tts","playObject":"吗？"}]
	 */
	private List<Map> playObjects;

	/**
	 * 动作指令，可能会有多个，按顺序执行，例如先挂机（END），再发送短信（SMS）。动作指令统一在播放（play）完成后执行。
	 */
	private List<String> action;

	/**
	 * 机器人响应文本
	 */
	private String playText;

	/**
	 * 标准问  (命中的问题)
	 */
	private String standardQuestion;

	/**
	 * 响应意图
	 */
	private String responseIntent;
}
