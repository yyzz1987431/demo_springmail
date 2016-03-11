package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

/**
 * 邮件发送服务
 * @author YangJie [2016年2月26日 上午11:52:56]
 */
@Service
public class MailSeanderService {
	
	@Autowired
	private JavaMailSenderImpl javaMailSender;
	@Autowired
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;
	
	
	// 测试目标地址, 可从数据库等获取
	String[] tos = {"ghyg525@qq.com", "ghyg527@qq.com"};
	
	
	/**
	 * 发送邮件
	 * @author YangJie [2016年2月26日 上午11:57:44]
	 */
	public void sendMail(String subject, String text){
		SimpleMailMessage mailMessage = new SimpleMailMessage(); 
		mailMessage.setFrom(javaMailSender.getUsername());
		mailMessage.setTo(tos);
		mailMessage.setSubject(subject);
		mailMessage.setText(text);
		sendMail(mailMessage);
	}
	
	/**
	 * 发送邮件(异步)
	 * @author YangJie [2016年2月26日 下午2:58:39]
	 * @param message
	 */
	public void sendMail(final SimpleMailMessage message){
		// 同步发送
		javaMailSender.send(message);
		// 异步发送 > 在web工程中使用线程池(主线程结束后线程池中的任务不执行, 具体原因还未知)
		threadPoolTaskExecutor.execute(new Runnable() {
			public void run() {
				javaMailSender.send(message);
			}
		});
	}

}
