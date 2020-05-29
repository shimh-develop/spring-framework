package ioc.annotation;


import ioc.Student;
import org.springframework.context.annotation.Bean;

import javax.management.MXBean;

/**
 * @author: shimh
 * @create: 2020年05月
 **/
public class AnnotationConfig {

	@Bean
	public Student student () {
		return new Student("shimh", 27);
	}

}
