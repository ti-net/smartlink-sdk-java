package com.tinet.smartlink.sdk.core.model;

import java.io.Serializable;

public enum Product implements Serializable {
	VOICE_NOTICE, //语音通知类型
	CALL_BOTH_ENDS, //标准两端呼类
	PREDICT_CALL, //预测外呼类
	CALL_IN,//呼入类型
}
