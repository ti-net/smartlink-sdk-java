package com.tinet.ai.sdk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinet.assistant.request.PushRealTimeAsrRequest;
import com.tinet.assistant.response.PushRealTimeAsrResponse;
import com.tinet.smartlink.sdk.core.SmartlinkClient;
import com.tinet.smartlink.sdk.core.SmartlinkClientConfiguration;
import com.tinet.smartlink.sdk.core.exceptions.ClientException;
import com.tinet.smartlink.sdk.core.exceptions.ServerException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * 测试客户端
 *
 * @author huwk
 * @date 2019/9/19
 **/
@Ignore
public class TestClient {
    SmartlinkClient smartLinkClient;

    @Before
    public void init() {
        SmartlinkClientConfiguration configuration = new SmartlinkClientConfiguration();

        configuration.setAccessKeyId("U550M65OOC1Y7842Y985");
        configuration.setAccessKeySecret("58w82m7j0bop2g4g5ghaprh43076p951");
        configuration.setHost("localhost", 8086);
        //configuration.setHost(new HttpHost("smartai-openapi-test.tinetcloud.com"));
        configuration.setConnectionRequestTimeout(100000);
        configuration.setConnectTimeout(100000);
        configuration.setSocketTimeout(100000);
        smartLinkClient = new SmartlinkClient(configuration);
    }


    @Test
    public void testAsr() throws JsonProcessingException {

        PushRealTimeAsrRequest asrRequest = new PushRealTimeAsrRequest();
        asrRequest.setEnterpriseId(String.valueOf(8000071));
        asrRequest.setSide(1);

        PushRealTimeAsrResponse articleResponse = null;
        try {
            articleResponse = smartLinkClient.getResponseModel(asrRequest);
        } catch (ServerException | ClientException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(articleResponse));

    }

}
