package sdk;

import com.tinet.smartlink.sdk.core.SmartlinkClient;
import com.tinet.smartlink.sdk.core.SmartlinkClientConfiguration;
import com.tinet.smartlink.sdk.core.exceptions.ClientException;
import com.tinet.smartlink.sdk.core.exceptions.ServerException;
import com.tinet.sqc.sdk.request.PushEnterpriseSettingRequest;
import com.tinet.sqc.sdk.response.PushEnterpriseSettingResponse;
import org.apache.http.HttpHost;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 侯法超
 * @date 2021/2/2
 */
public class PushEnterpriseSettingRequestTest {

    private SmartlinkClient client;

    @Before
    public void init() {
        SmartlinkClientConfiguration configuration = new SmartlinkClientConfiguration();

        configuration.setAccessKeyId("59F6WZYJ6PT4G879D318");
        configuration.setAccessKeySecret("u610p9q44llvd1c0qluj06yq3d1946kz");
        //HttpHost host = new HttpHost("smartlink-sqc-openapi.tinetcloud.com");
        HttpHost host = new HttpHost("smartlink-openapi.chinayzyx.com", 443, "https");
        configuration.setHost(host);
        configuration.setConnectionRequestTimeout(100000);
        configuration.setConnectTimeout(100000);
        configuration.setSocketTimeout(100000);
        client = new SmartlinkClient(configuration);
    }

    @Test
    public void requestTest() throws ServerException, ClientException {
        PushEnterpriseSettingRequest request = new PushEnterpriseSettingRequest();
        request.setAccountLoginName("sad");
        request.setEnterpriseName("def");
        request.setEnterpriseId(String.valueOf(7000));
        request.setHiddenType(0);
        request.setStatus(new String[]{"sqc"});
        request.setActive(1);
        request.setToken("dcsgfdbgfb");
        request.setRecordUrl("http://");
        request.setPlatform("cticloud");



        PushEnterpriseSettingResponse response = client.getResponseModel(request);
        System.out.println(response);
    }
}
