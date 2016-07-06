/**   
 * @Title: UserServiceImpl.java  
 * @Package com.momolela.service.impl  
 * @Description: TODO  
 * @author momolela   
 * @date 2016-5-12 下午6:17:42  
 * @version V1.0   
 */
package com.momolela.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momolela.dao.IUserDao;
import com.momolela.model.Song;
import com.momolela.model.User;
import com.momolela.service.IUserService;

/**
 *  @ClassName: UserServiceImpl  @Description:   @author: momolela
 *  @date 2016-5-12 下午6:17:42  
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao IuserDao;

	public User findUser(String username, String password) {
		return IuserDao.findUser(username, password);
	}

	public void addUser(User user) {
		IuserDao.addUser(user);
	}

	public User getUserByName(String username) {
		return IuserDao.getUserByName(username);
	}

	public void updateInfo(Integer userid, String username, String sex) {
		IuserDao.updateInfo(userid, username, sex);
	}

	public User getUserById(Integer userid) {
		return IuserDao.getUserById(userid);
	}

	public void updateEmail(Integer userid, String email) {
		IuserDao.updateEmail(userid, email);
	}

	public void updatepassword(Integer userid, String newpassword) {
		IuserDao.updatepassword(userid, newpassword);
	}

	public void updateUserpicurl(Integer userid, String userpicurl) {
		IuserDao.updateUserpicurl(userid, userpicurl);
	}

	public Set<Song> getUserlike(Integer userid) {
		return IuserDao.getUserlike(userid);
	}

	public void addUserlike(Integer userid, Set<Song> song) {
		IuserDao.addUserlike(userid, song);
	}

	public Set<Song> getSongById(Integer sendlistid) {
		return IuserDao.getSongById(sendlistid);
	}
}
