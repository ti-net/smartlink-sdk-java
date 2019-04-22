package com.tinet.smartlink.sdk.core.model;

import java.io.Serializable;

/**
 * 外呼或者webcall主话单 回调方法对应的成员变量productId :平台id
 * @author mucw
 *
 */
public enum Platform implements Serializable {
	CLINK,
	CTICLOUD,
	VLINK,
	VNC,//虚拟号码保护平台
	SIPCLOUD,
}
