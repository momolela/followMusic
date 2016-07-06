package com.momolela.util;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.momolela.dao.impl.UserDaoImpl;
import com.momolela.model.Song;
import com.momolela.model.User;
import com.opensymphony.xwork2.ActionContext;

public class LoadMusicFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		/**
		 * 这个过滤器是用来用户打开我的音乐盒之前拦截请求 往音乐盒中加载喜欢的歌曲
		 */
		UserDaoImpl ui = new UserDaoImpl();
		User user = (User) ActionContext.getContext().getSession().get(TzConstanst.SESSION_USERKEY);
		Integer userid = user.getId();
		Set<Song> songList = ui.getUserlike(userid);
		ArrayList<Song> songinfo = new ArrayList<Song>();
		if (songList == null) {
			ActionContext.getContext().getSession().put("songarray", null);
		} else {
			Iterator songlist = songList.iterator();
			while(songlist.hasNext()){
				songinfo.add((Song) songlist.next());
			}
			ActionContext.getContext().getSession().put("songarray", songinfo);
		}
		chain.doFilter(request, response);
	}
		

	public void init(FilterConfig fConfig) throws ServletException {}


	public void destroy() {}

}
