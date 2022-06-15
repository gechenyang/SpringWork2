package geektime.spring.springbucks;

import geektime.spring.springbucks.model.Person;
import geektime.spring.springbucks.service.testService;
import geektime.spring.springbucks.service.testServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBucksApplicationTests {
	@Resource
	private testService testService;

	//通过annotation注解自动装配
	@Test
	public void test1() {
		testService.method1();
	}

	//通过xml配置文件装配bean
	@Test
	public void test2() {
		// 初始化Spring容器，加载配置文件，并对bean进行实例化

		org.springframework.core.io.Resource resource= (org.springframework.core.io.Resource) new ClassPathResource("config.xml");
		BeanFactory bf=new XmlBeanFactory(resource);
		// 获得person1实例
		Person person1 = (Person) bf
				.getBean("person1");
		System.out.println(person1);

		// 获得person2实例
		Person person2 = (Person) bf
				.getBean("person2");
		System.out.println(person2);
	}
}

