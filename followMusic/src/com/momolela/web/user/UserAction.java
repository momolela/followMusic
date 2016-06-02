/**   
 * @Title: UserAction.java  
 * @Package com.momolela.actions.user  
 * @Description: TODO  
 * @author momolela   
 * @date 2016-4-20 上午11:58:25  
 * @version V1.0   
 */
package com.momolela.web.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.momolela.core.action.BaseAction;
import com.momolela.model.User;
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

	@Autowired
	private IUserService UserService;

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
				sd.setUser(u);
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

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
