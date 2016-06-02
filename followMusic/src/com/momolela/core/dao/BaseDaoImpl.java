package com.momolela.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * BaseDaoImpl
 * 创建人:momolela
 * 时间：2015年4月29日-上午12:03:20 
 */
public class BaseDaoImpl {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 获取连接对象
	 * 方法名：getSession
	 * 创建人：momolela 时间：2015年4月29日-上午12:03:46 
	 * @return Session
	 */
	public Session getSession() {
		if (sessionFactory != null) {
			return sessionFactory.getCurrentSession();
		}
		return null;
	}
}
