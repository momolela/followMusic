package com.momolela.dao;

import java.util.List;

import com.momolela.model.CommentsList;
import com.momolela.model.Song;
import com.momolela.model.User;

public interface ISongDao {
	public Song getSong(Integer songid);
	public void addSong(Song song);
	public List<Song> querySongList(Integer page);
	public double count();
	public List<Song> querySongListByType(Integer page, Integer songtypeid);
	public List<CommentsList> queryCommentsListBysid(Integer page, Integer songid);
	public void addCommentsList(CommentsList commentsList);
	public Long queryCommentsListCount(Integer songid);
	public List<User> findUserLikeBySid(Integer page, Integer songid);
	public List<Song> getAllSong();
}
