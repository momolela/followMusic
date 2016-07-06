/**   
 * @Title: UserServiceImpl.java  
 * @Package com.momolela.service.impl  
 * @Description: TODO  
 * @author momolela   
 * @date 2016-5-12 下午6:17:42  
 * @version V1.0   
 */
package com.momolela.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momolela.dao.ISendListDao;
import com.momolela.model.SendList;
import com.momolela.model.User;
import com.momolela.service.ISendListService;

/**
 * @ClassName: UserServiceImpl
 * @Description: 
 * @author: momolela
 * @date 2016-5-12 下午6:17:42
 * 
 */
@Service
public class SendListServiceImpl implements ISendListService{

	@Autowired
	private ISendListDao ISendListDao;

	public Set<SendList> findSendlistByuserid(Integer userid) {
		return ISendListDao.findSendlistByuserid(userid);
	}

	public List<SendList> queryUsersendList(Integer page) {
		return ISendListDao.queryUsersendList(page);
	}
	
	public User getUserByid(Integer sendlistid) {
		return ISendListDao.getUserByid(sendlistid);
	}

	public double count() {
		return ISendListDao.count();
	}

	public SendList findSendlistByid(Integer id) {
		return ISendListDao.findSendlistByid(id);
	}

	public List<SendList> findSendlistBySid(Integer page, Integer songid) {
		return ISendListDao.findSendlistBySid(page, songid);
	}
	
}
