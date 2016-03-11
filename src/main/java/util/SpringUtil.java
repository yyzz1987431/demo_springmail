package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.SpringConfig;

/**
 * spring工具类
 */
public class SpringUtil {

	private static AnnotationConfigApplicationContext context;
	
	/**
	 * 获取ApplicationContext
	 * @return
	 */
	public static ApplicationContext getApplicationContext(){
		if (context == null) {
			context = new AnnotationConfigApplicationContext(SpringConfig.class);
		}
		return context;
	}
	
	/**
	 * 通过类型获取bean
	 * @param requiredType
	 * @return
	 */
	public static <T> T getBean(Class<T> requiredType) {
		return getApplicationContext().getBean(requiredType);
	}
	
	/**
	 * 通过名称获取bean
	 * @param name
	 * @param requiredType
	 * @return
	 */
	public static <T> T getBean(String name, Class<T> requiredType) {
		return getApplicationContext().getBean(name, requiredType);
	}
	
}
