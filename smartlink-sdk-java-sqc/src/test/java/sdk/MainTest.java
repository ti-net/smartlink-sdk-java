package sdk;

import com.tinet.smartlink.sdk.core.SmartlinkClient;
import com.tinet.smartlink.sdk.core.SmartlinkClientConfiguration;
import com.tinet.smartlink.sdk.core.exceptions.ClientException;
import com.tinet.smartlink.sdk.core.exceptions.ServerException;
import com.tinet.sqc.sdk.request.ListCdrsByConditionsRequest;
import com.tinet.sqc.sdk.response.ListCdrsByConditionsResponse;
import org.apache.http.HttpHost;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        configuration.setAccessKeyId("397548UC977E9KMP33D7");
        configuration.setAccessKeySecret("w5j99jfyqm5e2x8p786ra48qu839j3zj");
        configuration.setHost(new HttpHost("smartlink-sqc-openapi-test.tinetcloud.com"));
//    configuration.setHost(new HttpHost("{smartlink-sqc-openapi-test.tinetcloud.com}"));


        // configuration.set...  设置其他参数(超时时间....)

        String endtime = "2020-04-30 23:59:59";
        String starttime = "2020-04-23 00:00:00";
        List<String> uniqueIdList = new ArrayList<>();
        SmartlinkClient smartlinkClient = new SmartlinkClient(configuration);
        ListCdrsByConditionsRequest listCdrsRequest = new ListCdrsByConditionsRequest();
        listCdrsRequest.setUniqueIdList(uniqueIdList);
        listCdrsRequest.setStartChannelTime(starttime);
        listCdrsRequest.setEndChannelTime(endtime);
        ListCdrsByConditionsResponse responseModel = smartlinkClient.getResponseModel(listCdrsRequest);
        System.out.println(responseModel);
    }
}
