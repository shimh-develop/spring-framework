package mvc;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.MvcNamespaceHandler;

/**
 * @author: shiminghui
 * @create: 2021年06月
 **/
public class ContextLoaderListenerTest {

	public static void main(String[] args){
		/**
		 *
		 * 1 ContextLoaderListener 创建根容器
		 *
		 * 2 DispatcherServlet.init 创建MVC容器  MvcNamespaceHandler 解析mvc标签
		 *
		 * 3 DispatcherServlet.init 同样会初始化MVC的相关组件
		 *
		 *
		 *
		 *
		 */
		ContextLoaderListener contextLoaderListener;
		DispatcherServlet dispatcherServlet;
		MvcNamespaceHandler handler;
	}
}
