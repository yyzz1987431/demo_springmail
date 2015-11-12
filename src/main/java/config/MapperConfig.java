package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import entity.User;

/**
 * 对象与表的映射设置
 */
@Configuration	// 注解为spring配置类
public class MapperConfig {
	
	@Bean(name="userMapper")
	public BeanPropertyRowMapper<User> getUserMapper(){
		return new BeanPropertyRowMapper<User>(User.class);
	}
	
}
