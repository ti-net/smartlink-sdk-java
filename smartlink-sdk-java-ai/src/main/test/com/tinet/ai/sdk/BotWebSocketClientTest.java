package com.tinet.ai.sdk;

import com.tinet.ai.sdk.handler.ChatResponseCallback;
import com.tinet.ai.sdk.request.ChatHttpRequest;
import com.tinet.ai.sdk.request.ChatRequest;
import com.tinet.smartlink.sdk.core.SmartlinkClientConfiguration;
import com.tinet.smartlink.sdk.core.exceptions.ClientException;
import com.tinet.smartlink.sdk.core.exceptions.ServerException;
import org.apache.http.HttpHost;
import org.junit.Before;
import org.junit.Test;

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

        ClientSession clientSession = new ClientSession();
        clientSession.setBotId("415122");
        clientSession.setUserId(8000071);
        clientSession.setClientId("10086");

        System.out.println(uuid);
        clientSession.setLoginId(uuid);
        clientSession.setUniqueId(uuid);
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
        client.chat(chatRequest);
        Thread.sleep(10000);
    }

    @Test
    public void chatWithHttp() throws InterruptedException, ServerException, ClientException {
        System.out.println("activeSessionCount: " + client.activeSessionCount());
        ChatHttpRequest chatRequest = new ChatHttpRequest();
        chatRequest.setIntent("HELLO");
        chatRequest.setLoginId(uuid);
        chatRequest.setUniqueId(uuid);
        chatRequest.setQuery("Hello");
        httpClient.getResponseModel(chatRequest);
        Thread.sleep(10000);
    }

    private void initHttpClient() {
        SmartlinkClientConfiguration configuration = new SmartlinkClientConfiguration();
        HttpHost host = new HttpHost("local.tinetcloud.com", 8086);
        configuration.setHost(host);
        configuration.setAccessKeyId(ak);
        configuration.setAccessKeySecret(sk);
        httpClient = new AIHttpClient(configuration);
    }

    private void initWebSocketClient() {
        String host = "local.tinetcloud.com:8086";

        TibotWebSocketClientConfiguration configuration = new TibotWebSocketClientConfiguration(host, ak, sk);
        client = new BotWebSocketClient(configuration, new ChatResponseCallbackTest(), new AfterConnectHandlerTest());
    }
}
