package geektime.spring.springbucks.dao.impl;

import geektime.spring.springbucks.dao.testDao;
import org.springframework.stereotype.Repository;

@Repository("testDaoImpl")
public class testDaoImpl implements testDao {

    @Override
    public void method1() {
        System.out.println("执行方法了method1");
    }


}
