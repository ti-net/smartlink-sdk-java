package com.tinet.ai.sdk.response;


import com.tinet.smartlink.sdk.core.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;


/**
 * @author 周先康
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class EnterpriseGrayQKResponse extends BaseResponse {

    private Integer id;

    private String enterpriseId;

    private LocalDateTime createTime;

    private String createUser;

    private LocalDateTime updateTime;

    private String updateUser;

    private Boolean tibotSwitch;

    private Boolean kbSwitch;
}
