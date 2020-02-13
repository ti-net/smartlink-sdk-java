# TBot SDK接口文档

## 功能介绍

推送话单:调用推送CDR话单接口 `PushCdrRequest` 将话单推送到TBot。


maven 依赖 smartlink-sdk-java-ai
(CTICloud 已经引用,只需要更新版本)

```xml
<!--机器人及知识库SDK-->
<dependency>
    <groupId>com.tinet.smartlink</groupId>
    <artifactId>smartlink-sdk-java-ai</artifactId>
    <version>1.0.6-RELEASE</version>
</dependency>
```

## SDK示例:

```java
public void pushCdr() {
    SmartlinkClientConfiguration configuration = new SmartlinkClientConfiguration();
    // 这些是必须设置的参数
    configuration.setAccessKeyId("your accessKeyId");
    configuration.setAccessKeySecret("your accessKeySecret");
    configuration.setHost(new HttpHost("{ip}"));
    // configuration.set...  设置其他参数(超时时间....)

    SmartlinkClient smartlinkClient = new SmartlinkClient(configuration);

    PushCdrRequest pushCdrRequest = new PushCdrRequest();
    pushCdrRequest.setAgentName("王大宝");
    pushCdrRequest.setAgentNumber("176****1920");
    pushCdrRequest.setCallType(3);
    pushCdrRequest.setCdrType("cdr_ob_agent");
    pushCdrRequest.setClid("0109987");
    pushCdrRequest.setCno("0987");
    pushCdrRequest.setStatus(1);
    pushCdrRequest.setEndReason(1);
    ............

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
}
```



### 1.推送CDR话单（支持上传录音数据）

---

#### 接口说明

接收平台上传的cdr话单信息

#### SDK对象

PushCdrRequest

#### 接口地址

  POST: smartlink-sqc-openapi.tinetcloud.com/sqc/cdr（线上环境）

  POST: smartlink-sqc-openapi-test.tinetcloud.com/sqc/cdr（测试环境）

#### 接口请求方法

POST

#### 请求参数

| 参数名             | 类型             | 是否必选 | 描述                                                         |
| ------------------ | ---------------- | -------- | ------------------------------------------------------------ |
| uniqueId           | String           | 是       | 唯一标识,命名格式:（唯一标识（建议UUID）+"-" + 秒级时间戳 （该时间戳是通话的开始时间）+"."+4位随机数） 该uniqueId,与做质检的推送话单的uniqueId一致；例如:“10.10.62.138-1554964748.121328” |
| userId             | Integer          | 是       | 用户ID,即我们内部平台的企业ID                               |
| cdrType            | String           | 是       | cdr文件类型                                                                            cdr_ib: 呼入主话单                                                                                                         cdr_ob_agent:外呼先呼座席侧主话单                    cdr_ob_customer:外呼先呼客户侧主话单 |
| callType           | Integer          | 是       | 呼叫类型                                                                                           1:呼入                                                                                                     2:网上400呼入                                                                                              3:点击外呼 |
| agentNumber        | String           | 否       | 座席电话号码                                                 |
| startTime          | Long             | 是       | 开始时间  (单位:秒)                                         |
| answerTime         | Long             | 是       | 应答时间  (单位:秒)                                         |
| endTime            | Long             | 是       | 结束时间  (单位:秒)                                         |
| bridgeTime         | Long             | 是       | 接通时间  (单位:秒)                                         |
| bridgeDuration     | Integer          | 是       | 通话时长  (单位:秒)                                         |
| totalDuration      | Integer          | 是       | 总时长     (单位:秒)                                        |
| status             | Integer          | 是       | 接听状态                                                                                              **呼入**                                                                                                 1:座席接听                                                                                      2:已呼叫座席,座席未接听                                                         3:系统接听                                                                                   4:系统未接-IVR配置错误                                                            5:系统未接-停机                                                                                      6:系统未接-欠费                                                                                       7:系统未接-黑名单                                                                                  8:系统未接-未注册                                                                                  9:系统未接-彩铃                                                                                  11:系统未接-呼叫超出营帐中设置的最大限制                                    12:系统未接-客户呼入系统后在系统未应答前挂机                          13:其他错误                                                                                       **外呼**                                                                                                        20:webcall,TTS合成失败                                                                      21:webcall,客户未接                                                                    22:webcall,客户接听                                                                                  23:webcall,已呼叫                                                                           24:webcall,双方接听                                                                     30:座席未接听                                                                                        31:座席接听,未呼叫客户                                                                         32:座席接听,客户未接听                                                                    33:双方接听                                                                                          40:预测外呼,客户未接听                                                                  41:预测外呼,客户接听                                                                     42:预测外呼,已呼叫                                                                          43:预测外呼,双方接听                                                                              50:主叫外呼接听                                                                                  51:主叫外呼,客户未接听                                                                 52:主叫外呼,双方接听 |
| endReason          | Integer          | 是       | 挂机原因  0:客户未挂机   1:客户挂机                        |
| cno                | String           | 否       | 座席标识                                                     |
| agentName          | String           | 否       | 座席名称                                                     |
| qno                | String           | 否       | 队列标识                                                     |
| qname              | String           | 否       | 队列名称                                                     |
| exten              | String           | 否       | 分机号                                                       |
| mainUniqueId       | String           | 否       | 主话单和从话单的关连键                                       |
| customerNumber     | String           | 否       | 客户号码                                                     |
| customerNumberType | String           | 否       | 客户号码类型                                                                                         1:座机    2:手机    3:分机     4:SIP    5:IAD    6:WEBRTC |
| customerAreaCode   | String           | 否       | 客户号码区号                                                 |
| customerProvince   | String           | 否       | 客户省份                                                     |
| customerCity       | String           | 否       | 客户城市                                                     |
| recordFile         | String           | 是       | 录音文件名                                                   |
| joinQueueTime      | Long             | 否       | 加入队列时间                                                 |
| numberTrunk        | String           | 否       | 中继号码                                                     |
| hotline            | String           | 否       | 热线号码                                                     |
| clid               | String           | 否       | 外显号码                                                     |

#### 返回结果

调用成功200

```json
成功:
{
    "requestId": null,
    "result":"success",
    "message": "cdr推送成功"
}
失败:
{
    "requestId": null,
    "result":"failed",
    "message": "cdr推送失败"
}
```

调用失败400

```json
失败的请求会已异常的形式抛出:
com.tinet.smartlink.commons.sdk.core.exceptions.ServerException: uniqueId不符合格式要求
.........
```

