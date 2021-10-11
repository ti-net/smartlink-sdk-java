package sdk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tinet.smartlink.sdk.core.SmartlinkClient;
import com.tinet.smartlink.sdk.core.SmartlinkClientConfiguration;
import com.tinet.smartlink.sdk.core.exceptions.ClientException;
import com.tinet.smartlink.sdk.core.exceptions.ServerException;
import com.tinet.sqc.sdk.model.PlatformEnum;
import com.tinet.sqc.sdk.model.ProductEnum;
import com.tinet.sqc.sdk.model.Record;
import com.tinet.sqc.sdk.request.CdrSqcDetailsRequest;
import com.tinet.sqc.sdk.request.EnableBiFunctionRequest;
import com.tinet.sqc.sdk.request.JumpUserCheckRequest;
import com.tinet.sqc.sdk.request.PermissionRequest;
import com.tinet.sqc.sdk.request.PushCdrRequest;
import com.tinet.sqc.sdk.request.UpdateCdrRequest;
import com.tinet.sqc.sdk.response.CdrSqcDetailsResponse;
import com.tinet.sqc.sdk.response.EnableBiFunctionResponse;
import com.tinet.sqc.sdk.response.JumpUserCheckResponse;
import com.tinet.sqc.sdk.response.PermissionResponse;
import com.tinet.sqc.sdk.response.PushCdrResponse;
import com.tinet.sqc.sdk.response.UpdateCdrResponse;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.apache.http.HttpHost;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 测试客户端
 *
 * @author huwk
 * @date 2019/9/19
 **/
@Ignore
public class TestClient {
    SmartlinkClient authClient;

    @Before
    public void init() {
        SmartlinkClientConfiguration configuration = new SmartlinkClientConfiguration();
//        configuration.setAccessKeyId("DA5D86BM41F6LH31FN4L");
//        configuration.setAccessKeySecret("60prd9176j956iv680113az66243mk61");
//        configuration.setHost("smartlink-sqc-openapi.tinetcloud.com");
//        configuration.setHost("localhost",8083);

//        configuration.setAccessKeyId("59F6WZYJ6PT4G879D318");
//        configuration.setAccessKeySecret("u610p9q44llvd1c0qluj06yq3d1946kz");
//        configuration.setHost("smartlink-sqc-openapi-test2.tinetcloud.com");

        configuration.setAccessKeyId("U550M65OOC1Y7842Y985");
        configuration.setAccessKeySecret("58w82m7j0bop2g4g5ghaprh43076p951");
//        configuration.setAccessKeyId("59F6WZYJ6PT4G879D318");
//        configuration.setAccessKeySecret("u610p9q44llvd1c0qluj06yq3d1946kz");
//        //configuration.setHost("localhost", 8083);
//        configuration.setHost("smartlink-sqc-openapi-test.tinetcloud.com");
        configuration.setHost("smartlink-sqc-openapi-test2.tinetcloud.com");
//        configuration.setHost("smartlink-openapi.clink.cn");
//        //configuration.setHost(new HttpHost("smartlink-openapi.clink.cn",443,"https"));


        configuration.setConnectionRequestTimeout(100000);
        configuration.setConnectTimeout(100000);
        configuration.setSocketTimeout(100000);
        authClient = new SmartlinkClient(configuration);
    }




    @Test
    public void getDetail() throws ServerException, ClientException {
        CdrSqcDetailsRequest request=new CdrSqcDetailsRequest();
        request.setUniqueId("medias_1-1632464196.22");
        request.setUserId("8000559");

        CdrSqcDetailsResponse responseModel = authClient.getResponseModel(request);
        System.out.println(responseModel.toString());
    }



