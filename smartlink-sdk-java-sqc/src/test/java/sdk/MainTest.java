package sdk;

import com.tinet.smartlink.sdk.core.SmartlinkClient;
import com.tinet.smartlink.sdk.core.SmartlinkClientConfiguration;
import com.tinet.smartlink.sdk.core.exceptions.ClientException;
import com.tinet.smartlink.sdk.core.exceptions.ServerException;
import com.tinet.sqc.sdk.model.Record;
import com.tinet.sqc.sdk.request.ListCdrsByConditionsRequest;
import com.tinet.sqc.sdk.request.PushCdrRequest;
import com.tinet.sqc.sdk.response.ListCdrsByConditionsResponse;
import com.tinet.sqc.sdk.response.PushCdrResponse;
import org.apache.http.HttpHost;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
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
        configuration.setAccessKeyId("59F6WZYJ6PT4G879D318");
        configuration.setAccessKeySecret("u610p9q44llvd1c0qluj06yq3d1946kz");
        configuration.setHost(new HttpHost("smartlink-openapi.clink.cn"));

        SmartlinkClient smartlinkClient = new SmartlinkClient(configuration);

        PushCdrRequest pushCdrRequest = new PushCdrRequest();

        String uid = UUID.randomUUID().toString() + "-1616712697.5790";
        System.out.println(uid);
        pushCdrRequest.setUniqueId(uid);
        pushCdrRequest.setUserId("8880000");
        pushCdrRequest.setCdrType("cdr_ib");
        pushCdrRequest.setCallType(1);
        pushCdrRequest.setCdrSource(3);
        pushCdrRequest.setStartTime(1616712697L);
        pushCdrRequest.setAnswerTime(1616712697L);
        pushCdrRequest.setEndTime(1616712697L);
        pushCdrRequest.setBridgeTime(1616712697L);
        pushCdrRequest.setBridgeDuration(184);
        pushCdrRequest.setTotalDuration(184);
        pushCdrRequest.setStatus(50);
        pushCdrRequest.setEndReason(1);

        Record record = new Record();
        record.setStorageRecord(true);
        record.setFileUrl("https://img.gsxservice.com/1118729889_jdv2r1ou.mp3");
        List<Record> recordList = new ArrayList<>();
        recordList.add(record);
        pushCdrRequest.setRecords(recordList);

        pushCdrRequest.setRecordFile("1118729889_jdv2r1ou.mp3");

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

}
