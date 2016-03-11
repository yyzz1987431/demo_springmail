package service;

import org.junit.Test;

import util.SpringUtil;

public class MailSeanderServiceTest {

	
	private MailSeanderService mailSeanderService = SpringUtil.getBean("mailSeanderService", MailSeanderService.class);
	
	
	@Test
	public void testSendMail() {
		mailSeanderService.sendMail("标题"+System.currentTimeMillis(), "内容"+System.currentTimeMillis());
	}
	
	

}
