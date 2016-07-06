/**   
 * @Title: UserDaoImpl.java  
 * @Package com.momolela.dao.impl  
 * @Description: TODO  
 * @author momolela   
 * @date 2016-5-12 下午6:23:51  
 * @version V1.0   
 */
package com.momolela.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.momolela.core.dao.BaseDaoImpl;
import com.momolela.dao.ISendListDao;
import com.momolela.model.SendList;
import com.momolela.model.User;

/**
 * @ClassName: UserDaoImpl
 * @Description: 用户操作的实现
 * @author: momolela
 * @date 2016-5-12 下午6:23:51
 */
@Repository
@Transactional
public class SendListDaoImpl extends BaseDaoImpl implements ISendListDao {

	public Set<SendList> findSendlistByuserid(Integer userid) {
		User user = (User) getSession().get(User.class,userid);
		Set<SendList> sendlist = user.getSendlist();
		return sendlist;
	}

	public List<SendList> queryUsersendList(Integer page) {
		List<SendList> s = new ArrayList<SendList>();
		String hql = "from SendList";
		Query query = getSession().createQuery(hql);
		query.setFirstResult((page-1)*8);
		query.setMaxResults(8);
		List<SendList> sendlist = query.list();
		Iterator<SendList> it = sendlist.iterator();
		while(it.hasNext()){
			s.add(it.next());
		}
		return s;
	}
	
	public User getUserByid(Integer sendlistid) {
		SendList sendlist = (SendList) getSession().get(SendList.class,sendlistid);
		User user = sendlist.getUser();
		return user;
	}

	public double count() {
		String hql = "SELECT COUNT(*) FROM SendList";
		Query query = getSession().createQuery(hql);
		Number result = (Number)query.uniqueResult();
		return result.doubleValue();
	}

	public SendList findSendlistByid(Integer id) {
		String hql = "from SendList where id=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, id);
		SendList sendlist = (SendList) query.uniqueResult();
		return sendlist;
	}

	public List<SendList> findSendlistBySid(Integer page, Integer songid) {
		String hql = "select sl from SendList as sl join sl.song s where s.id = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, songid);
		query.setFirstResult((page-1)*3);
		query.setMaxResults(3);
		List<SendList> sendlist = query.list();
		return sendlist;
	}
}
