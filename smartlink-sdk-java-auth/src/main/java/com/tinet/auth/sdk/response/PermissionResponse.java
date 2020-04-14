package com.tinet.auth.sdk.response;


import com.tinet.auth.sdk.model.Permission;
import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * 准写结果查询的response
 * @author 王大宝
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class PermissionResponse extends BaseResponse {

    /**
     * 权限列表
     */
    private List<Permission> permissionList;

}
