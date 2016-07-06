/**   
 * @Title: UserServiceImpl.java  
 * @Package com.momolela.service.impl  
 * @Description: TODO  
 * @author momolela   
 * @date 2016-5-12 下午6:17:42  
 * @version V1.0   
 */
package com.momolela.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momolela.dao.ISongTypeDao;
import com.momolela.model.SongType;
import com.momolela.service.ISongTypeService;

/**
 * @ClassName: UserServiceImpl
 * @Description: 
 * @author: momolela
 * @date 2016-5-12 下午6:17:42
 * 
 */
@Service
public class SongTypeServiceImpl implements ISongTypeService{

	@Autowired
	private ISongTypeDao ISongTypeDao;

	public SongType findSongtypeByName(String songtype) {
		return ISongTypeDao.findSongtypeByName(songtype);
	}

	
}
