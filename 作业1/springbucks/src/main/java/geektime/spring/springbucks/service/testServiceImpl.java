package geektime.spring.springbucks.service;

import geektime.spring.springbucks.dao.testDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("beanSeviceTest")
public class testServiceImpl implements testService{
    @Resource
    private testDao testDao;
    @Override
    public void method1() {
        testDao.method1();
    }
}
