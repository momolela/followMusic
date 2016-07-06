/**   
 * @Title: UserDaoImpl.java  
 * @Package com.momolela.dao.impl  
 * @Description: TODO  
 * @author momolela   
 * @date 2016-5-12 下午6:23:51  
 * @version V1.0   
 */
package com.momolela.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.momolela.core.dao.BaseDaoImpl;
import com.momolela.dao.ISongDao;
import com.momolela.model.CommentsList;
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
public class SongDaoImpl extends BaseDaoImpl implements ISongDao {

	public Song getSong(Integer songid) {
		String hql = "from Song where id = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, songid);
		Song song = (Song) query.uniqueResult();
		return song;
	}
	
	public void addSong(Song song) {
		getSession().save(song);
	}

	public List<Song> querySongList(Integer page) {
		String hql = "from Song";
		Query query = getSession().createQuery(hql);
		query.setFirstResult((page-1)*8);
		query.setMaxResults(8);
		List<Song> songlist = query.list();
		return songlist;
	}

	public double count() {
		String hql = "SELECT COUNT(*) FROM Song";
		Query query = getSession().createQuery(hql);
		Number result = (Number)query.uniqueResult();
		return result.doubleValue();
	}

	public List<Song> querySongListByType(Integer page, Integer songtypeid) {
		String hql = "select s from Song as s join s.songtype st where st.id = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, songtypeid);
		query.setFirstResult((page-1)*8);
		query.setMaxResults(8);
		List<Song> songlist = query.list();
		/*Criteria criteria = getSession().createCriteria(Song.class);
		criteria.createAlias("SongType","st");
		criteria.add(Restrictions.eq("st.id", songtypeid));
		criteria.setFirstResult((page-1)*8);
		criteria.setMaxResults(8);
		List<Song> songlist = criteria.list();*/
		return songlist;
	}

	public List<CommentsList> queryCommentsListBysid(Integer page, Integer songid) {
		String hql = "select c from CommentsList as c join c.song s where s.id = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, songid);
		query.setFirstResult((page-1)*7);
		query.setMaxResults(7);
		List<CommentsList> commentsList = query.list();
		return commentsList;
	}

	public void addCommentsList(CommentsList commentsList) {
		getSession().save(commentsList);
	}

	public Long queryCommentsListCount(Integer songid) {
		String hql = "select COUNT(c) from CommentsList as c join c.song s where s.id = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, songid);
		Long count = (Long) query.uniqueResult();
		return count;
	}

	public List<User> findUserLikeBySid(Integer page, Integer songid) {
		String hql = "select u from User as u join u.userlike ul where ul.id = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, songid);
		query.setFirstResult((page-1)*4);
		query.setMaxResults(4);
		List<User> userlist = query.list();
		return userlist;
	}

	public List<Song> getAllSong() {
		String hql = "select s from Song s";
		Query query = getSession().createQuery(hql);
		List<Song> allsonglist = query.list();
		return allsonglist;
	}

}
