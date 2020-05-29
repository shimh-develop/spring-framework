package ioc.xml;

import ioc.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: shimh
 * @create: 2020年05月
 **/
public class ApplicationContextTest {

	public static void main(String[] args) {
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
