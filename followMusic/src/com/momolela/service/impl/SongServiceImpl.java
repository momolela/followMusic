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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momolela.model.CommentsList;
import com.momolela.model.Song;
import com.momolela.model.User;
import com.momolela.service.ISongService;
import com.momolela.dao.ISongDao;

/**
 * @ClassName: UserServiceImpl
 * @Description: 
 * @author: momolela
 * @date 2016-5-12 下午6:17:42
 * 
 */
@Service
public class SongServiceImpl implements ISongService{

	@Autowired
	private ISongDao ISongDao;

	public Song getSong(Integer songid) {
		return ISongDao.getSong(songid);
	}

	public void addSong(Song song) {
		ISongDao.addSong(song);
	}

	public List<Song> querySongList(Integer page) {
		return ISongDao.querySongList(page);
	}

	public double count() {
		return ISongDao.count();
	}

	public List<Song> querySongListByType(Integer page, Integer songtypeid) {
		return ISongDao.querySongListByType(page, songtypeid);
	}

	public List<CommentsList> queryCommentsListBysid(Integer page, Integer songid) {
		return ISongDao.queryCommentsListBysid(page, songid);
	}

	public void addCommentsList(CommentsList commentsList) {
		ISongDao.addCommentsList(commentsList);
	}

	public Long queryCommentsListCount(Integer songid) {
		return ISongDao.queryCommentsListCount(songid);
	}

	public List<User> findUserLikeBySid(Integer page, Integer songid) {
		return ISongDao.findUserLikeBySid(page, songid);
	}

	public List<Song> getAllSong() {
		return ISongDao.getAllSong();
	}
	
}
