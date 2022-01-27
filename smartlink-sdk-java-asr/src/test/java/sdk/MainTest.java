package sdk;

import com.tinet.asr.sdk.model.AsrTaskData;
import com.tinet.asr.sdk.request.ClearAsrTaskDataRequest;
import com.tinet.asr.sdk.request.PostAsrTaskRequest;
import com.tinet.asr.sdk.response.ClearAsrTaskDataResponse;
import com.tinet.asr.sdk.response.PostAsrTaskResponse;
import com.tinet.smartlink.sdk.core.SmartlinkClient;
import com.tinet.smartlink.sdk.core.SmartlinkClientConfiguration;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpHost;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


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
        configuration.setHost(new HttpHost("smartlink-asr.clink.cn", 80, "https"));

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


    @Test
    public void clearAsrTaskData() {
        SmartlinkClientConfiguration configuration = new SmartlinkClientConfiguration();
        // 这些是必须设置的参数
        configuration.setAccessKeyId("59F6WZYJ6PT4G879D318");
        configuration.setAccessKeySecret("u610p9q44llvd1c0qluj06yq3d1946kz");
        //configuration.setHost(new HttpHost("smartlink-asr-test.tinetcloud.com", 80, "http"));
        configuration.setHost(new HttpHost("smartlink-asr.tinetcloud.com"));

        SmartlinkClient smartlinkClient = new SmartlinkClient(configuration);

        ClearAsrTaskDataRequest clearAsrTaskDataRequest = new ClearAsrTaskDataRequest();
        clearAsrTaskDataRequest.setClearFlag(false);

        ClearAsrTaskDataResponse responseModel;
        try {
            responseModel = smartlinkClient.getResponseModel(clearAsrTaskDataRequest);

            Map<String, Object> resultMap = responseModel.getResult();
            System.out.println("clearFlag:" + resultMap.get("clearFlag"));
            System.out.println("taskIdSet:" + resultMap.get("taskIdSet"));
            System.out.println("asrTaskDataList:" + resultMap.get("asrTaskDataList"));
            System.out.println("totalClear:" + resultMap.get("totalClear"));
            System.out.println("clearDataList:" + resultMap.get("clearDataList"));
            List<LinkedHashMap> asrTaskDataList = (List<LinkedHashMap>) resultMap.get("clearDataList");
            if (asrTaskDataList != null && asrTaskDataList.size() > 0){
                Long minDate = null;
                Long maxDate = null;
                for (LinkedHashMap asrTaskData : asrTaskDataList) {
                    Long createTime = (Long) asrTaskData.get("createTime");
                    if (minDate == null) {
                        minDate = createTime;
                    } else {
                        if (createTime < minDate) {
                            minDate = createTime;
                        }
                    }

                    if (maxDate == null) {
                        maxDate = createTime;
                    } else {
                        if (createTime > maxDate) {
                            maxDate = createTime;
                        }
                    }
                }

                System.out.println("minDate:" + dateToStr(new Date(minDate)));
                System.out.println("maxDate:" + dateToStr(new Date(maxDate)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String dateToStr(Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(dateDate);
        return dateString;
    }
}
