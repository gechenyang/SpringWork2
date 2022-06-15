package geektime.spring.springbucks.waiter.controller;

import com.alibaba.fastjson.JSONObject;
import geektime.spring.springbucks.waiter.model.Student;
import geektime.spring.springbucks.waiter.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("json")
public class JsonRequestController {
    @Resource
    private StudentService studentService;
    //http://localhost:8080/json/getStudent
    @RequestMapping("getStudent")
    public JSONObject getStudent(){
        List<Student> list = studentService.getStudent();
        JSONObject json=new JSONObject();
        json.put("list",list);
        return json;
    }
}
