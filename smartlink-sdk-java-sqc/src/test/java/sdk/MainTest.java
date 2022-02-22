package sdk;

import com.tinet.smartlink.sdk.core.SmartlinkClient;
import com.tinet.smartlink.sdk.core.SmartlinkClientConfiguration;
import com.tinet.smartlink.sdk.core.exceptions.ClientException;
import com.tinet.smartlink.sdk.core.exceptions.ServerException;
import com.tinet.sqc.sdk.model.Record;
import com.tinet.sqc.sdk.request.*;
import com.tinet.sqc.sdk.response.*;
import org.apache.http.HttpHost;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @author 侯法超
 * @date 2021/1/14
 */
public class MainTest {
    @Test
    public void test() throws ServerException, ClientException {
//        System.setProperty("proxyHost", "10.1.27.102");
//        System.setProperty("proxyPort", "8080");
//        System.setProperty("proxySet", "true");
        SmartlinkClientConfiguration configuration = new SmartlinkClientConfiguration();
        // 这些是必须设置的参数，慧智提供
//    configuration.setAccessKeyId(StringConstant.ACCESSKEY_ID);
//    configuration.setAccessKeySecret(StringConstant.ACCESSKEY_SECRET);
//    configuration.setHost(new HttpHost(StringConstant.HOST));
        configuration.setAccessKeyId("59F6WZYJ6PT4G879D318");
        configuration.setAccessKeySecret("u610p9q44llvd1c0qluj06yq3d1946kz");
        configuration.setHost(new HttpHost("smartlink-openapi.clink.cn",443));
//    configuration.setHost(new HttpHost("{smartlink-sqc-openapi-test.tinetcloud.com}"));


        // configuration.set...  设置其他参数(超时时间....)

        String endTime = "2020-04-30 23:59:59";
        String startTime = "2020-04-23 00:00:00";
        List<String> uniqueIdList = new ArrayList<>();
        configuration.setProxy(new HttpHost(""));
        SmartlinkClient smartlinkClient = new SmartlinkClient(configuration);
        ListCdrsByConditionsRequest listCdrsRequest = new ListCdrsByConditionsRequest();
        listCdrsRequest.setUniqueIdList(uniqueIdList);
        listCdrsRequest.setStartChannelTime(startTime);
        listCdrsRequest.setEndChannelTime(endTime);
        ListCdrsByConditionsResponse responseModel = smartlinkClient.getResponseModel(listCdrsRequest);
        System.out.println(responseModel);
    }

    @Test
    public void cdrsList () {
//        System.setProperty("proxyHost", "10.1.27.102");
//        System.setProperty("proxyPort", "8080");
//        System.setProperty("proxySet", "true");
        List<String> uniqueIdList = new ArrayList<>();
        //uniqueIdList.add("2c3de133d6214d049d3239e6d46bf507-1576739000.7035");
        uniqueIdList.add("110YY-1587873248.1");
//        uniqueIdList.add("aknabab-131.24");

        SmartlinkClientConfiguration configuration = new SmartlinkClientConfiguration();
        // 这些是必须设置的参数，慧智提供
        configuration.setAccessKeyId("397548UC977E9KMP33D7");
        configuration.setAccessKeySecret("w5j99jfyqm5e2x8p786ra48qu839j3zj");
        configuration.setHost(new HttpHost("smartlink-sqc-openapi-test.tinetcloud.com"));
        // configuration.set...  设置其他参数(超时时间....)
        //configuration.setProxy(new HttpHost("10.1.27.102", 8080));

        SmartlinkClient smartlinkClient = new SmartlinkClient(configuration);

        ListCdrsByConditionsRequest listCdrsRequest = new ListCdrsByConditionsRequest();
        listCdrsRequest.setUniqueIdList(uniqueIdList);
        listCdrsRequest.setStartChannelTime("2020-04-23 00:00:00");
        listCdrsRequest.setEndChannelTime("2020-04-30 23:59:59");

        ListCdrsByConditionsResponse responseModel = null;
        try {
            responseModel =smartlinkClient.getResponseModel(listCdrsRequest);
            System.out.println(responseModel.toString());
        } catch (ServerException e) {
            // 服务器错误
            e.printStackTrace();
        } catch (ClientException e) {
            // 客户端错误
            e.printStackTrace();
            e.getMessage();
        }
    }


