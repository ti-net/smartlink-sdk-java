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
	private String uniqueId;
	private String query;
	private Boolean playStatus;
}
