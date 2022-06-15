package geektime.spring.springbucks.waiter.controller;

import com.thoughtworks.xstream.XStream;
import geektime.spring.springbucks.waiter.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("xml")
public class XmlRequestController {
    //http://localhost:8080/xml/getStudentInfo
    @RequestMapping(value = "/getStudentInfo",produces={"application/xml; charset=UTF-8"})
    @ResponseBody
    public String getStudentInfo(){
        Student ss = new Student();
        ss.setUserName("张三");
        ss.setAge(20);
        XStream xStream = new XStream();
        xStream.alias("student",Student.class);
        String xml = xStream.toXML(ss);
        return xml;
    }
}