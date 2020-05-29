package aop.xml;

import aop.Student;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: shimh
 * @create: 2020年05月
 **/
public class ApplicationContextTest {

	public static void main(String[] args) {
		/**
		 * 1、<aop:aspectj-autoproxy/> 或 @EnableAspectJAutoProxy 会注册 AnnotationAwareAspectJAutoProxyCreator
		 * 	@see AnnotationAwareAspectJAutoProxyCreator
		 *
		 * 2、所有的代理处理都是在 AnnotationAwareAspectJAutoProxyCreator 中实现的
		 * 	2.1、bean实例化前，会代理 TargetSource 的类 同时缓存了容器中的增强Advisor
		 *
		 * 	@see AbstractAutoProxyCreator#postProcessBeforeInstantiation(java.lang.Class, java.lang.String)
		 *
		 * 	2.2、bean初始化后 对符合条件的bean进行代理
		 *
		 * 	@see AbstractAutoProxyCreator#postProcessAfterInitialization(java.lang.Object, java.lang.String)
		 *
		 *
		 * 对advice进行排序  Around.class, Before.class, After.class, AfterReturning.class, AfterThrowing.class
		 * @see org.springframework.aop.aspectj.annotation.ReflectiveAspectJAdvisorFactory#getAdvisorMethods(java.lang.Class)
		 *
		 * 对advisor排序 对@After @Before 等排序
		 * @see org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator#findEligibleAdvisors(java.lang.Class, java.lang.String)
		 *
		 *  afterReturning
		 */

		ApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext-aop.xml");

		Student student = context.getBean("student", Student.class);
		student.eat();
	}
}
