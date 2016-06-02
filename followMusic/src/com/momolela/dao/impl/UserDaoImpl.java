/**   
 * @Title: UserDaoImpl.java  
 * @Package com.momolela.dao.impl  
 * @Description: TODO  
 * @author momolela   
 * @date 2016-5-12 下午6:23:51  
 * @version V1.0   
 */
package com.momolela.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.momolela.core.dao.BaseDaoImpl;
import com.momolela.dao.IUserDao;
import com.momolela.model.User;

/**
 * @ClassName: UserDaoImpl
 * @Description: 用户操作的实现
 * @author: momolela
 * @date 2016-5-12 下午6:23:51
 */
@Repository
@Transactional
public class UserDaoImpl extends BaseDaoImpl implements IUserDao {

	public User findUser(String username, String password) {
		String hql = "from user where username = ? and password = ?";
		Query query = getSession().createQuery(hql);
		query.setString(0, username);
		query.setString(1, password);
		User user = (User) query.uniqueResult();
		return user;
	}

	public void addUser(User user) {
		getSession().save(user);
	}

	public User getUserByName(String username) {
		String hql = "from user where username = ?";
		Query query = getSession().createQuery(hql);
		query.setString(0, username);
		User user = (User) query.uniqueResult();
		return user;
	}

}
