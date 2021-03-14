package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.TibotFileUrlResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 机器人消息附件链接请求
 *
 * @author huwk
 * @date 2021/3/10
 **/
public class TibotFileUrlRequest extends BaseRequest<TibotFileUrlResponse> {

    /**
     * 文件路径
     */
    private String fileKey;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 下载标识。枚举值为 inline 预览, attachment 附件下载。
     */
    private String type;

    /**
     * 机器人提供商
     */
    private String provider;

    /**
     * 图片宽度
     */
    private Integer width;

    /**
     * 图片高度
     */
    private Integer height;

    public String getFileKey() {
        return fileKey;
    }

    public void setFileKey(String fileKey) {
        this.fileKey = fileKey;
        if (fileKey != null) {
            putQueryParameter("fileKey", fileKey);
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        if (fileName != null) {
            putQueryParameter("fileName", fileName);
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        if (type != null) {
            putQueryParameter("type", type);
        }
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
        if (provider != null) {
            putQueryParameter("provider", provider);
        }
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
        if (width != null) {
            putQueryParameter("width", width);
        }
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
        if (height != null) {
            putQueryParameter("height", height);
        }
    }

    public TibotFileUrlRequest() {
        super("/api/tibots/message/attachment", HttpMethodType.GET);
    }

    @Override
    public Class getResponseClass() {
        return TibotFileUrlResponse.class;
    }
}
