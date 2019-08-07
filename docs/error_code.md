## 错误码说明

错误码分为两种类型：

* 客户端错误：该类型错误由客户端引起，例如无效的请求参数、用户没有权限访问资源等。

* 服务器错误：该类型错误在服务端产生，由系统异常引起，没有固定的类型。

示例
```
{
    "requestId": "842ab2a6-3732-4c03-8ab7-c7f83180fb0c",
    "error": {
        "code": "ResourceNotFound",
        "message": "指定的资源不存在"
    }
}
```

### 客户端错误

本节列出了所有操作都可能返回的常见客户端错误。






| code | HTTP Status | message
| --- | ---------- | ------
|AuthFailure |401 |身份验证失败。
|InvalidParameter |400 |请求中指定的参数无效，不受支持或无法使用。 返回的消息提供了错误值的说明。
|MissingParameter |400 |请求缺少必需参数。
|MissingRequestBody |400 |缺少请求body。
|MissingAuthenticationToken |400 |请求必须包含有效的访问密钥ID。
|HttpMediaTypeNotSupported |400 |HttpMediaType不支持，只支持application/json
|HttpRequestMethodNotSupported |405 |HTTP方法不支持。
|UnauthorizedOperation |403 |您无权执行此操作。请确认您的密钥ID有此权限
|UnknownParameter |400 |提供了未知或未识别的参数。
|SignaturesExpired |403 |签名过期
|TooManyRequests |429 |请求超限


### 服务器错误



|code |HTTP Status |message
| --- | ---------- | ------
|InternalError |500 |发生内部错误。 重试您的请求，但如果问题仍然存在，请联系技术支持。

