package com.poetry.commom;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * httpclient工具类
 */
public class UrlUtil {

    // 编码格式。发送编码格式统一用UTF-8
    private static final String ENCODING = "UTF-8";

    // 设置连接超时时间，单位毫秒。
    private static final int CONNECT_TIMEOUT = 6000;

    // 请求获取数据的超时时间(即响应时间)，单位毫秒。
    private static final int SOCKET_TIMEOUT = 6000;

    public static HttpClientResult sendPost(String url, Map<String,String> params) throws Exception{
        String content="";
        CloseableHttpClient httpClient= HttpClients.createDefault();
        HttpPost httpPost=new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
        httpPost.setConfig(requestConfig);
        packageParam(params,httpPost);

        CloseableHttpResponse httpResponse=null;

        try {
            httpResponse=httpClient.execute(httpPost);
            if (httpResponse!=null && httpResponse.getStatusLine()!=null){
                if (httpResponse.getEntity()!=null){
                    content=  EntityUtils.toString(httpResponse.getEntity(), ENCODING);
                }
                return new HttpClientResult(httpResponse.getStatusLine().getStatusCode(),content);
            }
            return new HttpClientResult(HttpStatus.SC_INTERNAL_SERVER_ERROR,"");
        }finally {
            if (httpClient!=null){
                httpClient.close();
            }
            if (httpResponse!=null){
                httpResponse.close();
            }
        }

    }

    /**
     * Description:封装请求参数
     *
     */
    public static void packageParam(Map<String,String>params, HttpEntityEnclosingRequestBase httpMethod)throws UnsupportedEncodingException{
        if (params!=null){
            List<NameValuePair> nvps=new ArrayList<NameValuePair>();
            Set<Map.Entry<String,String>> entrySet=params.entrySet();
            for (Map.Entry<String,String> entry:entrySet){
                nvps.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
            }
            httpMethod.setEntity(new UrlEncodedFormEntity(nvps,ENCODING));

        }
    }


}
