/**   
 * @Title: UserAction.java  
 * @Package com.momolela.actions.user  
 * @Description: TODO  
 * @author momolela   
 * @date 2016-4-20 上午11:58:25  
 * @version V1.0   
 */
package com.momolela.web.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.momolela.core.action.BaseAction;
import com.momolela.model.Song;
import com.momolela.service.ISongService;

/**
 * 
 * @ClassName: SendListAction
 * @Description: 
 * @author: momolela
 * @date 2016-6-7 下午5:50:03
 * 
 */
@Controller("allMusicAction")
@Scope("prototype")
public class AllMusicAction extends BaseAction implements ServletRequestAware {

	private HttpServletRequest request;
	
	@Autowired
	private ISongService SongService;

	/**
	 * 加载所有的音乐
	 * @return
	 */
	public String queryAllMusic(){
		Integer[] curPage = new Integer[2];
		Integer page = Integer.parseInt(request.getParameter("pn"));
		List<Song> songlist = SongService.querySongList(page);
		request.setAttribute("songlist",songlist);
		Double i = (double) SongService.count();
		curPage[1] = (int) Math.ceil(i/8);
		curPage[0] = page;
		request.setAttribute("curPage", curPage);
		return "allmusic";
	}
	
	public String queryAllMusicByType(){
		Integer[] curPage = new Integer[2];
		Integer songtypeid = Integer.parseInt(request.getParameter("songtypeid"));
		Integer page = Integer.parseInt(request.getParameter("pn"));
		List<Song> songlist = SongService.querySongListByType(page,songtypeid);
		request.setAttribute("songlist",songlist);
		Double i = (double) SongService.count();
		curPage[1] = (int) Math.ceil(i/8);
		curPage[0] = page;
		request.setAttribute("curPage", curPage);
		return "musicByType";
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
}
