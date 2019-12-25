# 1.根据uniqueIdList批量获取质检详情接口及示例

## 1.根据uniqueIdList批量获取质检详情接口

### 1.1  接口说明

通过uniqueIdList获取录音记录质检详情

### 1.2  SDK对象

ListCdrDetailsByUniqueIdListRequest

### 1.3  接口地址


  POST: smartlink-sqc-openapi-test.tinetcloud.com/sqc/listCdrDetailsByUniqueIdList（测试环境）

### 1.4 接口请求方法

POST

### 1.5  请求参数

| 参数名   		| 类型    | 是否必选 | 描述                          				 |
| -------- 		| ------  | -------- | ----------------------------------------------|
| uniqueIdList 		| List<String>  | 是       | 话单的uniqueIdList集合 |
| userId 		| String  | 否      | 用户ID,即我们内部平台的企业ID |

### 1.6 返回参数示例

 因数据比较长，放在本文的最后，详情见 2.3 返回参数展示示例



### 1.7 CdrDetail 数据格式

| 返回值字段     	    | 类型及范围   | 说明                                                         |
| -------------- 	    | ------------ | ------------------------------------------------------------ |
| id             	    | string       | 唯一ID，（你们那的callId，对应慧智这边的uniqueId） |
| cdrId          	    | string       | 所属于的cdr ID                                               |
| qcTemplate            | string       | 质检模板名称（包括评分和评级末班）    |
| qcResult              | JsonArray    | 质检项目                                                 |
| asr                   | JsonArray    | 通话内容                                                 |
| statMark                   | JsonArray    | 标记详情                                                 |
| dpTag                   | JsonArray    | 质检标签                                                 |
| qcScore             	    | integer       | 质检评分：0~100    |
| qcStatus             	    | Integer       | 质检状态(1.未质检,2.已自动质检,3.已人工复核,4.待座席确认,5.申诉中,6.座席已确认,7.重新质检中,8.已重新质检)    |
| qcTime             	    | Long       | 自动质检时间 |
| qcReviewTime             	    | Long       | 人工复核时间 |



#### 1.7.1 qcResult 数据格式

| 参数名 | java类型  | 说明                                       |
| :----- | :-------- | ------------------------------------------ |
| item   | String    | 质检项名                                   |
| weight | Integer   | 质检项权重                                 |
| score  | Double    | 质检项得分                                 |
| id     | Integer   | id                                         |
| name   | String    | 质检项名称                                 |
| items  | JsonArray | 子质检项（这里面的值和模板中配置的值一致） |
| hit    | Integer   | 质检项是否为致命项                         |



#### 1.7.2 asr 数据格式

| 参数名     | java类型 | 说明                             |
| :--------- | :------- | -------------------------------- |
| id         | Integer  | 0.1: 表示坐席侧第一句话          |
| callSide   | Integer  | 0代表坐席侧话术。1代表客户侧话术 |
| begin_time | Integer  | 开始时间                         |
| end_time   | Integer  | 结束时间                         |
| text       | String   | 转写文本                         |


#### 1.7.3  statMark 数据格式

| 参数名  | java类型 | 说明                   |
| :------ | :------- | :--------------------- |
| id      | String   | 关键词所在语句的id     |
| index   | number   | 关键词在句中的起始位置 |
| length  | Integer  | 关键词长度             |
| keyword | String   | 关键词                 |
| group   | String   | 关键组名               |
| type    | Integer  | 客户侧或者座席侧标识   |

#### 1.7.4 **dpTag**  数据格式

| 参数名       | java类型 | 说明                             |
| :----------- | :------- | -------------------------------- |
| `name`       | String   | `标签名`                         |
| `asr_side`   | Integer  | `asr话术侧 0：坐席侧，1：客户侧` |
| `tag_side`   | Integer  | 0：坐席侧，1：客户侧             |
| `start_time` | Integer  | `asr话术开始时间`                |
| `message`    | String   | `打标签时进行的记录信息`         |
| `deleted`    | Integer  | `标签是否被删除`                 |
| `added`      | Integer  | `标签是否为新增`                 |





## 2  慧智根据uniqueIdList批量获取质检详情

### 2.1 说明


### 2.2 SDK示例:

```java
public void listCdrDetailsByUniqueIdList() {
    SmartlinkClientConfiguration configuration = new SmartlinkClientConfiguration();
            // 这些是必须设置的参数
        	configuration.setAccessKeyId("your accessKeyId");
        	configuration.setAccessKeySecret("your accessKeySecret");
            configuration.setHost(new HttpHost("{ip}"));
        	// configuration.set...  设置其他参数(超时时间....)

            SmartlinkClient smartlinkClient = new SmartlinkClient(configuration);

            ListCdrDetailsByUniqueIdListRequest listCdrDetailsByUniqueIdListRequest = new 			  ListCdrDetailsByUniqueIdListRequest();
            listCdrSqcDetailsRequest.setUniqueIdList(uniqueIdList);
    		listCdrSqcDetailsRequest.setUserId(userId);
    		
           
            

            ListCdrDetailsByUniqueIdListResponse responseModel = null;
            try {
             responseModel =smartlinkClient.getResponseModel(listCdrSqcDetailsRequest);   
            } catch (ServerException e) {
            	// 服务器错误,大概率是出 bug 了
            	e.printStackTrace();
        	} catch (ClientException e) {
            	// 客户端错误,参数校验没通过？做了不该做的事？反正是你的事,再看看你写的代码
            	e.printStackTrace();
        	}
    }
```

