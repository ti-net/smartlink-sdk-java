package com.tinet.ai.sdk;

import com.tinet.ai.sdk.request.*;
import com.tinet.ai.sdk.response.*;
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

        configuration.setAccessKeyId("6Z45P02IB48X3TAE585U");
        configuration.setAccessKeySecret("9q30r5d2675qe1ws6d7sw32v0pl1s0w1");
        configuration.setHost("localhost", 8084);
        configuration.setConnectionRequestTimeout(100000);
        configuration.setConnectTimeout(100000);
        configuration.setSocketTimeout(100000);
        smartLinkClient = new SmartlinkClient(configuration);
    }


    @Test
    public void testArticle() throws ServerException, ClientException {

        KbArticleRequest articleRequest = new KbArticleRequest();
        articleRequest.setEnterpriseId(String.valueOf(3000000));
        articleRequest.setKbId(1);

        KbArticleResponse articleResponse = smartLinkClient.getResponseModel(articleRequest);
        System.out.println(articleResponse.getRequestId());

    }

    @Test
    public void testRepository() throws ServerException, ClientException {
        KbRepositoryRequest repositoryRequest = new KbRepositoryRequest();
        repositoryRequest.setEnterpriseId(String.valueOf(3000000));

        KbRepositoryResponse repositoryResponse = smartLinkClient.getResponseModel(repositoryRequest);
        System.out.println(repositoryResponse.getRequestId());

    }
    @Test
    public void testTibot() throws ServerException, ClientException {
        TibotRequest request = new TibotRequest();
        request.setUserId(String.valueOf(3000000));

        TibotResponse response = smartLinkClient.getResponseModel(request);
        System.out.println(response.getRequestId());

    }
    @Test
    public void testImageUrl() throws ServerException, ClientException {
        KbArticleImageUrlRequest request = new KbArticleImageUrlRequest();
        request.setFilePath("article/images/1569224913886.png");

        KbArticleImageUrlResponse response = smartLinkClient.getResponseModel(request);
        System.out.println(response.getRequestId());

    }

    @Test
    public void testAvatar() throws ServerException, ClientException {
        BotAvatarUrlRequest request = new BotAvatarUrlRequest();
        request.setBotId(126671);
        request.setEnterpriseId("3000000");

        BotAvatarUrlResponse response = smartLinkClient.getResponseModel(request);
        System.out.println(response.getRequestId());

    }

    @Test
    public void testFile() throws ServerException, ClientException {

        KbFileRequest fileRequest = new KbFileRequest();
        fileRequest.setEnterpriseId(String.valueOf(8000071));
        fileRequest.setKbId(23);

        KbFileResponse fileResponse = smartLinkClient.getResponseModel(fileRequest);
        System.out.println(fileResponse.getRequestId());

    }

    @Test
    public void testFileUrl() throws ServerException, ClientException {
        KbFileUrlRequest request = new KbFileUrlRequest();
        request.setFileKey("file/attachment/8000071/1571047487849.jpg");
        request.setFileName("CC呼叫云重点客户COP号码使用情况.xlsx");
        request.setType("inline");

        KbFileUrlResponse response = smartLinkClient.getResponseModel(request);
        System.out.println(response.getRequestId());

    }

    @Test
    public void testCallScriptRecommendation() throws ServerException, ClientException {
        CallScriptRecommendationRequest request = new CallScriptRecommendationRequest();
        request.setBotId("646853");
        request.setQuery("哈哈");
        request.setTop(5);
        CallScriptRecommendationResponse responseModel = smartLinkClient.getResponseModel(request);
        System.out.println(responseModel.getRequestId());
        System.out.println(responseModel.getRecommendations());
    }
}
