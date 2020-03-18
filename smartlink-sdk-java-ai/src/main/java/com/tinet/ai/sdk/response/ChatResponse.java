package com.tinet.ai.sdk.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

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
	 * 播放类型：tts、voice、url、extends
	 */
	private String playType;

	/**
	 * 播放对象，针对上述播放类型，分别是：TTS文本、录音文件ID、录音文件URL地址
	 * extends:播放多个语音
	 * [{"playType":"tts","playObject":"你好"},{"playType":"voice","playObject":"3123123/23131"}]
	 * [{"playType":"tts", "playObject":"您好您是","playType":"variables", "playObject":"${name}","playType":"tts","playObject":"吗？"}]
	 */
	private String playObject;

	/**
	 * 动作指令，可能会有多个，按顺序执行，例如先挂机（END），再发送短信（SMS）。动作指令统一在播放（play）完成后执行。
	 */
	private List<String> action;

	/**
	 * 机器人响应文本
	 */
	private String playText;
	/**
	 * 响应意图
	 */
	private String responseIntent;
}
