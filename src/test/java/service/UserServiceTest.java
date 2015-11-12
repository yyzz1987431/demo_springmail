package service;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import util.SpringUtil;

public class UserServiceTest {

	private static UserService userService = SpringUtil.getBean("userService", UserService.class);
	
	
	@Test
	@Transactional
	public void testAdd() {
		userService.add("xx", "yy");
	}
	
	@Test
	@Transactional
	public void testDelete() {
		userService.delete("xx");
	}
	
	@Test
	@Transactional
	public void testUpdate() {
		userService.update("xx", "zz");
	}
	

}
