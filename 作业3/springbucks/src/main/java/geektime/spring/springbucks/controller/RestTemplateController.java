package geektime.spring.springbucks.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("rest")
public class RestTemplateController {
    @Autowired
    private RestTemplate restTemplate;
    //http://localhost:8088/rest/remoteXml
    @RequestMapping("remoteXml")
    public String remoteXml(){
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://10.10.100.21:8080/xml/getStudentInfo", String.class);
        System.out.println(responseEntity.getStatusCodeValue());//状态码
        System.out.println(responseEntity.getHeaders());//文件头
        System.out.println(responseEntity.getBody());//内容
     return responseEntity.getBody().toString();
    }
    //http://localhost:8088/rest/remoteJson
    @RequestMapping("remoteJson")
    public String remoteJson(){
        JSONObject ss = restTemplate.getForObject("http://10.10.100.21:8080/json/getStudent", JSONObject.class);
        return ss.toString();
    }
}
