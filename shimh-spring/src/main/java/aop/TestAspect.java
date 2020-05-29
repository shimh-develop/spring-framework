package aop;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: shimh
 * @create: 2020年05月
 **/
@Aspect
//@EnableAspectJAutoProxy 和 xml 中 <aop:aspectj-autoproxy/> 作用相同
public class TestAspect {

	@Pointcut("execution(void aop.Student.eat())")
	public void pointcut() {}

	@AfterReturning("pointcut()")
	public void afterReturn() {
		System.out.println("擦嘴 afterReturn");
	}



	@After("pointcut()")
	public void after2() {
		System.out.println("擦嘴 after2");
	}
	@After("pointcut()")
	public void a1() {
		System.out.println("擦嘴 a1");
	}
	@After("pointcut()")
	public void after() {
		System.out.println("擦嘴 after");
	}


	@Before("pointcut()")
	public void cbeforecccc() {
		System.out.println("洗手 cbeforecccc");
	}

	@Before("pointcut()")
	public void beforeaaaaa() {
		System.out.println("洗手 beforeaaaaa");
	}








}
