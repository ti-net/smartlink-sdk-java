package com.tinet.smartlink.sdk.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinet.smartlink.sdk.core.auth.Signer;
import com.tinet.smartlink.sdk.core.exceptions.ClientException;
import com.tinet.smartlink.sdk.core.exceptions.ServerException;
import com.tinet.smartlink.sdk.core.request.BaseRequest;
import com.tinet.smartlink.sdk.core.response.BaseResponse;
import com.tinet.smartlink.sdk.core.response.ErrorResponse;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * <p>示例代码</p><br>
<pre>
        SmartlinkClientConfiguration configuration = new SmartlinkClientConfiguration();

        *******************************
        // 这些是必须设置的参数
        configuration.setAccessKeyId("");
        configuration.setAccessKeySecret("");
        configuration.setHost(new HttpHost(""))
        *******************************

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
 </pre>
 详细文档：<a href="http://kb.tinetcloud.com/pages/viewpage.action?pageId=6293887">http://kb.tinetcloud.com/pages/viewpage.action?pageId=6293887</a>
 * @author houfc
 * @date 2018/11/26
 */
public class SmartlinkClient {

    private HttpClient httpClient;

    private HttpHost httpHost = null;

    private SmartlinkClientConfiguration configuration = null;

    private Signer signer = Signer.getSigner();

    private PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();

    private HttpClientBuilder httpClientBuilder = null;

    private ObjectMapper objectMapper = new ObjectMapper();

    public SmartlinkClient(SmartlinkClientConfiguration configuration) {
        this.configuration = configuration;
        config(this.configuration);
        httpClient = httpClientBuilder.setKeepAliveStrategy(new SdkConnectionKeepAliveStrategy(this.configuration.getKeepAliveDurationMillis()))
                .build();
        httpHost = new HttpHost(configuration.getHost());
    }

    public <T extends BaseResponse> HttpResponse execute(BaseRequest<T> request)
            throws ServerException, ClientException {
        return execute(request, httpHost);
    }

    public <T extends BaseResponse> HttpResponse execute(BaseRequest<T> request, HttpHost host)
            throws ClientException, ServerException {
        request.signRequest(signer, configuration.getCredentials(), host.getHostName(), request.uri());
        try {

            BasicHttpEntityEnclosingRequest httpRequest = new BasicHttpEntityEnclosingRequest(request.httpMethod().toString(), request.uri() + "?" + request.generateUri());


            if (request.httpMethod().hasContent()) {

                StringEntity entity = new StringEntity(objectMapper.writeValueAsString(request), ContentType.APPLICATION_JSON);
                httpRequest.setEntity(entity);
            }
            if (host != null) {
                httpHost = host;
            }
            return httpClient.execute(httpHost, httpRequest);
        } catch (URISyntaxException e) {
            throw new ClientException("SDK", "URI 错误", e);
        } catch (ClientProtocolException e) {
            throw new ClientException("SDK", "SDK 协议错误", e);
        } catch (IOException e) {
            throw new ClientException("SDK", "服务器连接失败", e);
        }
    }

    public <T extends BaseResponse> T getResponseModel (BaseRequest<T> request, String host)
            throws ServerException, ClientException {
        return getResponseModel(request, new HttpHost(host));
    }

    public <T extends BaseResponse> T getResponseModel (BaseRequest<T> request)
            throws ServerException, ClientException {
        return getResponseModel(request, this.httpHost);
    }

    public <T extends BaseResponse> T getResponseModel (BaseRequest<T> request, HttpHost host)
            throws ClientException, ServerException {
        HttpResponse response = execute(request, host);
        if (isSuccess(response)) {
            try {
                return readResponse(response, request.getResponseClass());
            } catch (IOException e) {
                throw new ClientException("ParseJsonError", "请求成功，解析返回结果失败，请确认SDK 版本是否正确", e);
            }
        } else {
            if (HttpStatus.SC_SERVICE_UNAVAILABLE == response.getStatusLine().getStatusCode()) {
                try {
                    // HttpClient有清理CLOSE_WAIT状态的机制，只有在读body操作后才会触发HttpClient Manager回收连接，
                    // 否则会被认为该连接一直在处理请求。因此在处理异常请求部分的代码中增加 EntityUtils.consume(response.getEntity()) 方法读body操作
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    throw new ServerException("ServiceUnavailable", "服务不可用，请稍后再试。" + e.getMessage());
                }
                throw new ServerException("ServiceUnavailable", "服务不可用，请稍后再试。");
            }
            ErrorResponse errorResponse = null;
            try {
                errorResponse = readResponse(response, ErrorResponse.class);
                if (HttpStatus.SC_INTERNAL_SERVER_ERROR >= response.getStatusLine().getStatusCode()) {
                    throw new ServerException(errorResponse.getError().getCode(), errorResponse.getError().getMessage(), errorResponse.getRequestId());
                } else {
                    throw new ClientException(errorResponse.getError().getCode(), errorResponse.getError().getMessage(), errorResponse.getRequestId());
                }
            } catch (IOException e) {
                throw new ServerException("ServiceError", "服务异常");
            }

        }
    }

    private boolean isSuccess(HttpResponse response) {
        StatusLine statusLine = response.getStatusLine();
        if (statusLine == null || statusLine.getStatusCode() >= 400) {
            return false;
        }
        return true;
    }

    private <T extends BaseResponse> T readResponse(HttpResponse response, Class<T> clazz) throws IOException {
        return objectMapper.readValue(response.getEntity().getContent(), clazz);

    }

    private void config(SmartlinkClientConfiguration configuration) {
        connectionManager.setMaxTotal(configuration.getMaxConnections());
        connectionManager.setDefaultMaxPerRoute(configuration.getMaxConnectionsPerRoute());
        httpClientBuilder = HttpClientBuilder.create().setConnectionManager(connectionManager);

        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(configuration.getSocketTimeout())
                .setConnectTimeout(configuration.getConnectTimeout())
                .setConnectionRequestTimeout(configuration.getConnectionRequestTimeout())
                .build();
        httpClientBuilder.setDefaultRequestConfig(requestConfig);
    }
}
