package com.tinet.auth.sdk.request;


import com.tinet.auth.sdk.model.ProductEnum;
import com.tinet.auth.sdk.response.PermissionResponse;
import com.tinet.smartlink.sdk.core.HttpMethodType;
import com.tinet.smartlink.sdk.core.request.BaseRequest;

/**
 * 获取权限列表
 * @author 王大宝
 */
public class PermissionRequest extends BaseRequest<PermissionResponse> {


    /**
     * 产品
     */
    private String product;

    public String getProduct() {
        return product;
    }

    public void setProduct(ProductEnum productEnum) {
        this.product = productEnum.getValue();
        if (product != null) {
            putQueryParameter("product", product);
        }
    }

    public PermissionRequest() {

        super("/auth/permission", HttpMethodType.GET);
    }

    @Override
    public Class<PermissionResponse> getResponseClass() {
        return PermissionResponse.class;
    }
}
