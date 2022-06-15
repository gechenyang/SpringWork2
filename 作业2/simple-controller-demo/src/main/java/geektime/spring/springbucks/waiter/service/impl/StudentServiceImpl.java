package geektime.spring.springbucks.waiter.service.impl;

import geektime.spring.springbucks.waiter.dao.StudentDao;
import geektime.spring.springbucks.waiter.model.Student;
import geektime.spring.springbucks.waiter.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao StudentDao;
    @Override
    public List<Student> getStudent() {
        return StudentDao.getStudent();
    }
}
