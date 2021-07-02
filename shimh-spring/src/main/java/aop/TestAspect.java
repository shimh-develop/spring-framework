package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;

/**
 * @author: shimh
 * @create: 2020年05月
 **/
@Aspect
//@EnableAspectJAutoProxy 和 xml 中 <aop:aspectj-autoproxy/> 作用相同
public class TestAspect {

	@Pointcut("execution(void aop.Student.eat())")
	public void pointcut() {}




//	@After("pointcut()")
//	public void after2() {
//		System.out.println("擦嘴 after2");
//	}
//	@After("pointcut()")
//	public void a1() {
//		System.out.println("擦嘴 a1");
//	}



//	@Before("pointcut()")
//	public void cbeforecccc() {
//		System.out.println("洗手 cbeforecccc");
//	}

	@Before("pointcut()")
	public void before() {
		System.out.println("洗手 before");
	}

	@After("pointcut()")
	public void after() {
		System.out.println("擦嘴 after");
	}

	@AfterReturning("pointcut()")
	public void afterReturn() {
		System.out.println("擦嘴 afterReturn");
	}

	@AfterThrowing("pointcut()")
	public void afterThr() {
		System.out.println("擦嘴 afterThr");
	}

	@Around("pointcut()")
	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("擦嘴 around 前");
		proceedingJoinPoint.proceed();
		System.out.println("擦嘴 around 后");
	}
}
