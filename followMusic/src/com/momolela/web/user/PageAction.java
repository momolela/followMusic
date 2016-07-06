/**   
 * @Title: PageAction.java  
 * @Package com.momolela.web.user  
 * @Description: TODO  
 * @author momolela   
 * @date 2016-6-4 下午6:59:04  
 * @version V1.0   
 */
package com.momolela.web.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.momolela.core.action.BaseAction;
import com.momolela.model.Banner;
import com.momolela.model.CommentsList;
import com.momolela.model.Lrc;
import com.momolela.model.SendList;
import com.momolela.model.Song;
import com.momolela.model.SongType;
import com.momolela.model.User;
import com.momolela.service.IBannerService;
import com.momolela.service.ISendListService;
import com.momolela.service.ISongService;
import com.momolela.service.IUserService;
import com.momolela.util.MusicUtil;

/**
 * @ClassName: PageAction
 * @Description: 
 * @author: momolela
 * @date 2016-6-4 下午6:59:04
 * 
 */
@Controller("pageAction")
@Scope("prototype")
public class PageAction extends BaseAction implements ServletRequestAware{
	
	private HttpServletRequest request;
	
	@Autowired
	private IBannerService bannerService;
	
	@Autowired
	private ISongService songService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ISendListService sendListService;
	
	// 跳向歌曲评论和歌曲介绍页面。
	public String toSong() throws IOException{
		Integer sid = Integer.parseInt(request.getParameter("sid"));
		// 通过歌曲ID获得喜欢这首歌的用户
		List<User> userlist = songService.findUserLikeBySid(1, sid);
		request.setAttribute("userlist", userlist);
		// 通过歌曲ID获得包含这首歌的乐单
		List<SendList> sendlist = sendListService.findSendlistBySid(1, sid);
		request.setAttribute("sendlist", sendlist);
		// 通过歌曲id加载歌曲的信息。
		Song song = songService.getSong(sid);
		// 通过歌曲ID获得相同类型的歌曲
		Integer songtypeid = song.getSongtype().getId();
		List<Song> songlist = songService.querySongListByType(1, songtypeid);
		request.setAttribute("songlist", songlist);
		//
		request.setAttribute("song", song);
		SongType songtype = song.getSongtype();
		//
		request.setAttribute("songtype", songtype);
		// 通过歌曲ID查找lrc
		Lrc lrcObj = song.getLrc();
		if(lrcObj!=null){
		String lrcurl = lrcObj.getLrcurl();
			request.setAttribute("lrcurl", lrcurl);
			String Lrc = MusicUtil.getLrc(request);
			//
			request.setAttribute("Lrc", Lrc);
		}
		// 通过歌曲id加载歌曲的评论信息。
		//
		Integer page = Integer.parseInt(request.getParameter("pn"));
		List<CommentsList> commentsList= songService.queryCommentsListBysid(page, sid);
		Long count = songService.queryCommentsListCount(sid);
		//
		request.setAttribute("count", count);
		List<Map<String, String>> commentslist = new ArrayList<Map<String, String>>();
		for(CommentsList c:commentsList){
			
			Map<String, String> datamap = new HashMap<String, String>();
			String userpicurl = c.getUser().getUserpicurl();
			String username = c.getUser().getUsername();
			String comments = c.getComments();
			String createtime = c.getCreatetime().toString();
			datamap.put("userpicurl", userpicurl);
			datamap.put("username", username);
			datamap.put("comments", comments);
			datamap.put("createtime", createtime);
			commentslist.add(datamap);
		}
		//
		request.setAttribute("commentsList", commentslist);
		return "musiccomments";
	}
	
	// 跳向首页，所以要先加载banner需要的数据。
	public String toIndex(){
		// 把页面需要的banner数据提前加载。
		List<Banner> bannerlist = bannerService.findAllBanner();
		// 通过请求转发将数据带到响应的页面
		request.setAttribute("bannerlist", bannerlist);
		return "index";
	}
	
	// 跳向我的音乐盒
	public String toMusicbox(){
		// 加载用户自己收藏的音乐
		User user = (User)request.getSession().getAttribute("user");
		Integer uid = user.getId();
		Set<Song> songList = userService.getUserlike(uid);
		ArrayList<Song> songinfo = new ArrayList<Song>();
		if (songList == null) {
			request.setAttribute("songarray", null);
		} else {
			Iterator songlist = songList.iterator();
			while(songlist.hasNext()){
				songinfo.add((Song) songlist.next());
			}
			request.setAttribute("songarray", songinfo);
		}
		return "musicbox";
	}
	
	// 跳向后台登录页面
	public String toAdmin(){
		return "adminlogin";
	}
	
	// 跳向后台首页
	public String toAdminIndex(){
		return "adminindex";
	}
	
	// 跳向信息修改密码页面
	public String toUserPsw(){
		return "userpsw";
	}
	// 跳向信息修改密码页面
	public String toUserPic(){
		return "userpic";
	}
	// 跳向信息修改密码页面
	public String toUserInfo(){
		return "userinfo";
	}
	// 跳向信息修改密码页面
	public String toUserMail(){
		return "usermail";
	}
	
	// 跳向后台的页面管理，所以要先加载banner需要的数据。
	public String toPageManage(){
		// 把页面需要的数据提前加载。
		List<Banner> bannerlist = bannerService.findAllBanner();
		// 通过请求转发将数据带到响应的页面
		request.setAttribute("bannerlist", bannerlist);
		return "pagemanage";
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
