package com.momolela.service;

import com.momolela.model.User;

public interface IUserService {

	public User findUser(String username, String password);
	public void addUser(User user);
	public User getUserByName(String username);
}
