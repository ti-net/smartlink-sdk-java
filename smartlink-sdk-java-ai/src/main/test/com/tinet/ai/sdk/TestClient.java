package com.tinet.ai.sdk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinet.ai.sdk.model.Bot;
import com.tinet.ai.sdk.model.enums.ChannelEnum;
import com.tinet.ai.sdk.model.enums.OrderRuleEnum;
import com.tinet.ai.sdk.request.*;
import com.tinet.ai.sdk.response.*;
import com.tinet.smartlink.sdk.core.SmartlinkClient;
import com.tinet.smartlink.sdk.core.SmartlinkClientConfiguration;
import com.tinet.smartlink.sdk.core.exceptions.ClientException;
import com.tinet.smartlink.sdk.core.exceptions.ServerException;
import org.apache.http.HttpHost;
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

        //测试环境
        configuration.setAccessKeyId("U550M65OOC1Y7842Y985");
        configuration.setAccessKeySecret("58w82m7j0bop2g4g5ghaprh43076p951");
        configuration.setHost(new HttpHost("smartai-openapi-test.tinetcloud.com"));

        //本地环境
        /*configuration.setAccessKeyId("59F6WZYJ6PT4G879D318");
        configuration.setAccessKeySecret("u610p9q44llvd1c0qluj06yq3d1946kz");
        configuration.setHost("localhost", 8085);*/

