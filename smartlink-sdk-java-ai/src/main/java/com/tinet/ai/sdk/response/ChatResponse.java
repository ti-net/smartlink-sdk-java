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
	 * 机器人提供商标识
	 */
	private String provider;

	/**
	 * 标准问  (命中的问题)
	 */
	private String standardQuestion;

	/**
	 * 响应意图
	 */
	private String responseIntent;

	/**
	 * 扩展字段
	 */
	private Map<String, Object> ext;

	/**
	 * 会话模块:
	 *
	 * 1. faq：标准问题匹配
	 * 2. task_engine：多轮-任务流引擎
	 * 3. function：内部技能
	 * 4. remote_skill：云技能
	 * 5. domain_kg：知识图谱
	 * 6. kg：通用知识库
	 * 7. chat：闲聊
	 * 8. backfill：未知回复
	 * 9. keyword: 关键字模块
	 * 10. tde_task_engine: 多轮填槽引擎
	 * 11. to_human: 转人工
	 * 12. custom_skill: 定制技能
	 * 13. chat_story: 聊天小故事
	 * 14. emotion: 情绪
	 */
	private String module;

	/**
	 * 出话来源，主要为了标记转人工的类型:
	 *
	 * 1. backfill: 机器人连续无结果转人工
	 * 2. faq-repeat-question: 连续命中同一标准问转人工
	 * 3. faq-label: 场景标准问HUMAN标签转人工
	 * 4. emoiton: 负面情绪转人工
	 * 5. human-intent: 系统转人工、意图转人工
	 * 6. keyword: 关键词转人工
	 * 7. intent: 意图引擎转人工、意图转人工
	 */
	private String source;

	/**
	 * 问题标签
	 */
	private List<String> faqQuestionTags;

	/**
	 * 答案标签
	 */
	private List<String> faqAnswerTags;

	/**
	 * faq分类即目录
	 */
	private List<String> faqCategory;

	/**
	 * 匹配的真正问题
	 */
	private String faqMatchQuestion;

	/**
	 * faq关联ID
	 */
	private String faqRelatedUID;

	/**
	 * 响应ID，对应竹间的一次对话ID: uniqueId
	 */
	private String responseId;

	/**
	 * 任务引擎标签（多轮标签）。map中的key是name和value，name：标签的名称；value：标签的值；
	 */
	private List<Map> taskEngineTags;

}
