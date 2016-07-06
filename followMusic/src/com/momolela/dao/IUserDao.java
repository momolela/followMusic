package com.momolela.dao;

import java.util.Set;

import com.momolela.model.Song;
import com.momolela.model.User;

public interface IUserDao {
	public User findUser(String username, String password);
	public void addUser(User user);
	public User getUserByName(String username);
	public void updateInfo(Integer userid, String username, String sex);
	public User getUserById(Integer userid);
	public void updateEmail(Integer userid, String email);
	public void updatepassword(Integer userid, String newpassword);
	public void updateUserpicurl(Integer userid, String userpicurl);
	public Set<Song> getUserlike(Integer userid);
	public void addUserlike(Integer userid, Set<Song> song);
	public Set<Song> getSongById(Integer sendlistid);
}
