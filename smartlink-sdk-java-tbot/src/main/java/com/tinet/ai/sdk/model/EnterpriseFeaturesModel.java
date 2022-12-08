package com.tinet.ai.sdk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * enterprise
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnterpriseFeaturesModel implements Serializable {

    /**
     * 功能代号
     * robot_chat：在线机器人，robot_call：语音机器人，robot_text：文本机器人，voice_robot_ob：外呼机器人，voice_robot_ab：协呼机器人，voice_robot_ib：呼入机器人，robot_tmate：助手机器人
     */
    private String code;

    /**
     * 功能描述
     */
    private String name;

    /**
     * 机器人厂商
     * emotibot：竹间，baidu：百度，rulai：如来，mango：芒果，yunwen：云问，zhuiyi：追一，tbot：自研机器人，laiye：来也
     */
    private String provider;

    /**
     * 功能开关
     */
    private String openFlag;

    /**
     * 功能扩展配置
     */
    private List<String> config;

    private static final long serialVersionUID = 1L;
}