//        configuration.setConnectionRequestTimeout(100000);
        configuration.setConnectTimeout(100000);
        configuration.setSocketTimeout(100000);
        smartLinkClient = new SmartlinkClient(configuration);
    }

    // cticloud 测试使用
    @Test
    public void testTibotss() throws Exception{
        TibotRequest tibotRequest = new TibotRequest();
        tibotRequest.setUserId("8000001");
        tibotRequest.setBotType(2);

        TibotResponse articleResponse = smartLinkClient.getResponseModel(tibotRequest);
        System.out.println(articleResponse);
    }



    @Test
    public void testArticle() throws ServerException, ClientException, JsonProcessingException {

        KbArticleRequest articleRequest = new KbArticleRequest();
        articleRequest.setEnterpriseId(String.valueOf(8000559));
        // articleRequest.setKbId(782);
        // articleRequest.setKeyword("人工");
        //articleRequest.setOrder(OrderRuleEnum.NONE);
        articleRequest.setRepositoryType(0);
        articleRequest.setKbId(771);
        articleRequest.setDirectoryId(589);
        articleRequest.setKeyword("dede");
        //articleRequest.setKbId(424);
        articleRequest.setOffset(0);
        articleRequest.setLimit(40);
        articleRequest.setOrder(OrderRuleEnum.NONE);
        articleRequest.setChannelType(ChannelEnum.CONTENT);
//        articleRequest.setCno("123123");
//        articleRequest.setChannelType(ChannelEnum.CONTENT);

        KbArticleResponse articleResponse = smartLinkClient.getResponseModel(articleRequest);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(articleResponse));

    }

    @Test
    public void testArticleTitle() throws ServerException, ClientException, JsonProcessingException {

        KbArticleTitleRequest request = new KbArticleTitleRequest();
        request.setEnterpriseId("8000071");
        request.setKbId(52);
        request.setKeyword("钢笔");

        KbArticleTitleResponse responseModel = smartLinkClient.getResponseModel(request);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));

    }

    @Test
    public void testAuggest() throws ServerException, ClientException, JsonProcessingException {

        KbSuggestRequest request = new KbSuggestRequest();
        request.setEnterpriseId("8000071");
        request.setKbId(52);
        request.setKeyword("我");

        KbSuggestResponse responseModel = smartLinkClient.getResponseModel(request);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));

    }

    @Test
    public void testcorrection() throws ServerException, ClientException, JsonProcessingException {

        KbCorrectionRequest request = new KbCorrectionRequest();
        request.setEnterpriseId("8000071");
        request.setKbId(52);
        request.setKeyword("wendaku");

        KbCorrectionResponse responseModel = smartLinkClient.getResponseModel(request);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));

    }

    @Test
    public void testUnfold() throws ServerException, ClientException, JsonProcessingException {

        KbUnfoldRequest request = new KbUnfoldRequest();
        request.setEnterpriseId("8000071");
        request.setKbId(52);
        request.setId("rcdwB3IBtChfQmGYYyDZ");

        KbUnfoldResponse responseModel = smartLinkClient.getResponseModel(request);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));

    }

    @Test
    public void testRepository() throws ServerException, ClientException {
        KbRepositoryRequest repositoryRequest = new KbRepositoryRequest();
        repositoryRequest.setEnterpriseId(String.valueOf(3000000));

        KbRepositoryResponse repositoryResponse = smartLinkClient.getResponseModel(repositoryRequest);
        System.out.println(repositoryResponse.getRequestId());

    }
    @Test
    public void testDirectory() throws ServerException, ClientException {
        KbDirectoryRequest kbDirectoryRequest = new KbDirectoryRequest();
        kbDirectoryRequest.setEnterpriseId(String.valueOf(8000559));
        kbDirectoryRequest.setRepositoryType(1);

        KbDirectoriesResponse responseModel = smartLinkClient.getResponseModel(kbDirectoryRequest);
        System.out.println(responseModel.toString());

    }
    @Test
    public void testlikecount() throws ServerException, ClientException {
        KbLikeAndDislikeRequest request = new KbLikeAndDislikeRequest();
        request.setEnterpriseId(String.valueOf(8000071));
        request.setType(1);
        request.setFlag("0");
        request.setOperationType(0);
        request.setDataId("qcd2BnIBtChfQmGYmCBg");
        request.setCno("177103");

        KbLikeAndDislikeResponse responseModel = smartLinkClient.getResponseModel(request);
        System.out.println(responseModel.toString());

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
    public void testBot() throws ServerException, ClientException {
        BotRequest request = new BotRequest();
        request.setBotId("116067");
        request.setEnterpriseId("8000376");

        BotResponse responseModel = smartLinkClient.getResponseModel(request);
        Bot bot = responseModel.getBot();
        System.out.println(bot);

    }

    @Test
    public void testFile() throws ServerException, Exception {

        KbFileRequest fileRequest = new KbFileRequest();
        fileRequest.setEnterpriseId(String.valueOf(8000559));
        //fileRequest.setKbId(83);
        fileRequest.setCno("123123");
        fileRequest.setRepositoryType(2);
        fileRequest.setKbId(83);
        //fileRequest.setKeyword("测试");

        KbFileResponse fileResponse = smartLinkClient.getResponseModel(fileRequest);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(fileResponse));

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
    public void testpdfFileUrl() throws ServerException, ClientException {
        KbPdfFileUrlRequest request = new KbPdfFileUrlRequest();
        request.setFileKey("file/attachment/8000071/1585820518489.doc");
        request.setFileName("数据图.doc");
        request.setType("inline");

        KbFileUrlResponse response = smartLinkClient.getResponseModel(request);
        System.out.println(response.getFileUrl());

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

    @Test
    public void cdr() throws ServerException, ClientException {
        PushCdrRequest pushCdrRequest =new PushCdrRequest();
        pushCdrRequest.setUserId("8000071");
        pushCdrRequest.setUniqueId("b721e258-9814-4c23-8ddd-7b7dd4764d8a");
        pushCdrRequest.setCdrType("cdr_ob_agent");
        pushCdrRequest.setCallType(3);

        pushCdrRequest.setStartTime(System.currentTimeMillis()/1000);
        pushCdrRequest.setStartTime(1580990211L);

        pushCdrRequest.setAnswerTime(System.currentTimeMillis()/1000);
        pushCdrRequest.setEndTime(System.currentTimeMillis()/1000 + 3000);
        pushCdrRequest.setBridgeTime(System.currentTimeMillis()/1000);
        pushCdrRequest.setBridgeDuration(3000);
        pushCdrRequest.setTotalDuration(3000);
        pushCdrRequest.setStatus(1);
        pushCdrRequest.setEndReason(1);

        pushCdrRequest.setCno("003");
        pushCdrRequest.setAgentName("座席名称");

        PushCdrResponse responseModel = smartLinkClient.getResponseModel(pushCdrRequest);
        System.out.println(responseModel.toString());
    }

    @Test
    public void oem() throws ServerException, Exception {
        PushOemRequest pushCdrRequest = new PushOemRequest();
        pushCdrRequest.setAccountLoginName("aliyun");
        pushCdrRequest.setTitleText("测试");
        pushCdrRequest.setOemAccountId("001");

        PushOemResponse responseModel = smartLinkClient.getResponseModel(pushCdrRequest);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));
    }


    @Test
    public void intelligentAssociation() throws ServerException, Exception {
        IntelligentAssociationRequest intelligentAssociationRequest = new IntelligentAssociationRequest();
        intelligentAssociationRequest.setEnterpriseId("8000071");
        intelligentAssociationRequest.setBotId("798000");
        intelligentAssociationRequest.setText("jira");

        IntelligentAssociationResponse responseModel = smartLinkClient.getResponseModel(intelligentAssociationRequest);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));
    }


    @Test
    public void callScriptLikeRequest() throws ServerException, Exception {
        CallScriptLikeRequest callScriptLikeRequest = new CallScriptLikeRequest();
        callScriptLikeRequest.setId(1);
        callScriptLikeRequest.setLike(true);

        CallScriptLikeResponse responseModel = smartLinkClient.getResponseModel(callScriptLikeRequest);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));
    }

    @Test
    public void OptimalCallScriptRequest() throws ServerException, Exception {
        OptimalCallScriptRequest callScriptLikeRequest = new OptimalCallScriptRequest();
        callScriptLikeRequest.setEnterpriseId("123456");
        callScriptLikeRequest.setQuery("true");

        OptimalCallScriptResponse responseModel = smartLinkClient.getResponseModel(callScriptLikeRequest);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));
    }

    @Test
    public void tibotFileUrlRequest() throws ServerException, Exception {
        TibotFileUrlRequest tibotFileUrlRequest = new TibotFileUrlRequest();
        tibotFileUrlRequest.setFileKey("530aea5dc1764fa2a9d66b7bc6fe5c16%7C0909f07196de57a1c10aefad745a73efEpUGflCYUasmile.jpg");
        tibotFileUrlRequest.setFileName("smile.jpg");
        tibotFileUrlRequest.setProvider("emotibot");
        tibotFileUrlRequest.setType("inline");
//        tibotFileUrlRequest.setWidth(100000);
        tibotFileUrlRequest.setHeight(100);

        TibotFileUrlResponse responseModel = smartLinkClient.getResponseModel(tibotFileUrlRequest);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));
    }
}
