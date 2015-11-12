package service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import entity.User;

@Service // 注册service层spring管理bean
@Transactional // 使用spring事务管理
public class UserService {
	
	@Resource
	private UserDao userDao;  
	
	/**
	 * 添加用户
	 * @param username
	 * @param password
	 */
	public void add(String username, String password) {
		userDao.insert(username, password);
	}
	
	/**
	 * 删除用户
	 * @param username
	 */
	public void delete(String username) {
		userDao.delete(username);
	}
	
	/**
	 * 更新用户
	 * @param username
	 * @param password
	 */
	public void update(String username, String password) {
		userDao.update(username, password);
	}
	
	/**
	 * 按用户名查询用户
	 * @param username
	 */
	public User get(String username) {
		return userDao.select(username);
	}
	
	/**
	 * 按用户名和密码查询用户
	 * @param username
	 */
	public User get(String username, String password) {
		return userDao.select(username, password);
	}
	
	
}
