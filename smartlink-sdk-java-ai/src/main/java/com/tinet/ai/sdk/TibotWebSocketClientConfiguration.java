package com.tinet.ai.sdk;

import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

/**
 * TibotWebSocketClient 配置
 * 
 * @author houfc
 * @date 2019/3/14
 */
public class TibotWebSocketClientConfiguration {

	private String host;
	private String accessKeyId;
	private String accessKeySecret;
	private int expires = 5;

	public TibotWebSocketClientConfiguration(@NonNull String host, @NonNull String accessKeyId, @NonNull String accessKeySecret) {

		Assert.notNull(host, "websocket host can't be null");

		this.accessKeyId = accessKeyId;
		this.accessKeySecret = accessKeySecret;
		this.host = host;
	}

	public String getAccessKeyId() {
		return accessKeyId;
	}

	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}

	public String getAccessKeySecret() {
		return accessKeySecret;
	}

	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getExpires() {
		return expires;
	}

	public void setExpires(int expires) {
		this.expires = expires;
	}
}
