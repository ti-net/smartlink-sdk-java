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
        HttpHost host = new HttpHost("smartlink-sqc-openapi.tinetcloud.com");
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
        PushEnterpriseSettingResponse response = client.getResponseModel(request);
        System.out.println(response);
    }
}
