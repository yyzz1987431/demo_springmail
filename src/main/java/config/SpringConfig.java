package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 数据库连接配置
 */
@Configuration	// 注解为spring配置java类
@ComponentScan("..") // 注解扫描包
public class SpringConfig {
	
	@Bean  // 用于读取配置文件
	public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean // 初始化线程池
	public ThreadPoolTaskExecutor initThreadPoolTaskExecutor(){
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setQueueCapacity(200); 			// 队列容量
		threadPoolTaskExecutor.setCorePoolSize(5);					// 核心线程数量
		threadPoolTaskExecutor.setMaxPoolSize(100);				// 最大线程数量
		threadPoolTaskExecutor.setKeepAliveSeconds(300);		// 允许线程空闲时间  
		threadPoolTaskExecutor.initialize();		// 重新初始化
		return threadPoolTaskExecutor;  
	}
	

}
