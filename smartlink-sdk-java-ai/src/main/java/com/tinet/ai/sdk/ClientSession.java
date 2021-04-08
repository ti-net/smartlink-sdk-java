package com.tinet.ai.sdk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 注册时使用的信息
 * @author houfc
 * @date 2019/3/16
 */
@Data
public class ClientSession {

    /**
     * cdr 中的 uniqueId (一通会话唯一标识)
     */
    private String uniqueId;

    /**
     * 单此会话唯一标识( 同一用户多次进入机器人)
     */
    private String loginId;

    /**
     * 三户模型中的 userId，对应 CC 的 enterpriseId
     */
    private Integer userId;

    /**
     * 三户模型中的 clientId，对应 CC 中的客户号码
     */
    private String clientId;

    /**
     * 企业所配置的机器人 ID
     */
    private String botId;

    /**
     * 请求参数
     */
    private Map<String, String> params;

    @JsonIgnore
    private ScheduledExecutorService scheduledExecutorService
            = new ScheduledThreadPoolExecutor(1, new CustomizableThreadFactory("TBot-pool-"));

    @JsonIgnore
    public AtomicInteger unConnectCount = new AtomicInteger(0);

}
