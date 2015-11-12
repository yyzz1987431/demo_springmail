package config;

import java.io.IOException;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 数据库连接配置
 */
@Configuration	// 注解为spring配置java类
@ComponentScan("..") // 注解扫描包
@EnableTransactionManagement // 使用事务管理器
public class JdbcConfig {
	
	private DriverManagerDataSource dataSource;

	/**
	 * 无参构造方法, 初始化datasource信息
	 */
	public JdbcConfig() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(getProperties().get("jdbc.driver").toString());
		dataSource.setUrl(getProperties().get("jdbc.url").toString());
		dataSource.setUsername(getProperties().get("jdbc.username").toString());
		dataSource.setPassword(getProperties().get("jdbc.password").toString());
	}
	
	/**
	 * 注册spring数据库操作模版
	 * @return
	 */
	@Bean // 将方法返回值注册为spring管理bean
	JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}
	
	/**
	 * 注册spring事务管理器
	 * @return
	 */
	@Bean // 将方法返回值注册为spring管理bean
	DataSourceTransactionManager getTransactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}
	
	/**
	 * 读取配置文件信息
	 * @return
	 */
	private Properties getProperties(){
		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("/jdbc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	
}
