# smartlink-commons-sdk

慧智平台SDK 公共模块，慧智对外提供的SDK 及内部跨平台调用使用的SDK 都引用该模块。

# SDK 使用

## 添加 maven 依赖

```xml
<!-- 核心模块依赖 -->
<dependency>
    <groupId>com.tinet</groupId>
    <artifactId>smartlink-commons-sdk-core</artifactId>
    <version>{smartlink.sdk.version}</version>
</dependency>

<!-- 所使用的产品 --> 
<dependency>
    <groupId>com.tinet</groupId>
    <artifactId>smartlink-commons-sdk</artifactId>
    <version>{smartlink.project.sdk.version}</version>
</dependency>

```

## 代码示例

```java

SmartlinkClientConfiguration configuration = new SmartlinkClientConfiguration();

        // 这些是必须设置的参数
configuration.setAccessKeyId("");
configuration.setAccessKeySecret("");
configuration.setHost("")

configuration.set...  设置其他参数

SmartlinkClient smartLinkClient = new SmartlinkClient(configuration);

SaveCdrRequest saveCdrRequest = new SaveCdrRequest();
// 设置属性 saveCdrRequest.set...
try {
        // 请求成功正常返回对应的 response
    SaveCdrResponse saveCdrResponse = smartLinkClient.getResponseModel(saveCdrRequest);
} catch (ServerException e) {
    // 服务器错误，大概率是出 bug 了
    e.printStackTrace();
} catch (ClientException e) {
    // 客户端错误，参数校验没通过？做了不该做的事？反正是你的事，再看看你写的代码
    e.printStackTrace();
}
```
