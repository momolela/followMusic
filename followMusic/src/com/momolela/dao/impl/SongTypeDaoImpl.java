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
import com.momolela.dao.ISongTypeDao;
import com.momolela.model.SongType;

/**
 * @ClassName: UserDaoImpl
 * @Description: 用户操作的实现
 * @author: momolela
 * @date 2016-5-12 下午6:23:51
 */
@Repository
@Transactional
public class SongTypeDaoImpl extends BaseDaoImpl implements ISongTypeDao {

	public SongType findSongtypeByName(String songtype) {
		String hql = "from SongType where songtype = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, songtype);
		SongType songType = (SongType) query.uniqueResult();
		return songType;
	}


}
