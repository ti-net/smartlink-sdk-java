package sdk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tinet.smartlink.sdk.core.SmartlinkClient;
import com.tinet.smartlink.sdk.core.SmartlinkClientConfiguration;
import com.tinet.smartlink.sdk.core.exceptions.ClientException;
import com.tinet.smartlink.sdk.core.exceptions.ServerException;
import com.tinet.sqc.sdk.model.PlatformEnum;
import com.tinet.sqc.sdk.model.ProductEnum;
import com.tinet.sqc.sdk.request.EnableBiFunctionRequest;
import com.tinet.sqc.sdk.request.JumpUserCheckRequest;
import com.tinet.sqc.sdk.request.PermissionRequest;
import com.tinet.sqc.sdk.response.EnableBiFunctionResponse;
import com.tinet.sqc.sdk.response.JumpUserCheckResponse;
import com.tinet.sqc.sdk.response.PermissionResponse;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Before;
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
    SmartlinkClient authClient;

    @Before
    public void init() {
        SmartlinkClientConfiguration configuration = new SmartlinkClientConfiguration();

//        configuration.setAccessKeyId("U550M65OOC1Y7842Y985");
//        configuration.setAccessKeySecret("58w82m7j0bop2g4g5ghaprh43076p951");
        configuration.setAccessKeyId("0T47XMPDC89A86ZT106A");
        configuration.setAccessKeySecret("rxn60n6s7aev595ua7y2l458op6d85g7");
        //configuration.setHost("localhost", 8083);
        configuration.setHost("smartlink-sqc-openapi.tinetcloud.com");
        configuration.setConnectionRequestTimeout(100000);
        configuration.setConnectTimeout(100000);
        configuration.setSocketTimeout(100000);
        authClient = new SmartlinkClient(configuration);
    }

    @Test
    public void bi() throws ServerException, ClientException, JsonProcessingException {
        EnableBiFunctionRequest request = new EnableBiFunctionRequest();
        request.setEnterpriseId("7600114");
        request.setStatus(1);
        EnableBiFunctionResponse responseModel = authClient.getResponseModel(request);
        System.out.println(responseModel.toString());
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
