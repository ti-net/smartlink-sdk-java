package sdk;

import com.alibaba.fastjson.JSONObject;
import com.tinet.smartlink.sdk.core.SmartlinkClient;
import com.tinet.smartlink.sdk.core.SmartlinkClientConfiguration;
import com.tinet.smartlink.sdk.core.exceptions.ClientException;
import com.tinet.smartlink.sdk.core.exceptions.ServerException;
import com.tinet.sqc.sdk.request.PushCdrRequest;
import com.tinet.sqc.sdk.request.PushEnterpriseSettingRequest;
import com.tinet.sqc.sdk.response.PushCdrResponse;
import com.tinet.sqc.sdk.response.PushEnterpriseSettingResponse;
import org.apache.http.HttpHost;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 侯法超
 * @date 2021/2/2
 */

public class PushEnterpriseSettingRequestTest {

    private SmartlinkClient client;

    @Before
    public void init() {
        /*SmartlinkClientConfiguration configuration = new SmartlinkClientConfiguration();

        configuration.setAccessKeyId("59F6WZYJ6PT4G879D318");
        configuration.setAccessKeySecret("u610p9q44llvd1c0qluj06yq3d1946kz");
        HttpHost host = new HttpHost("smartlink-sqc-openapi.tinetcloud.com");
        //HttpHost host = new HttpHost("smartlink-openapi.chinayzyx.com", 443, "https");
        configuration.setHost(host);
        configuration.setConnectionRequestTimeout(100000);
        configuration.setConnectTimeout(100000);
        configuration.setSocketTimeout(100000);
        client = new SmartlinkClient(configuration);*/
    }

    @Test
    public void requestTest() throws ServerException, ClientException {
        PushEnterpriseSettingRequest request = new PushEnterpriseSettingRequest();
        request.setAccountLoginName("trrt@chenjg");
        request.setEnterpriseName("jg测试");
        request.setEnterpriseId("5000001");
        request.setHiddenType(0);
        request.setStatus(new String[]{"sqc","asr"});
        request.setActive(1);
        request.setToken("dcsgfdbgfb");
        request.setRecordUrl("http://");
        request.setPlatform("cticloud");

        PushEnterpriseSettingRequest request2 = new PushEnterpriseSettingRequest();
        request2.setAccountLoginName("trrt@chenjg");
        request2.setEnterpriseName("jg测试");
        request2.setEnterpriseId("5000002");
        request2.setHiddenType(0);
        request2.setStatus(new String[]{"sqc","asr"});
        request2.setActive(1);
        request2.setToken("dcsgfdbgfb");
        request2.setRecordUrl("http://");
        request2.setPlatform("cticloud");

        PushEnterpriseSettingRequest request3 = new PushEnterpriseSettingRequest();
        request3.setAccountLoginName("trrt@chenjg");
        request3.setEnterpriseName("jg测试");
        request3.setEnterpriseId("5000004");
        request3.setHiddenType(0);
        request3.setStatus(new String[]{"sqc","asr"});
        request3.setActive(1);
        request3.setToken("dcsgfdbgfb");
        request3.setRecordUrl("http://");
        request3.setPlatform("cticloud");


        List<PushEnterpriseSettingRequest> list = new ArrayList<>();

        list.add(request);
        list.add(request2);
        list.add(request3);

        System.out.println(JSONObject.toJSON(request));
        list.forEach(e->testList(e));


    }

    public void testList(PushEnterpriseSettingRequest request){
        SmartlinkClientConfiguration configuration = new SmartlinkClientConfiguration();

        configuration.setAccessKeyId("59F6WZYJ6PT4G879D318");
        configuration.setAccessKeySecret("u610p9q44llvd1c0qluj06yq3d1946kz");
        HttpHost host = new HttpHost("smartlink-sqc-openapi-test.tinetcloud.com");
        //HttpHost host = new HttpHost("smartlink-openapi.chinayzyx.com", 443, "https");
        configuration.setHost(host);
        /*configuration.setConnectionRequestTimeout(100000);
        configuration.setConnectTimeout(100000);
        configuration.setSocketTimeout(100000);*/
        client = new SmartlinkClient(configuration);

        PushEnterpriseSettingResponse response = null;
        try {
            response = client.getResponseModel(request);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        System.out.println(response);
    }
}
