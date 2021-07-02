package ioc.xml;

import ioc.A;
import ioc.Student;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * @author: shimh
 * @create: 2020年05月
 **/
public class ApplicationContextTest {

	public static void main(String[] args) {
		// testBeanFactory();

		testApplicationContext();
	}

	public static void testBeanFactory() {
		ResourceLoader loader = new PathMatchingResourcePatternResolver();
		Resource resource = loader.getResource("classpath:applicationContext.xml");
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		reader.loadBeanDefinitions(resource);

		System.out.println(beanFactory.getBean("student", Student.class));

	}

	private static void testApplicationContext() {
		/**
		 * 源码进入
		 *
		 * 容器初始化
		 *
		 * getBean bean实例化
		 *
		 */

		/**
		 * 初始化单例的bean
		 * @see org.springframework.context.support.AbstractApplicationContext#refresh()
		 */
		ApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");

		Student student = context.getBean("student", Student.class);
		System.out.println(student);
	}


}
