package sdk;

import com.tinet.asr.sdk.request.PostAsrTaskRequest;
import com.tinet.asr.sdk.response.PostAsrTaskResponse;
import com.tinet.smartlink.sdk.core.SmartlinkClient;
import com.tinet.smartlink.sdk.core.SmartlinkClientConfiguration;
import com.tinet.smartlink.sdk.core.exceptions.ClientException;
import com.tinet.smartlink.sdk.core.exceptions.ServerException;
import org.apache.http.HttpHost;
import org.junit.Test;


/**
 * @author 侯法超
 * @date 2021/1/14
 */
public class MainTest {

    @Test
    public void push() {


        /*{"connectTimeout":null,"connectionRequestTimeout":null,"socketTimeout":null,
                "fileUrl":"https://img.gsxservice.com/1118729889_jdv2r1ou.mp3","fileName":"1118729889_jdv2r1ou.mp3",
                "callbackUrl":null,"userId":"8880000","uniqueId":"766ecee5-13de-49cb-84d9-2dca59271036-1616712697.3390",
                "recordSide":null,"asrProvider":"Tinet","enableSqc":true,"cdrSource":3}*/
        SmartlinkClientConfiguration configuration = new SmartlinkClientConfiguration();
        // 这些是必须设置的参数
        configuration.setAccessKeyId("59F6WZYJ6PT4G879D318");
        configuration.setAccessKeySecret("u610p9q44llvd1c0qluj06yq3d1946kz");
        configuration.setHost(new HttpHost("smartlink-asr.clink.cn",80,"https"));

        SmartlinkClient smartlinkClient = new SmartlinkClient(configuration);

        //推送给慧智
        PostAsrTaskRequest postAsrTaskRequest = new PostAsrTaskRequest();
        postAsrTaskRequest.setFileUrl("https://img.gsxservice.com/1118729889_jdv2r1ou.mp3");
        postAsrTaskRequest.setFileName("1118729889_jdv2r1ou.mp3");
        postAsrTaskRequest.setUserId("8880000");
        postAsrTaskRequest.setUniqueId("766ecee5-13de-49cb-84d9-2dca59271036-1616712697.4790");
        postAsrTaskRequest.setEnableSqc(true);
        postAsrTaskRequest.setCdrSource(3);
        postAsrTaskRequest.setAsrProvider("Tinet");

        PostAsrTaskResponse responseModel;
        try {
            responseModel = smartlinkClient.getResponseModel(postAsrTaskRequest);
            System.out.println(responseModel.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }




    }

}