    @Test
    public  void main1() {
        SmartlinkClientConfiguration configuration = new SmartlinkClientConfiguration();
        // 这些是必须设置的参数
        configuration.setAccessKeyId("I6C9N2U49N767QZ4Y433");
        configuration.setAccessKeySecret("qe30w30gl795uv5gnno595d1ew4ww33l");
        configuration.setHost(new HttpHost("smartlink-sqc-openapi-test.tinetcloud.com"));

        SmartlinkClient smartlinkClient = new SmartlinkClient(configuration);

        PushCdrRequest pushCdrRequest = new PushCdrRequest();
        pushCdrRequest.setUserId("8005354");
        pushCdrRequest.setAgentName("工号1002");
        pushCdrRequest.setAgentNumber("cno002");
        pushCdrRequest.setAsrProvider("Tinet");
        pushCdrRequest.setBridgeDuration(54);
        pushCdrRequest.setCallType(3);
        pushCdrRequest.setCdrType("cdr_ob_customer");
        pushCdrRequest.setCdrSource(3);
        pushCdrRequest.setAnswerTime(1645499493L);
        pushCdrRequest.setBridgeTime(1645499493L);
        pushCdrRequest.setCno("cno002");
        pushCdrRequest.setQno("qno002");
        pushCdrRequest.setCustomerNumber("13912345678");
        pushCdrRequest.setQname("队列1002");
        pushCdrRequest.setEndReason(1);
        pushCdrRequest.setEndTime(1645499519L);
        pushCdrRequest.setStartTime(1645499493L);
        pushCdrRequest.setStatus(22);
        pushCdrRequest.setTotalDuration(54);
        // 文件名
        pushCdrRequest.setRecordFile("test01.wav");
        Record recordAgent = new Record();
        String fileUrlAgent = "https://rms-asr-test.oss-cn-beijing.aliyuncs.com/smartlink/8005354/Tue%20Jan%2025%2000%3A00%3A00%20CST%202022/17394413884%E5%8F%B2%E7%8E%89%E9%BE%99_2022-01-19%2018_48_09.wav?Expires=1645523788&OSSAccessKeyId=TMP.3KjvnigMV6ss67N1NBT5bbrFwT56xxyfd5ES7kDJFwELD46NbX2Nw9at2ew7FkVbsCZ3krvN3Fadn52J2WdcX6gv3dc4AK&Signature=ZV861y5A5cFVvW5B9f%2FAWtlJDZc%3D";
        recordAgent.setFileUrl(fileUrlAgent);
        //recordAgent.setRecordSide("all");
        // 录音是否长期有效
        recordAgent.setErpetualUrl(true);
        List<Record> list = new ArrayList<>();
        list.add(recordAgent);
        pushCdrRequest.setRecords(list);
        // 声道话者标识
        //pushCdrRequest.setChannelSpeaker(new String[]{"client","agent"});
        //pushCdrRequest.setChannelSpeaker(new String[]{"agent","client"});

        Random random = new Random();
        String uniqueid = UUID.randomUUID().toString().replace("-", "") + "-" + pushCdrRequest.getStartTime() + "." + random.nextInt(1000);
        pushCdrRequest.setUniqueId(uniqueid);
        pushCdrRequest.setMainUniqueId(uniqueid);
        System.out.println("uniqueId:" + uniqueid);

        PushCdrResponse responseModel = null;
        try {
            responseModel = smartlinkClient.getResponseModel(pushCdrRequest);
        } catch (ServerException e) {
            // 服务器错误,大概率是出 bug 了
            e.printStackTrace();
        } catch (ClientException e) {
            // 客户端错误,参数校验没通过？做了不该做的事？反正是你的事,再看看你写的代码
            e.printStackTrace();
        }
        System.out.println(responseModel);
    }


