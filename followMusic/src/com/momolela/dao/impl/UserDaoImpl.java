/**   
 * @Title: UserDaoImpl.java  
 * @Package com.momolela.dao.impl  
 * @Description: TODO  
 * @author momolela   
 * @date 2016-5-12 下午6:23:51  
 * @version V1.0   
 */
package com.momolela.dao.impl;

import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.momolela.core.dao.BaseDaoImpl;
import com.momolela.dao.IUserDao;
import com.momolela.model.SendList;
import com.momolela.model.Song;
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
		String hql = "from User where username = ? and password = ?";
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
		String hql = "from User where username = ?";
		Query query = getSession().createQuery(hql);
		query.setString(0, username);
		User user = (User) query.uniqueResult();
		return user;
	}

	public void updateInfo(Integer userid, String username, String sex) {
		String hql = "UPDATE User as u SET u.username=? , u.sex=? WHERE u.id=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, username);
		query.setParameter(1, sex);
		query.setParameter(2, userid);
		query.executeUpdate();
	}

	public User getUserById(Integer userid) {
		String hql = "from User where id = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, userid);
		User user = (User) query.uniqueResult();
		return user;
	}

	public void updateEmail(Integer userid, String email) {
		String hql = "UPDATE User as u SET u.email=? WHERE u.id=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, email);
		query.setParameter(1, userid);
		query.executeUpdate();
	}

	public void updatepassword(Integer userid, String newpassword) {
		String hql = "UPDATE User as u SET u.password=? WHERE u.id=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, newpassword);
		query.setParameter(1, userid);
		query.executeUpdate();
	}

	public void updateUserpicurl(Integer userid, String userpicurl) {
		String hql = "UPDATE User as u SET u.userpicurl=? WHERE u.id=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, userpicurl);
		query.setParameter(1, userid);
		query.executeUpdate();
	}

	public Set<Song> getUserlike(Integer userid) {
		User user = (User) getSession().get(User.class, userid);
		Set<Song> song = user.getUserlike();
		return song;
		/*
		 * String hql = "select s from User as u join u.userlike s where u.id = ?"; 
		 * Session s=getSession(); Query query = getSession().createQuery(hql);
		 * query.setParameter(0, userid); 
		 * Set<Song> song = (Set<Song>)query.list(); // 这里不能直接强转，会报错。 return song;
		 */
	}

	public void addUserlike(Integer userid, Set<Song> song) {
		User user = (User) getSession().get(User.class, userid);
		user.setUserlike(song);
	}

	public Set<Song> getSongById(Integer sendlistid) {
		SendList sendlist = (SendList) getSession().get(SendList.class, sendlistid);
		Set<Song> songset = sendlist.getSong();
		return songset;
	}
}