    @Test
    public void pushCdr1() throws ServerException, ClientException, JsonProcessingException {
        PushCdrRequest pushCdrRequest = new PushCdrRequest();
        pushCdrRequest.setUserId("8000559");
        String uniqueid = "medias_1-1633932042.22";
        pushCdrRequest.setUniqueId(uniqueid);
        pushCdrRequest.setMainUniqueId(uniqueid);
        pushCdrRequest.setCdrType("cdr_ib");
        pushCdrRequest.setCallType(1);
        pushCdrRequest.setStartTime(1632464196L);
        pushCdrRequest.setAnswerTime(1632464198L);
        pushCdrRequest.setEndTime(1632464232L);
        pushCdrRequest.setBridgeTime(1632464209L);
        pushCdrRequest.setBridgeDuration(23);
        pushCdrRequest.setTotalDuration(26);
        pushCdrRequest.setStatus(1);
        pushCdrRequest.setEndReason(1);
        pushCdrRequest.setCno("2021");
        pushCdrRequest.setAgentName("yinzk");
        pushCdrRequest.setCustomerNumber("18832015829");
        pushCdrRequest.setCustomerNumberType("2");
        pushCdrRequest.setCustomerAreaCode("0310");
        pushCdrRequest.setCustomerProvince("河北");
        pushCdrRequest.setCustomerCity("邯郸");
        pushCdrRequest.setJoinQueueTime(1632464198L);
        pushCdrRequest.setRecordFile("8000559-20210924141636-01012345678-221221--record-medias_1-1632464196.13");
        pushCdrRequest.setNumberTrunk("02759566331");
        pushCdrRequest.setHotline("02759566331");
//        pushCdrRequest.setCallbackUrl("http://api-bj-test5.clink.cn/internal/sqc/asr?platform=SMARTLINK&Timestamp=1632464243&AccessKeyId=b22f93a2d70b6c8125c94c20eb488027");
        pushCdrRequest.setQno("1211");
        pushCdrRequest.setQname("yinzk-test");
        pushCdrRequest.setBusinessPriority("2");
        pushCdrRequest.setFileAuthFlag(true);

//
//        pushCdrRequest.setBusinessPriority("1");
        Record recordAgent = new Record();
//        String fileUrlAgent = "https://yin-file.oss-cn-beijing.aliyuncs.com/smartlink-demo/20200820194226-1890212-1885214-1597923745.146874-in.wav?Expires=1599226249&OSSAccessKeyId=TMP.3Kj7jy8W64BU9ZAhVBma1RRcBHLqkXdmqsYc4YtyGCmDuiPEz8oVm3jZPC1LYzNKZrE8qvu3i7tJCg8ZRxFMFpXFsNXVh2&Signature=L7IUPjkfRCOQg1X%2BRm4o5lPDCeo%3D";
//        String fileUrlClient = "https://yin-file.oss-cn-beijing.aliyuncs.com/smartlink-demo/20200820194226-1890212-1885214-1597923745.146874-out.wav?Expires=1599226273&OSSAccessKeyId=TMP.3Kj7jy8W64BU9ZAhVBma1RRcBHLqkXdmqsYc4YtyGCmDuiPEz8oVm3jZPC1LYzNKZrE8qvu3i7tJCg8ZRxFMFpXFsNXVh2&Signature=IzLCVzpuU5h4Ev7EPZ1hlCwrGcc%3D";
        recordAgent.setFileId("path.amVGaWxlU3lzdGVtL00wMC8wRS8xMi93S2dBMUdGZ0Z5MkFGZ0wxQUFCLUFEbUluTTQ3NjMubXAz");
//        recordAgent.setRecordSide("agent");
//        Record recordClient = new Record();
//        recordClient.setFileUrl(fileUrlClient);
//        recordClient.setRecordSide("client");
        List<Record> list = new ArrayList<>();
        list.add(recordAgent);
//        list.add(recordClient);
        pushCdrRequest.setRecords(list);
        //继续添加等话单信息
        PushCdrResponse responseModel = authClient.getResponseModel(pushCdrRequest);
        System.out.println(responseModel.toString());
    }


