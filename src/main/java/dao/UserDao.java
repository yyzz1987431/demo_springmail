package dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import entity.User;

@Repository	// 注册dao层spring管理bean
public class UserDao {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private BeanPropertyRowMapper<User> userMapper;
	
	/**
	 * 插入用户
	 * @param username
	 * @param password
	 */
	public void insert(String username, String password) {
		jdbcTemplate.update("insert into user (username, password) values(?,?)", username, password);
	}
	
	/**
	 * 删除用户
	 * @param username
	 */
	public void delete(String username) {
		jdbcTemplate.update("delete from user where username=?", username);
	}
	
	/**
	 * 更新用户
	 * @param username
	 * @param password
	 */
	public void update(String username, String password) {
		jdbcTemplate.update("update user set password=? where username=?", password, username);
	}
	
	/**
	 * 通过用户名查找
	 * @param username
	 * @return 查询成功返回user对象, 失败返回null
	 */
	public User select(String username) {
		return jdbcTemplate.queryForObject("select username, password from user where username=?", userMapper, username);
	}
	
	/**
	 * 通过用户名和密码查找
	 * @param username
	 * @param password
	 * @return
	 */
	public User select(String username, String password) {
		return jdbcTemplate.queryForObject("select username, password from user where username=? and password=?", userMapper, username, password);
	}
	
	/**
	 * 查询列表
	 * @return
	 */
	public List<User> selectList() {
		return jdbcTemplate.query("select * from user", userMapper);
	}
	
}