    @Test
    public  void getDetail() {
        SmartlinkClientConfiguration configuration = new SmartlinkClientConfiguration();
        // 这些是必须设置的参数
        /*configuration.setAccessKeyId("6Z45P02IB48X3TAE585U");
        configuration.setAccessKeySecret("9q30r5d2675qe1ws6d7sw32v0pl1s0w1");*/
        /*configuration.setAccessKeyId("I6C9N2U49N767QZ4Y433");
        configuration.setAccessKeySecret("qe30w30gl795uv5gnno595d1ew4ww33l");*/
        configuration.setAccessKeyId("E5GJ9M1MUDQ2YY995E7F");
        configuration.setAccessKeySecret("y0622a727gwq2s56q7l57ewqmig015k7");
        //configuration.setHost(new HttpHost("smartlink-sqc-openapi-test.tinetcloud.com"));
        configuration.setHost(new HttpHost("smartlink-sqc-openapi.tinetcloud.com"));
        //configuration.setHost(new HttpHost("smartlink-openapi.clink.cn",443));

        SmartlinkClient smartlinkClient = new SmartlinkClient(configuration);

        CdrSqcDetailsRequest request = new CdrSqcDetailsRequest();
        //request.setUniqueId("medias_1-1643102980.17");
        request.setUniqueId("951a7763ce3d4c6bbc0a6b4fcb260881-1643130000.802");
        request.setUserId("8001925");

        CdrSqcDetailsResponse responseModel = null;
        try {
            responseModel = smartlinkClient.getResponseModel(request);
        } catch (ServerException e) {
            // 服务器错误,大概率是出 bug 了
            e.printStackTrace();
        } catch (ClientException e) {
            // 客户端错误,参数校验没通过？做了不该做的事？反正是你的事,再看看你写的代码
            e.printStackTrace();
        }
        System.out.println(responseModel);
    }

    @Test
    public  void getListDetail() {
        SmartlinkClientConfiguration configuration = new SmartlinkClientConfiguration();
        // 这些是必须设置的参数
        configuration.setAccessKeyId("I6C9N2U49N767QZ4Y433");
        configuration.setAccessKeySecret("qe30w30gl795uv5gnno595d1ew4ww33l");
        configuration.setHost(new HttpHost("smartlink-sqc-openapi.tinetcloud.com"));
        //configuration.setHost(new HttpHost("smartlink-openapi.clink.cn",443));

        SmartlinkClient smartlinkClient = new SmartlinkClient(configuration);

        ListCdrSqcDetailsRequest request = new ListCdrSqcDetailsRequest();
        request.setChannelTime("2022-02-08");
        request.setUserId("8005354");

        ListCdrSqcDetailsResponse responseModel = null;
        try {
            responseModel = smartlinkClient.getResponseModel(request);
        } catch (ServerException e) {
            // 服务器错误,大概率是出 bug 了
            e.printStackTrace();
        } catch (ClientException e) {
            // 客户端错误,参数校验没通过？做了不该做的事？反正是你的事,再看看你写的代码
            e.printStackTrace();
        }
        System.out.println(responseModel);
    }

    @Test
    public  void getListDetailByUniqueId() {
        SmartlinkClientConfiguration configuration = new SmartlinkClientConfiguration();
        // 这些是必须设置的参数
        /*configuration.setAccessKeyId("6Z45P02IB48X3TAE585U");
        configuration.setAccessKeySecret("9q30r5d2675qe1ws6d7sw32v0pl1s0w1");
        configuration.setHost(new HttpHost("smartlink-sqc-openapi-test.tinetcloud.com"));*/
        //configuration.setHost(new HttpHost("smartlink-openapi.clink.cn",443));

        configuration.setAccessKeyId("E5GJ9M1MUDQ2YY995E7F");
        configuration.setAccessKeySecret("y0622a727gwq2s56q7l57ewqmig015k7");
        configuration.setHost(new HttpHost("smartlink-sqc-openapi.tinetcloud.com"));

        SmartlinkClient smartlinkClient = new SmartlinkClient(configuration);

        ListCdrDetailsByUniqueIdListRequest request = new ListCdrDetailsByUniqueIdListRequest();
        List<String> uniqueIdList = new ArrayList<>();
        uniqueIdList.add("951a7763ce3d4c6bbc0a6b4fcb260881-1643130000.802");
        //uniqueIdList.add("1fc57eff17304583b3a56a7cc218b7ea-1644548861.1917");
        request.setUniqueIdList(uniqueIdList);
        request.setUserId("8001925");

        ListCdrDetailsByUniqueIdListResponse responseModel = null;
        try {
            responseModel = smartlinkClient.getResponseModel(request);
        } catch (ServerException e) {
            // 服务器错误,大概率是出 bug 了
            e.printStackTrace();
        } catch (ClientException e) {
            // 客户端错误,参数校验没通过？做了不该做的事？反正是你的事,再看看你写的代码
            e.printStackTrace();
        }
        System.out.println(responseModel);
    }
}