    @Test
    public void pushCdr() throws ServerException, ClientException, JsonProcessingException {
        PushCdrRequest pushCdrRequest = new PushCdrRequest();
        pushCdrRequest.setUserId("1100036");
        String uniqueid = "8001967-1599198125.1";
        pushCdrRequest.setUniqueId(uniqueid);
        pushCdrRequest.setMainUniqueId(uniqueid);
        pushCdrRequest.setAgentName("测试");
        pushCdrRequest.setAgentNumber("13804881234");
        pushCdrRequest.setAsrProvider("Tinet");
        pushCdrRequest.setBridgeDuration(23);
        pushCdrRequest.setCallType(1);
        pushCdrRequest.setCdrType("cdr_ib");
        pushCdrRequest.setRecordFile("20200820194226-1890212-1885214-1597923745.146874.mp3");
        pushCdrRequest.setAnswerTime(1599198778L);
        pushCdrRequest.setBridgeTime(1599198778L);
        pushCdrRequest.setCno("2021");
        pushCdrRequest.setEndReason(1);
        pushCdrRequest.setEndTime(1599199778L);
        pushCdrRequest.setStartTime(1599198778L);
        pushCdrRequest.setStatus(1);
        pushCdrRequest.setTotalDuration(36);
        pushCdrRequest.setBusinessPriority("1");
        Record recordAgent = new Record();
        String fileUrlAgent = "https://yin-file.oss-cn-beijing.aliyuncs.com/smartlink-demo/20200820194226-1890212-1885214-1597923745.146874-in.wav?Expires=1599226249&OSSAccessKeyId=TMP.3Kj7jy8W64BU9ZAhVBma1RRcBHLqkXdmqsYc4YtyGCmDuiPEz8oVm3jZPC1LYzNKZrE8qvu3i7tJCg8ZRxFMFpXFsNXVh2&Signature=L7IUPjkfRCOQg1X%2BRm4o5lPDCeo%3D";
        String fileUrlClient = "https://yin-file.oss-cn-beijing.aliyuncs.com/smartlink-demo/20200820194226-1890212-1885214-1597923745.146874-out.wav?Expires=1599226273&OSSAccessKeyId=TMP.3Kj7jy8W64BU9ZAhVBma1RRcBHLqkXdmqsYc4YtyGCmDuiPEz8oVm3jZPC1LYzNKZrE8qvu3i7tJCg8ZRxFMFpXFsNXVh2&Signature=IzLCVzpuU5h4Ev7EPZ1hlCwrGcc%3D";
        recordAgent.setFileUrl(fileUrlAgent);
        recordAgent.setRecordSide("agent");
        Record recordClient = new Record();
        recordClient.setFileUrl(fileUrlClient);
        recordClient.setRecordSide("client");
        List<Record> list = new ArrayList<>();
        list.add(recordAgent);
        list.add(recordClient);
        pushCdrRequest.setRecords(list);
        //继续添加等话单信息
        PushCdrResponse responseModel = authClient.getResponseModel(pushCdrRequest);
        System.out.println(responseModel.toString());
    }

    @Test
    public void updateCdr() throws ServerException, ClientException {
        UpdateCdrRequest updateCdrRequest = new UpdateCdrRequest();
        String uniqueid = "8001967-1599198778.11234";
        updateCdrRequest.setUniqueId(uniqueid);
        updateCdrRequest.setBusinessPriority("1");
        updateCdrRequest.setUserId("1100036");
        //修改话单信息的业务优先级
        UpdateCdrResponse updateCdrResponse = authClient.getResponseModel(updateCdrRequest);
        System.out.println(updateCdrResponse.toString());
    }


    @Test
    public void bi() throws ServerException, ClientException, JsonProcessingException {
        EnableBiFunctionRequest request = new EnableBiFunctionRequest();
        request.setEnterpriseId("7600114");
        request.setStatus(1);
        //EnableBiFunctionResponse responseModel = authClient.getResponseModel(request);
        //System.out.println(responseModel.toString());
    }

    @Test
    public void testper() throws ServerException, ClientException, JsonProcessingException {
        PermissionRequest permissionRequest = new PermissionRequest();
        permissionRequest.setProduct(ProductEnum.SQC);
        PermissionResponse responseModel = authClient.getResponseModel(permissionRequest);
        System.out.println(responseModel.toString());
    }
    @Test
    public void testcehck() throws ServerException, ClientException, JsonProcessingException {
        PermissionRequest permissionRequest = new PermissionRequest();
        permissionRequest.setProduct(ProductEnum.SQC);
        PermissionResponse permission = authClient.getResponseModel(permissionRequest);
        JumpUserCheckRequest jumpUserCheckRequest = new JumpUserCheckRequest();
        jumpUserCheckRequest.setPermissionList(permission.getPermissionList());
        jumpUserCheckRequest.setEnterpriseId("1100049");
        List<String> list = new ArrayList<>();
        list.add("1110011");
        list.add("1100049");
        jumpUserCheckRequest.setEnterpriseIdList(list);
        jumpUserCheckRequest.setUsername("大宝测试");
        List<String> conlist = new ArrayList<>();
        conlist.add("1110011");
        conlist.add("1100049");
        jumpUserCheckRequest.setConList(conlist);
        jumpUserCheckRequest.setRole("测试用户");
        jumpUserCheckRequest.setPlatform(PlatformEnum.CLINK2);
        jumpUserCheckRequest.setProduct(ProductEnum.SQC);
        JumpUserCheckResponse responseModel = authClient.getResponseModel(jumpUserCheckRequest);
        System.out.println(responseModel.toString());
    }

}