### 2.3 如果您不用SDK的方式，也可以选择鉴权

#### 2.3.1 签名计算方法

*签名算法*

签名（Signature）用于对 API 请求进行身份认证和鉴权，每个请求必须具有唯一的签名。
签名的具体实现是以 AccessKeySecret 为密钥，使用 hmac-sha1 算法对用户请求参数（QueryString）、访问密钥ID（AccessKeyId）、签名有效时间（Expires）、签名当前时间戳（Timestamp）做哈希计算。
具体步骤如下：

*1. 拼接参数urlParam*

```
（GET请求）
 GET smartlink-openapi.tinetcloud.com/?
 AccessKeyId=********************
 &Expires=60
 &param1=value1
 &Timestamp=2019-02-14T10%3A18%3A12Z
 
 (param1:是get请求参数)
```

```
（POST请求）
POSTsmartlink-openapi.tinetcloud.com/?
AccessKeyId=********************
&Expires=60
&Timestamp=2019-02-14T10%3A18%3A12Z

（body不用加密）
```

说明：

拼接要加密的字符串规则：请求方法（GET/POST）+ 请求域名（smartlink-api.tinetcloud.com）+请求参数。（就像上面的例子：POST smartlink-openapi.tinetcloud.com/?AccessKeyId=********************&Expires=60
&Timestamp=2019-02-14T10%3A18%3A12Z）

其中，访问密钥ID（AccessKeyId）、签名有效时间（Expires）、签名时间戳（Timestamp）分别与上面的公共请求参数相对应，请求参数具体拼接规则为：（GET请求与POST请求一致）

1. 首先对用户请求参数的 name 进行字典排序，例如 a1, a2, b1, b2
2. 通过&符号连接用户请求参数的 name 和 value，如："a1=1&a2=2&b1=3&b2=4"
3. Timestamp为UTC时间格式，所有请求参数都要进行URL转码

POST请求与GET请求不同点：

   1.例如上述事例中，GET请求urlParam中是有请求参数的，也就是param1等，而POST因为参数是在body体重。不用放在地址栏，所以urlParam没有请求参数

```
Signature = URLEncode(hmac-sha1(AccessKeySecret, urlParam))
```

#### 2.3.2 JAVA 加密Demo

可以采用简单方便的引用SDK的办法

```java
public class ListCdrSqcDetailsTest {

    private final Map<String, String> parameters = new TreeMap<>();

    @Autowired
    private CloseableHttpClient httpClient;

    /**
     * 发送post请求，加密算法(get注释里会展示)
     */
    @Test
    public void sign() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String accessKeyId="your accessKeyId";
        String accessKeySecret = "your accessKeySecret";
        Integer expires = 5;  //时间随意设置
        String timestamp = sdf.format(new Date()); //签名时间戳
        String signature =null; // 计算签名
        String url = "smartlink-sqc-openapi- 	 test.tinetcloud.com/sqc/listCdrDetailsByUniqueIdList"; // 需要访问的接口,

        //把每个参数做一下urlecode,并插入treemap,treemap有序的
        putParameter("AccessKeyId",accessKeyId);
        putParameter("Expires",expires);
        putParameter("Timestamp",timestamp);

        //拼接参数urlParam 如（1）中 ，例如“POSTsmartlink-sqc-openapi-test.tinetcloud.com/sqc/listCdrDetailsByUniqueIdList?accessKeyId=.......”
        //当请求示GET 时，需要将参数也拼接上。如（1）中，例如“GETsmartlink-sqc-openapi-test.tinetcloud.com/sqc/listCdrDetailsByUniqueIdList?accessKeyId=***&fileUrl=....”
        
        String urlParam = "POSTsmartlink-sqc-openapi-test.tinetcloud.com/sqc/listCdrSqcDetails"+"?"+geturlParam(parameters);
        //加密
        signature =hmac(accessKeySecret, urlParam);
        //将计算签名做URLEncoder
        putParameter("Signature",signature);
        //拼接post最终的请求地址
        String postUrl = "http://"+url +"?" + geturlParam(parameters);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("uniqueId","*****");
        jsonObject.put("userId","****");
        HttpPost httpPost = new HttpPost(postUrl);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
        httpPost.setConfig(requestConfig);
        httpPost.setHeader("Content-type","application/json");
        // 构建消息实体
        httpPost.setEntity(new StringEntity(jsonObject.toJSONString(), "UTF-8"));
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();
            String result = EntityUtils.toString(responseEntity, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 加密算法
     * @param accessKeySecret
     * @param urlParam
     * @return
     */
    private String hmac(String accessKeySecret, String urlParam) {
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(accessKeySecret.getBytes("UTF-8"), "HmacSHA1"));
            byte[] signData = mac.doFinal(urlParam.getBytes("UTF-8"));
            return DatatypeConverter.printBase64Binary(signData);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e.toString());
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e.toString());
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e.toString());
        }
    }

    /**
     * 将排序好也做好URLEncoder的参数拼接
     * @param parameters
     * @return
     */
    private String getUrlParam(Map<String, String> parameters) {

        TreeMap<String, String> sortedParameters = new TreeMap<String, String>(parameters);
        StringBuilder sortedParameterString = new StringBuilder();

        //拼接urlparam字符串
        for(String key : sortedParameters.keySet()) {
            sortedParameterString.append(key)
                    .append("=")
                    .append(sortedParameters.get(key))
                    .append("&");
        }
        if (sortedParameterString.length() != 0 ) {
            sortedParameterString = new StringBuilder(sortedParameterString.substring(0, sortedParameterString.length() - 1));
        }

        return sortedParameterString.toString();
    }

    /**
     * 添加参数之前，键值对都需要做URLEncoder
     * @param key
     * @param value
     */
    private void putParameter(String key,Object value) {
        try {
            String encodedKey = URLEncoder.encode(key, "UTF-8");
            String encodedValue = URLEncoder.encode(String.valueOf(value), "UTF-8");
            parameters.put(encodedKey, encodedValue);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
```

