package geektime.spring.springbucks.waiter.dao.impl;

import geektime.spring.springbucks.waiter.dao.StudentDao;
import geektime.spring.springbucks.waiter.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> getStudent() {
        List<Student> studentList = new ArrayList<>();
        Student ss = new Student();
        ss.setUserName("张三");
        ss.setAge(20);
        studentList.add(ss);

        Student mm = new Student();
        mm.setUserName("李四");
        mm.setAge(19);
        studentList.add(mm);

        return studentList;
    }
}
