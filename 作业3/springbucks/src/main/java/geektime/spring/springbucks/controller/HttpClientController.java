package geektime.spring.springbucks.controller;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@RestController
@RequestMapping("httpClient")
public class HttpClientController {
    //http://localhost:8088/httpClient/remoteXml
    @RequestMapping("remoteXml")
    public String remoteXml(){
        //创建客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("http://10.10.100.21:8080/xml/getStudentInfo");
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 执行Get请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            String xml = EntityUtils.toString(responseEntity, StandardCharsets.UTF_8);
            System.out.println(xml);
            return xml;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                // 释放资源
                if (Objects.nonNull(httpClient)) {
                    httpClient.close();
                }
                if (Objects.nonNull(response)) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //http://localhost:8088/httpClient/remoteJson
    @RequestMapping("remoteJson")
    public String remoteJson(){
        //创建客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("http://10.10.100.21:8080/json/getStudent");
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 执行Get请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            String jsonObject = EntityUtils.toString(responseEntity, StandardCharsets.UTF_8);
            System.out.println(jsonObject);
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                // 释放资源
                if (Objects.nonNull(httpClient)) {
                    httpClient.close();
                }
                if (Objects.nonNull(response)) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
