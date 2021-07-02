package transaction;

import org.springframework.transaction.config.TxNamespaceHandler;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * @author: shiminghui
 * @create: 2020年05月
 **/
public class TransactionTest {

	public static void main(String[] args) {
		/**
		 * 	springCotext.xml
		 * 	开启事务驱动
		 * 	<tx:annotation-driven transaction-manager="transactionManager"/>
		 *一、解析
		 * 	1. TxNamespaceHandler 注册 AnnotationDrivenBeanDefinitionParser 来解析 annotation-driven
		 * 	@see org.springframework.transaction.config.TxNamespaceHandler#init()
		 * 	2. 解析的入口在 AnnotationDrivenBeanDefinitionParser.parse方法
		 * 	@see org.springframework.transaction.config.AnnotationDrivenBeanDefinitionParser#parse(org.w3c.dom.Element, org.springframework.beans.factory.xml.ParserContext)
		 *		注册 InfrastructureAdvisorAutoProxyCreator 它是 BeanPostProcessor 所以容器创建bean的阶段 会调用它的postProcessAfterInitialization(在父类中)方法
		 *		在该方法中会获取Advisor的实现类，当然包含下面注册的BeanFactoryTransactionAttributeSourceAdvisor，来判断是否启用代理
		 * 		@see org.springframework.aop.framework.autoproxy.InfrastructureAdvisorAutoProxyCreator
		 * 		@see org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator#postProcessAfterInitialization(java.lang.Object, java.lang.String)
		 *		注册 AnnotationTransactionAttributeSource
		 * 		@see org.springframework.transaction.annotation.AnnotationTransactionAttributeSource
		 *		注册 TransactionInterceptor 事务的增强
		 * 		@see org.springframework.transaction.interceptor.TransactionInterceptor
		 *		注册 BeanFactoryTransactionAttributeSourceAdvisor 事务Advisor 包含切点和增强
		 *		@see org.springframework.transaction.interceptor.BeanFactoryTransactionAttributeSourceAdvisor
		 *
		 *二、代理
		 *	1. 上面注册的InfrastructureAdvisorAutoProxyCreator 它是 BeanPostProcessor 所以容器创建bean的阶段 会调用它的postProcessAfterInitialization(在父类中)方法
		 *		在该方法中会获取Advisor的实现类，来判断是否启用代理
		 *
		 *
		 *三、调用service时 执行事务增强
		 * 	1. 执行TransactionInterceptor的invoke方法
		 *	@see org.springframework.transaction.interceptor.TransactionInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
		 *
		 *
		 * TransactionInterceptor[transactionAttributeSource] = AnnotationTransactionAttributeSource
		 *
		 * BeanFactoryTransactionAttributeSourceAdvisor[transactionAttributeSource] = AnnotationTransactionAttributeSource
		 * BeanFactoryTransactionAttributeSourceAdvisor[adviceBeanName] = TransactionInterceptor
		 *
		 */


		try {
			System.out.println("a");
			try {
				System.out.println("b");
				int a = 1/0;
				System.out.println("c");
			}finally {
				System.out.println("finally");
			}
			System.out.println("d");

		}catch (Exception e) {
			System.out.println("e");
			e.printStackTrace();
		}
		System.out.println("f");

	}
}
