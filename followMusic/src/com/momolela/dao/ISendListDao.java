package com.momolela.dao;

import java.util.List;
import java.util.Set;

import com.momolela.model.SendList;
import com.momolela.model.User;

public interface ISendListDao {
	public Set<SendList> findSendlistByuserid(Integer userid);
	public List<SendList> queryUsersendList(Integer page);
	public User getUserByid(Integer sendlistid);
	public double count();
	public SendList findSendlistByid(Integer id);
	public List<SendList> findSendlistBySid(Integer page, Integer songid);
}
