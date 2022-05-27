package com.tinet.ai.sdk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinet.ai.sdk.model.Bot;
import com.tinet.ai.sdk.model.EventData;
import com.tinet.ai.sdk.model.KbArticleResponseModel;
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

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void webhook() throws Exception{
        WebhookRequest request = new WebhookRequest();

        request.setEvent("clink2-account-managet");
        EventData data = new EventData();
        data.setName("中国石化测试1");
        data.setEnterpriseId(2000002L);
        data.setStatus(1);
        request.setData(data);

        WebhookResponse responseModel = smartLinkClient.getResponseModel(request);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));
    }


    @Test
    public void describeRespository() throws Exception{
        DescribeKbRepositoryRequest request = new DescribeKbRepositoryRequest();

        request.setOwner("3954");
        request.setEnterpriseId("8000559");

        DescribeKbRepositoryResponse responseModel = smartLinkClient.getResponseModel(request);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));
    }

    @Test
    public void createDirectory() throws Exception{
        CreateKbDirectoryRequest request = new CreateKbDirectoryRequest();

        request.setKbId(875);
        request.setLeaf(0);
        request.setParentId(2904);
        request.setName("冬至目录4");
        request.setOwner("3954");
        request.setEnterpriseId("8000559");

        KbDirectoryResponse responseModel = smartLinkClient.getResponseModel(request);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));
    }

    @Test
    public void updateDirectory() throws Exception{
        UpdateKbDirectoryRequest request = new UpdateKbDirectoryRequest();

        request.setId(2901);
        request.setKbId(875);
        request.setName("冬至目录1");
        request.setOwner("3954");
        request.setEnterpriseId("8000559");

        KbDirectoryResponse responseModel = smartLinkClient.getResponseModel(request);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));
    }

    @Test
    public void testEnterprise() throws Exception {
        EmotibotEnterpriseRequest request = new EmotibotEnterpriseRequest();
        request.setEnterpriseId("80005590");

        EmotibotEnterpriseResponse responseModel = smartLinkClient.getResponseModel(request);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));
    }

    @Test
    public void deleteDirectory() throws Exception{
        DeleteKbDirectoryRequest request = new DeleteKbDirectoryRequest();

        request.setId(2904);
        request.setEnterpriseId("8000559");

        KbDirectoryResponse responseModel = smartLinkClient.getResponseModel(request);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));
    }

    @Test
    public void listDirectory() throws Exception{
        ListKbDirectoryRequest request = new ListKbDirectoryRequest();

        request.setKbId(875);
        request.setEnterpriseId("8000559");

        ListKbDirectoryResponse responseModel = smartLinkClient.getResponseModel(request);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));
    }


    @Test
    public void deleteArticle() throws Exception{
        DeleteKbArticleRequest request = new DeleteKbArticleRequest();
        request.setEnterpriseId("8000559");
        request.setId(3084);

        ArticleResponse responseModel = smartLinkClient.getResponseModel(request);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));
    }

    @Test
    public void updateArticle() throws Exception{
        UpdateKbArticleRequest request = new UpdateKbArticleRequest();

        request.setId(3085);
        request.setEnterpriseId("8000559");
        request.setKbId(846);
        request.setKbType(0);
        request.setDirectoryId(2262);
        request.setTitle("创建文章接口被更新");
        request.setAgentEnabled(1);
        String[] similars = new String[]{"标题二"};
        request.setSimilars(similars);
        request.setTopStatus(0);
        List<KbArticleResponseModel.Answer> answers = new ArrayList<>();
        KbArticleResponseModel.Answer answer = new KbArticleResponseModel.Answer();
        answer.setAnswer("答案好啊二");
        answers.add(answer);
        request.setAnswers(answers);

        ArticleResponse responseModel = smartLinkClient.getResponseModel(request);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));
    }

    @Test
    public void createArticle() throws Exception{
        CreateKbArticleRequest request = new CreateKbArticleRequest();

        request.setEnterpriseId("8000559");
        request.setKbId(846);
        request.setKbType(0);
        request.setDirectoryId(2262);
        request.setTitle("创建文章接口");
        request.setAgentEnabled(1);
        String[] similars = new String[]{"标题一"};
        request.setSimilars(similars);
        request.setTopStatus(0);
        List<KbArticleResponseModel.Answer> answers = new ArrayList<>();
        KbArticleResponseModel.Answer answer = new KbArticleResponseModel.Answer();
        answer.setAnswer("答案好啊一");
        answers.add(answer);
        request.setAnswers(answers);

        ArticleResponse responseModel = smartLinkClient.getResponseModel(request);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));
    }

    @Test
    public void testFaq() throws Exception {
        IntelligentKnowledgeBaseRequest request = new IntelligentKnowledgeBaseRequest();
        request.setEnterpriseId("8000559");
        request.setQuery("总部");
        // 芒果  198252，全屋全屋WiFi产  竹间  362924，总部
        request.setBotId("362924");
        request.setOffset(0);
        request.setLimit(10);

        KbArticleResponse responseModel = smartLinkClient.getResponseModel(request);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));
    }

    @Test
    public void testAnswerQuery() throws Exception {
        KbAnswerQueryRequest request = new KbAnswerQueryRequest();
        request.setEnterpriseId("8000559");
        request.setQuery("测试");
        request.setKbType(0);

        KbAnswerQueryResponse responseModel = smartLinkClient.getResponseModel(request);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));
    }

    @Test
    public void testInputAssociation() throws Exception {

        InputAssociationRequest request = new InputAssociationRequest();
        request.setBotId("924588");
        request.setText("验证");
        request.setEnterpriseId("8000585");
        request.setTop(5);

        InputAssociationResponse responseModel = smartLinkClient.getResponseModel(request);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));
    }

    // 点赞点踩验证
    @Test
    public void testFeadback() throws Exception {
        ApiMessageFeedbackRequest request = new ApiMessageFeedbackRequest();
        request.setBotId("924588");
        request.setEnterpriseId(8000585);
        request.setResponseId("04b1e46f82864fc9a5efd2bdefc6100c");
        request.setFeedback("helpful");
        request.setCustomFeadback("哈哈");

        ApiMessageFeedbackResponse responseModel = smartLinkClient.getResponseModel(request);

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));
    }

    @Test
    public void testDscArticle () throws Exception{

        KbDescribeArticleRequest request = new KbDescribeArticleRequest();
        request.setId("3020");
        request.setEnterpriseId(8000559);

        KbDescribeArticleResponse responseModel = smartLinkClient.getResponseModel(request);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));
    }

    // 知识库文件内容权限控制
    @Test
    public void testFileAuthContent() throws Exception{
        KbFileRequest fileRequest = new KbFileRequest();

        fileRequest.setEnterpriseId("8000559");
        fileRequest.setRepositoryType(2);
        fileRequest.setLimit(10);
        fileRequest.setOffset(0);
        fileRequest.setChannelType(ChannelEnum.CONTENT);
        fileRequest.setOrder(OrderRuleEnum.NONE);
        fileRequest.setKeyword("价格多少");
        List<String> qnos = new ArrayList<>();
        qnos.add("0001");
        fileRequest.setQnos(qnos);

        KbFileResponse fileResponse = smartLinkClient.getResponseModel(fileRequest);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(fileResponse));
    }

    // 知识库文章内容权限控制
    @Test
    public void testArticleAuthContent() throws Exception{
        KbArticleRequest articleRequest = new KbArticleRequest();
        articleRequest.setEnterpriseId(String.valueOf(8000559));
        // articleRequest.setKbId(782);
        // articleRequest.setKeyword("人工");
        //articleRequest.setOrder(OrderRuleEnum.NONE);
        articleRequest.setRepositoryType(0);
        //articleRequest.setKbId(771);
        //articleRequest.setDirectoryId(589);
        articleRequest.setKeyword("价格多少");
        //articleRequest.setKbId(424);
        articleRequest.setOffset(0);
        articleRequest.setLimit(40);
        articleRequest.setOrder(OrderRuleEnum.NONE);
        articleRequest.setChannelType(ChannelEnum.CONTENT);
        List<String> qnos = new ArrayList<>();
        qnos.add("9999");
        articleRequest.setQnos(qnos);
//        articleRequest.setCno("123123");
//        articleRequest.setChannelType(ChannelEnum.CONTENT);

        KbArticleResponse articleResponse = smartLinkClient.getResponseModel(articleRequest);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(articleResponse));
    }

    // 座席知识库权限
    @Test
    public void testAuth() throws Exception{
        KbDirectoryRequest kbDirectoryRequest = new KbDirectoryRequest();
        kbDirectoryRequest.setEnterpriseId("8000585");
        kbDirectoryRequest.setQnos(null);
        kbDirectoryRequest.setRepositoryType(0);

        KbDirectoriesResponse responseModel = smartLinkClient.getResponseModel(kbDirectoryRequest);
        System.out.println(responseModel.toString());
        System.out.println(responseModel.getDirectories());
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
    public void testTibot() throws Exception {
        TibotRequest request = new TibotRequest();
        request.setUserId(String.valueOf(8000001));
        request.setBotType(2);
        request.setProvider("tibot");
        TibotResponse response = smartLinkClient.getResponseModel(request);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(response));

    }
    @Test
    public void testImageUrl() throws ServerException, ClientException {
        KbArticleImageUrlRequest request = new KbArticleImageUrlRequest();
        request.setFilePath("article/images/1569224913886.png");

        KbArticleImageUrlResponse response = smartLinkClient.getResponseModel(request);
        System.out.println(response.getRequestId());

    }

    @Test
    public void testAvatar() throws Exception {
        BotAvatarUrlRequest request = new BotAvatarUrlRequest();
        request.setBotId(800000148556712L);
        request.setEnterpriseId("8000001");
        request.setProvider("tibot");

        BotAvatarUrlResponse response = smartLinkClient.getResponseModel(request);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(response));

    }


    @Test
    public void testBot() throws Exception {
        BotRequest request = new BotRequest();
        request.setBotId("800000148556712");
        request.setEnterpriseId("8000001");
        request.setProvider("tibot");

        BotResponse responseModel = smartLinkClient.getResponseModel(request);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));

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
    public void testCallScriptRecommendation() throws Exception {
        CallScriptRecommendationRequest request = new CallScriptRecommendationRequest();
        request.setBotId("924588");
        request.setQuery("九月二号");
        request.setTop(5);
        CallScriptRecommendationResponse responseModel = smartLinkClient.getResponseModel(request);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(responseModel));
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
        /*intelligentAssociationRequest.setEnterpriseId("8000071");
        intelligentAssociationRequest.setBotId("798000");
        intelligentAssociationRequest.setText("jira");*/

        // 竹间
        intelligentAssociationRequest.setEnterpriseId("8000585");
        intelligentAssociationRequest.setBotId("924588");
        intelligentAssociationRequest.setText("测试");
        //intelligentAssociationRequest.setTop(5);

        // 芒果
        /*intelligentAssociationRequest.setEnterpriseId("8000559");
        intelligentAssociationRequest.setBotId("791319");
        intelligentAssociationRequest.setText("真实性");*/
        // intelligentAssociationRequest.setTop(5);

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
