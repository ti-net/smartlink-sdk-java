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

        String endTime = "2020-04-30 23:59:59";
        String startTime = "2020-04-23 00:00:00";
        List<String> uniqueIdList = new ArrayList<>();
//        configuration.setProxy(new HttpHost(""));
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
}
