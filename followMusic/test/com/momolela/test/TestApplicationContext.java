package com.momolela.test;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.momolela.dao.IUserDao;
import com.momolela.model.User;
public class TestApplicationContext {

	public static void main(String[] args) throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		IUserDao IUserDao = (IUserDao) context.getBean("userDaoImpl");
		/*User user =new User();
		user.setUsername("hu");
		user.setPassword("123456");
		user.setSex("girl");
		user.setEmail("308146120@qq.com");
		user.setUserpicurl("images/user/boy.jpg");
		IUserDao.addUser(user);*/
		
		System.out.println(IUserDao.getUserByName("hu").getEmail());
	}
	
	@Test
	public void testConnect() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		IUserDao userDao = (IUserDao) context.getBean("userDaoImpl");
		User user = new User();
		user.setUsername("test");
		user.setPassword("123456");
		user.setSex("girl");
		user.setEmail("308146120@qq.com");
		user.setUserpicurl("images/user/boy.jpg");
		userDao.addUser(user);
	}
}
