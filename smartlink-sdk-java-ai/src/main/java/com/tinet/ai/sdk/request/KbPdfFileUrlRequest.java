package com.tinet.ai.sdk.request;

import com.tinet.ai.sdk.response.KbFileUrlResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 知识库文章图片链接生成请求
 *
 * @author huwk
 * @date 2019/9/18
 **/
public class KbPdfFileUrlRequest extends BaseRequest<KbFileUrlResponse> {

    /**
     * 文件路径
     */
    private String fileKey;
    private String fileName;
    private String type;

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

    public KbPdfFileUrlRequest() {
        super("/api/files/pdf", HttpMethodType.GET);
    }

    @Override
    public Class getResponseClass() {
        return KbFileUrlResponse.class;
    }
}
