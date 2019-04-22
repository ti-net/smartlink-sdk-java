package com.tinet.smartlink.commons.sdk;

import com.tinet.smartlink.sdk.core.SmartlinkClient;
import com.tinet.smartlink.sdk.core.SmartlinkClientConfiguration;
import com.tinet.smartlink.sdk.core.exceptions.ClientException;
import com.tinet.smartlink.sdk.core.exceptions.ServerException;
import org.junit.Before;
import org.junit.Test;

public class TestClient {

    SmartlinkClient smartLinkClient;

    @Before
    public void init() {
        SmartlinkClientConfiguration configuration = new SmartlinkClientConfiguration();

        configuration.setAccessKeyId("1994F4Ygc23UY5C7DdCl");
        configuration.setAccessKeySecret("geeke68cbdea6f95c81620243b10c9cd");
        configuration.setHost("localhost", 8080);
        smartLinkClient = new SmartlinkClient(configuration);
    }

    @Test
    public void demo1Test() throws ServerException, ClientException {
        UserRequset requset = new UserRequset();
        requset.setName("hello");
        requset.setPassword("world");
        UserResponse response = smartLinkClient.getResponseModel(requset);
        System.out.println(response);
    }

    @Test
    public void pageTest() throws ServerException, ClientException {
        UserPageResponse response = smartLinkClient.getResponseModel(new UserPageRequest());
    }

    @Test
    public void createTest() throws ServerException, ClientException {
        UserPostRequest request = new UserPostRequest();
        request.setName("geek");
        request.setPassword("hello");
        UserPostResponse response = smartLinkClient.getResponseModel(request);
        System.out.println(response.getName());
    }
}
