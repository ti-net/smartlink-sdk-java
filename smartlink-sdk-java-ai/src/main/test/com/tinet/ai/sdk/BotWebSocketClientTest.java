package com.tinet.ai.sdk;

import com.tinet.ai.sdk.handler.ChatResponseCallback;
import com.tinet.ai.sdk.request.ChatHttpRequest;
import com.tinet.ai.sdk.request.ChatRequest;
import com.tinet.ai.sdk.request.LogoutHttpRequest;
import com.tinet.ai.sdk.response.SuccessResponse;
import com.tinet.smartlink.sdk.core.SmartlinkClientConfiguration;
import com.tinet.smartlink.sdk.core.exceptions.ClientException;
import com.tinet.smartlink.sdk.core.exceptions.ServerException;
import org.apache.http.HttpHost;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author 侯法超
 * @date 2021/3/1
 */

public class BotWebSocketClientTest {

    private BotWebSocketClient client;
    private AIHttpClient httpClient;
    private String uuid = UUID.randomUUID().toString();
    private String ak = "6Z45P02IB48X3TAE585U";
    private String sk = "9q30r5d2675qe1ws6d7sw32v0pl1s0w1";

    @Before
    public void login() {

        initWebSocketClient();
        initHttpClient();
        login(uuid);


    }

    private void login(String loginId) {
        ClientSession clientSession = new ClientSession();
        clientSession.setBotId("363034");
        clientSession.setUserId(8000559);
        clientSession.setClientId("10086");

        System.out.println(loginId);
        clientSession.setLoginId(loginId);
        clientSession.setUniqueId(loginId);
        client.login(clientSession);
    }


    @Test
    public void chat() throws InterruptedException {

        System.out.println("activeSessionCount: " + client.activeSessionCount());
        ChatRequest chatRequest = new ChatRequest();
        chatRequest.setIntent("HELLO");
        chatRequest.setLoginId(uuid);
        chatRequest.setUniqueId(uuid);
        chatRequest.setQuery("Hello");
        chatRequest.setPlayStatus(false);
        client.chat(chatRequest);
        Thread.sleep(1000);

        chatRequest.setIntent(null);
        chatRequest.setQuery("是");
        client.chat(chatRequest);
        Thread.sleep(1000);

        chatRequest.setIntent(null);
        chatRequest.setQuery("1");
        client.chat(chatRequest);
        Thread.sleep(1000);

        client.logout(uuid, uuid);
        Thread.sleep(1000);
        System.out.println("activeSessionCount: " + client.activeSessionCount());
    }

    @Test
    public void muiltiChatTest() throws InterruptedException, ServerException, ClientException {
        List<String> loginIds = new ArrayList<>(10);
        for (int i = 0; i < 1; i++) {
            String uuid = UUID.randomUUID().toString();
            loginIds.add(uuid);
            login(uuid);
            Thread.sleep(200);
        }
        System.out.println("loginIds: " + loginIds);
        for (String loginId : loginIds) {
            chatWithHttp(loginId);
            Thread.sleep(200);
        }
    }

    @Test
    public void chatWithHttpTest() throws InterruptedException, ServerException, ClientException {
        System.out.println("activeSessionCount: " + client.activeSessionCount());
        chatWithHttp(uuid);
        System.out.println("activeSessionCount: " + client.activeSessionCount());
    }

    private void chatWithHttp(String loginId) throws InterruptedException, ServerException, ClientException {
        ChatHttpRequest chatRequest = new ChatHttpRequest();
        chatRequest.setIntent("HELLO");
        chatRequest.setLoginId(loginId);
        chatRequest.setUniqueId(loginId);
        chatRequest.setQuery("Hello");
        chatRequest.setPlayStatus(false);

        SuccessResponse successResponse = httpClient.getResponseModel(chatRequest);
        System.out.println(successResponse);
        Thread.sleep(800);

        chatRequest.setIntent(null);
        chatRequest.setQuery("是");
        httpClient.getResponseModel(chatRequest);
        Thread.sleep(800);

        ChatHttpRequest httpRequest = new ChatHttpRequest();
        httpRequest.setIntent(null);
        httpRequest.setQuery("是");
        httpClient.getResponseModel(chatRequest);
        Thread.sleep(800);

        LogoutHttpRequest logout = new LogoutHttpRequest();
        logout.setLoginId(loginId);
        httpClient.getResponseModel(logout);
        Thread.sleep(800);
    }


    private synchronized void initHttpClient() {
        SmartlinkClientConfiguration configuration = new SmartlinkClientConfiguration();
        // HttpHost host = new HttpHost("local.tinetcloud.com", 8086);
        HttpHost host = new HttpHost("tibot-test.tinetcloud.com");
        configuration.setHost(host);
        configuration.setAccessKeyId(ak);
        configuration.setAccessKeySecret(sk);
        httpClient = new AIHttpClient(configuration);
    }

    private synchronized void initWebSocketClient() {
        String host = "tibot-test.tinetcloud.com";
        //String host = "local.tinetcloud.com:8086";

        TibotWebSocketClientConfiguration configuration = new TibotWebSocketClientConfiguration(host, ak, sk);
        client = new BotWebSocketClient(configuration, new ChatResponseCallbackTest(), new AfterConnectHandlerTest());
    }

}