```java
请求成功但无数据返回反参：
{
    "message": "没有该通话质检的详细信息",
    "code":200
}
异常信息：
{
    "error": {
        "code": "MissingParameter",
        "message": "系统服务异常"
    }
}
请求成功反参：
{
    "result": [
        {
            "id": "29ba2d751bb74803a1e57ddc9d7e7ba8-1559354410.5",
            "mainUniqueId": "29ba2d751bb74803a1e57ddc9d7e7ba8-1559354410.5",
            "cdrId": "1100003-29ba2d751bb74803a1e57ddc9d7e7ba8-1559354410.5",
            "qcTemplate": "changchengkuandai- 初始化模板",
            "qcScore": 100,
            "qcStatus": 7,
            "qcResult": [
                {
                    "score": 10,
                    "item": "工单",
                    "weight": 10
                },
                {
                    "score": 10,
                    "item": "沟通技巧",
                    "weight": 10
                },
                {
                    "score": 15,
                    "item": "服务态度与意识",
                    "weight": 15
                },
                {
                    "score": 5,
                    "item": "结束",
                    "weight": 5
                },
                {
                    "score": 15,
                    "item": "解决方案",
                    "weight": 15
                },
                {
                    "score": 12,
                    "item": "排查流程",
                    "weight": 12
                },
                {
                    "score": 7,
                    "item": "问候",
                    "weight": 7
                },
                {
                    "score": 8,
                    "item": "探询",
                    "weight": 8
                },
                {
                    "score": 8,
                    "item": "3A",
                    "weight": 8
                },
                {
                    "score": 10,
                    "item": "核实信息",
                    "weight": 10
                }
            ],
            "asr": [{
                    "length": 2,
                    "index": 15,
                    "id": "0.10",
                    "keyword": "微信",
                    "type": 0,
                    "group": "敏感类"
                },
                {
                    "length": 2,
                    "index": 34,
                    "id": "0.14",
                    "keyword": "微信",
                    "type": 0,
                    "group": "敏感类"
                },]
        },
        {
            "id": "55ff0dca13e84d6f9246334b46517ea9-1559354401.5",
            "mainUniqueId": "55ff0dca13e84d6f9246334b46517ea9-1559354401.5",
            "cdrId": "1100003-55ff0dca13e84d6f9246334b46517ea9-1559354401.5",
            "qcTemplate": "changchengkuandai- 初始化模板",
            "qcScore": 93,
            "qcStatus": 7,
            "qcResult": [
                {
                    "score": 10,
                    "item": "工单",
                    "weight": 10
                },
                {
                    "score": 10,
                    "item": "沟通技巧",
                    "weight": 10
                },
                {
                    "score": 15,
                    "item": "服务态度与意识",
                    "weight": 15
                },
                {
                    "score": 5,
                    "item": "结束",
                    "weight": 5
                },
                {
                    "score": 15,
                    "item": "解决方案",
                    "weight": 15
                },
                {
                    "score": 12,
                    "item": "排查流程",
                    "weight": 12
                },
                {
                    "score": 0,
                    "item": "问候",
                    "weight": 7
                },
                {
                    "score": 8,
                    "item": "探询",
                    "weight": 8
                },
                {
                    "score": 8,
                    "item": "3A",
                    "weight": 8
                },
                {
                    "score": 10,
                    "item": "核实信息",
                    "weight": 10
                }
            ],
            "asr": [{
                    "length": 2,
                    "index": 15,
                    "id": "0.10",
                    "keyword": "微信",
                    "type": 0,
                    "group": "敏感类"
                },
                {
                    "length": 2,
                    "index": 34,
                    "id": "0.14",
                    "keyword": "微信",
                    "type": 0,
                    "group": "敏感类"
                },]
        }
}
```