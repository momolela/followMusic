/**   
 * @Title: UserAction.java  
 * @Package com.momolela.actions.user  
 * @Description: TODO  
 * @author momolela   
 * @date 2016-4-20 上午11:58:25  
 * @version V1.0   
 */
package com.momolela.web.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.momolela.core.action.BaseAction;
import com.momolela.model.CommentsList;
import com.momolela.model.SendList;
import com.momolela.model.Song;
import com.momolela.model.User;
import com.momolela.service.ISendListService;
import com.momolela.service.ISongService;
import com.momolela.service.IUserService;
import com.momolela.util.SendMail;
import com.momolela.util.TzConstanst;
import com.momolela.util.TzStringUtils;
import com.opensymphony.xwork2.ActionContext;

/**
 * @ClassName: UserAction  
 * @Description:   
 * @author: momolela
 * @date 2016-4-20 上午11:58:25  
 */
@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction implements ServletRequestAware {

	private HttpServletRequest request;
	private Map<String, Object> datamap = new HashMap<String, Object>();

	public Map<String, Object> getDatamap() {
		return datamap;
	}

	public void setDatamap(Map<String, Object> datamap) {
		this.datamap = datamap;
	}

	@Autowired
	private IUserService UserService;
	
	@Autowired
	private ISendListService SendListService;
	
	@Autowired
	private ISongService SongService;

	/**
	 * 用户登录
	 * @return
	 */
	public String login() {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkcode = request.getParameter("checkcode");
		String securityCode = request.getSession().getAttribute("securityCode").toString();
		if (TzStringUtils.isNotEmpty(username) && TzStringUtils.isNotEmpty(password)) {
			User u = UserService.findUser(username, password);
			if (TzStringUtils.isNotEmpty(securityCode) && checkcode.equals(securityCode)) {
				if (u != null) {
					ActionContext.getContext().getSession().put(TzConstanst.SESSION_USERKEY, u);
					result = "success";
				} else {
					result = "fail";
					message = "用户名或者密码错误";
				}
			} else {
				result = "fail";
				message = "验证码填写错误";
			}
		}
		return AJAX_SUCCESS;
	}
	
	/**
	 * 用户注册
	 * @return
	 */
	public String register(){
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String againpassword = request.getParameter("againpassword");
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		String hdatapage = request.getParameter("hdata");
		String hdatasession = (String)request.getSession().getAttribute("hdata");
		//SongDao SongDao = new SongDao();
		
		if(hdatasession!=null&hdatapage.equals(hdatasession)){
			request.getSession().removeAttribute("hdata");
			if(password.equals(againpassword)){
				User u = new User();
				u.setUsername(username);
				u.setPassword(password);
				u.setSex(sex);
				u.setEmail(email);
				u.setUserpicurl("images/user/boy.jpg");
				UserService.addUser(u);
				
				// 开子线程发邮件
				SendMail sd = new SendMail();
				sd.setUser(u,"register");
				Thread t1 = new Thread(sd);
				t1.start();
				
				/*
				//注册成功后建立一个用户喜欢歌曲表的记录
				SongDao.addUserLike(UserDao.getUser(username).getId());
				
				//注册成功后在music文件夹下建立一个名字是用户ID的文件夹用于存放上传的歌曲(收藏)
				String path = ServletActionContext.getServletContext().getRealPath("/music");
				if (new java.io.File(path).isDirectory()) //如果文件夹存在
				{
					new java.io.File(path+"/"+UserDao.getUser(username).getId().toString()).mkdir();
				}
				
				//注册成功后在images/menu文件夹下建立一个名字是用户ID的文件夹用于存放歌单封面(推荐)
				String path1 = ServletActionContext.getServletContext().getRealPath("/images/menu");
				if (new java.io.File(path1).isDirectory()) //如果文件夹存在
				{
					new java.io.File(path1+"/"+UserDao.getUser(username).getId().toString()).mkdir();
				}*/
				
				ActionContext.getContext().getSession().put(TzConstanst.SESSION_USERKEY, u);
				result = "success";
			}
			else{
				result = "fail";
				message = "密码不一致请重新注册";
			}
		}else{
			result = "fail";
			message = "注册成功！！！！但请不要重复注册。";
		}
		return AJAX_SUCCESS;
	}
	
	/**
	 * 注册时检测用户名是否已经被占用
	 * @return
	 */
	public String checkName(){
		String username = request.getParameter("username");
		User u = UserService.getUserByName(username);
		if(u!=null){
			result = "success";
			message = "用户已经存在^-^";
		}else{
			result = "fail";
		}
		return AJAX_SUCCESS;
	}
		
	/**
	 * 用户注销
	 * @return
	 */
	public String logout(){
		HttpSession session = request.getSession(false);
		if(session!=null){
			session.invalidate();
			return "toIndex";
		}else{
			return null;
		}
	}
	
	/**
	 * 修改用户名和性别
	 * @return
	 */
	public String changeInfo(){
		String username = request.getParameter("username");
		if(UserService.getUserByName(username)!=null){
			result = "fail";
			message = "这个名字别人已经用了^-^";
		}else{
			String sex = request.getParameter("sex");
			User user = (User) request.getSession().getAttribute(TzConstanst.SESSION_USERKEY);
			Integer userid = user.getId();
			if(!sex.equals("男")&!sex.equals("女")){
				result = "fail";
				message = "性别只允许填写男或者女。";
			}else{
				if(sex.equals("男")){
					sex = "boy";
				}if(sex.equals("女")){
					sex = "girl";
				}
				UserService.updateInfo(userid,username,sex);
				User u = UserService.getUserById(userid);
				request.getSession().setAttribute(TzConstanst.SESSION_USERKEY,u);
				result = "success";
				message = "信息修改成功";
			}
		}
		return AJAX_SUCCESS;
	}
	
	/**
	 * 修改用户邮箱
	 * @return
	 */
	public String changeMail(){
		String securityCode = request.getSession().getAttribute("securityCode").toString();
		String email = request.getParameter("newemail");
		String checkcode = request.getParameter("checkcode");
		User user = (User) request.getSession().getAttribute(TzConstanst.SESSION_USERKEY);
		Integer userid = user.getId();
		UserService.updateEmail(userid,email);
		User u= UserService.getUserById(userid);
		request.getSession().setAttribute(TzConstanst.SESSION_USERKEY,u);
		if(checkcode!=null&!checkcode.equals("")&checkcode.equals(securityCode)){
			if(u!=null){
				// 开子线程发邮件
				SendMail sd = new SendMail();
				sd.setUser(u,"change");
				Thread t1 = new Thread(sd);
				t1.start();
				result = "success";
			}
		}
		else{
			result = "fail";
			message = "验证码输入错误";
		}
		return AJAX_SUCCESS;
	}
	/**
	 * 修改用户密码
	 * @return
	 */
	public String changePsw(){
		HttpSession session = request.getSession(false);
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		String againpassword = request.getParameter("againpassword");
		User user = (User) request.getSession().getAttribute(TzConstanst.SESSION_USERKEY);
		Integer userid = user.getId();
		User u = UserService.getUserById(userid);
		String password = u.getPassword();
		if(oldpassword.equals(password)){
			if(!newpassword.equals("")&!againpassword.equals("")){
				if(newpassword.equals(againpassword)){
					UserService.updatepassword(userid, newpassword);
					session.invalidate();
					result = "success";
				}else{
					result = "fail";
					message = "两次密码输入不一致";
				}
			}else{
				result = "fail";
				message = "密码输入不能为空";
			}
		}
		else{
			result = "fail";
			message = "原始密码输入有误";
		}
		return AJAX_SUCCESS;
	}
	
	/**
	 * 修改用户头像
	 * @return
	 */
	/*public String changePic(){
		String
		String dir = ServletActionContext.getServletContext().getRealPath("/images/user/userpic");//获取文件保存的文件夹路径
		String num = UUID.randomUUID().toString().replaceAll("-","");
		String userpicurl = "images/user/userpic/"+num+picFileName;
		// long l = System.nanoTime();//获取系统的时间
		File newFile = new File(dir,userpicurl);//将文件写入到upload文件夹中
		pic.renameTo(newFile);//将上传的文件重命名
		
		User user = (User) request.getSession().getAttribute(TzConstanst.SESSION_USERKEY);
		Integer userid = user.getId();
		UserService.updateUserpicurl(userid,userpicurl);
		User u = UserService.getUserById(userid);
		request.getSession().setAttribute(TzConstanst.SESSION_USERKEY,u);
		return AJAX_SUCCESS;
	}*/
	
	/**
	 * 判断是否已经有了自己的乐单
	 * @return
	 */
	public String hasUserSend(){
		Integer ID = null;
		User user = (User) request.getSession().getAttribute(TzConstanst.SESSION_USERKEY);
		Integer userid = user.getId();
		Set<SendList> sendlist =  SendListService.findSendlistByuserid(userid);
		if(sendlist.isEmpty()){
			result = "fail";
		}else{
			result = "success";
			// 如果已经有了乐单就直接加载自己的乐单，所以要通过id去查询。
			for(SendList s:sendlist){
				ID = s.getId();
				datamap.put("ID",ID);
			}
		}
		return AJAX_SUCCESS;
	}
	
	/**
	 * 用户新建自己的乐单
	 * @return
	 */
	public String newUserSend(){
		/*User user = (User) request.getSession().getAttribute(TzConstanst.SESSION_USERKEY);
		Integer userid = user.getId();
		
		String listname = "";
		String listdesc = "";
		String url = "";
		
		DiskFileItemFactory fi = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fi);
		fi.setSizeThreshold(1024*1024*1024);
		try {
			upload.setHeaderEncoding("utf-8");
			List<FileItem> items = upload.parseRequest(request);
			String path = getServletContext().getRealPath("/images/menu"+"/"+id);
			
			for(FileItem item:items)
			{
				if(item.isFormField()){
					if(item.getFieldName().equals("listname")){
						listname = item.getString("utf-8");
					}
					else if(item.getFieldName().equals("listdesc")){
						listdesc = item.getString("utf-8");
					}
				}
				else{
					String num = UUID.randomUUID().toString().replaceAll("-","");
					String fileName = item.getName();
					InputStream in = item.getInputStream();
					//获取歌曲路径
					url = "images/menu/"+id+"/"+num+fileName;
					OutputStream out = new FileOutputStream(path+"\\"+num+fileName);
					byte[] buffer = new byte[1024];
					while(in.read(buffer)>0)
					{
						out.write(buffer);
					}
					out.close();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		UserSend UserSend = new UserSend();
		UserSend.setUserid(id);
		UserSend.setTitle(listname);
		UserSend.setContent(listdesc);
		UserSend.setPicurl(url);
		SongDao SongDao = new SongDao();
		SongDao.addUserSend(UserSend);
		UserSend u1= SongDao.queryUsersendByuserid(id);
		Integer id1 = u1.getId();
		
		response.sendRedirect("QueryUserSendServlet?id="+id1);*/
		
		return null;
	}
	
	/**
	 * 加载用户自己的乐单
	 * @return
	 */
	public String queryUserSend(){
		Map<String, String> usersend = new HashMap<String, String>();
		List<Map<String, String>> usersendlist = new ArrayList<Map<String, String>>();
		Integer id = Integer.parseInt(request.getParameter("id"));
		Set<Song> songset = UserService.getSongById(id);
		request.setAttribute("songset",songset);
		SendList sendlist = SendListService.findSendlistByid(id);
		String username = SendListService.getUserByid(sendlist.getId()).getUsername();
		String userpicurl = SendListService.getUserByid(sendlist.getId()).getUserpicurl();
		String title = sendlist.getTitle();
		String content = sendlist.getContent();
		String picurl = sendlist.getPicurl();
		usersend.put("username", username);
		usersend.put("userpicurl", userpicurl);
		usersend.put("id", id.toString());
		usersend.put("title", title);
		usersend.put("content", content);
		usersend.put("picurl", picurl);
		usersendlist.add(usersend);
		request.setAttribute("usersendlist",usersendlist);
		return "usersend_page";
	}
	
	/**
	 * 用户为歌曲添加评论
	 * @return
	 */
	public String addComments(){
		Integer sid = Integer.parseInt(request.getParameter("sid"));
		String comments = request.getParameter("comments");
		User user = (User) request.getSession().getAttribute(TzConstanst.SESSION_USERKEY);
		Integer uid = user.getId();
		CommentsList commentsList = new CommentsList ();
		commentsList.setComments(comments);
		commentsList.setUser(UserService.getUserById(uid));
		commentsList.setSong(SongService.getSong(sid));
		SongService.addCommentsList(commentsList);
		result = "success";
		return AJAX_SUCCESS;
	}
	
	/**
	 * ajax加载评论
	 * @return
	 */
	public String loadComments(){
		// 通过歌曲id加载歌曲的信息。
		// 通过歌曲id加载歌曲的评论信息。
		Integer sid = Integer.parseInt(request.getParameter("sid"));
		Integer page = Integer.parseInt(request.getParameter("pn"));
		List<CommentsList> commentsList= SongService.queryCommentsListBysid(page, sid);
		List<Map<String, String>> commentslist = new ArrayList<Map<String, String>>();
		if(!commentsList.isEmpty()){
			for(CommentsList c:commentsList){
				
				Map<String, String> data = new HashMap<String, String>();
				String userpicurl = c.getUser().getUserpicurl();
				String username = c.getUser().getUsername();
				String comments = c.getComments();
				String createtime = c.getCreatetime().toString();
				data.put("userpicurl", userpicurl);
				data.put("username", username);
				data.put("comments", comments);
				data.put("createtime", createtime);
				commentslist.add(data);
			}
			datamap.put("commentslist", commentslist);
			result = "success";
		}else{
			result = "fail";
		}
		return AJAX_SUCCESS;
	}
	
	/**
	 * 得到所有的歌曲
	 * @return
	 */
	public String getSong(){
		List<Song> allsonglist= SongService.getAllSong();
		List<Map<String, String>> songlist = new ArrayList<Map<String, String>>();
		for(Song s:allsonglist){
			Map<String, String> data = new HashMap<String, String>();
			String songname = s.getSongname();
			String singer = s.getSinger();
			String url = s.getUrl();
			String id = s.getId().toString();
			data.put("songname", songname);
			data.put("singer", singer);
			data.put("url", url);
			data.put("id", id);
			songlist.add(data);
		}
		result = "success";
		datamap.put("songlist", songlist);
		return AJAX_SUCCESS;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
}
