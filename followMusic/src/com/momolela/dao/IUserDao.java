package com.momolela.dao;

import com.momolela.model.User;

public interface IUserDao {
	public User findUser(String username, String password);
	public void addUser(User user);
	public User getUserByName(String username);
}
