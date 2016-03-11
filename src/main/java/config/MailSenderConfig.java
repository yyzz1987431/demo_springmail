package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * 邮件发送配置
 */
@Configuration
@PropertySource("classpath:mail.properties")
public class MailSenderConfig {

	@Value("${mail.host}")
	private String host;
	@Value("${mail.port}")
	private int port;
	@Value("${mail.username}")
	private String username;
	@Value("${mail.password}")
	private String password;
	

	@Bean // 初始化邮件发送器
	public JavaMailSenderImpl initJavaMailSenderImpl() {
		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
		mailSenderImpl.setHost(host);
		mailSenderImpl.setPort(port);
		mailSenderImpl.setUsername(username);
		mailSenderImpl.setPassword(password);
		return mailSenderImpl;
	}
	
}
