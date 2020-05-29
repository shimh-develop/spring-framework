package ioc.annotation;

import ioc.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: shimh
 * @create: 2020年05月
 **/
public class ApplicationContextTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);

		Student student = context.getBean("student", Student.class);
		System.out.println(student);



	}
}
