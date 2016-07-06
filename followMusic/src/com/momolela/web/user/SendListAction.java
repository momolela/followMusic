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

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.momolela.core.action.BaseAction;
import com.momolela.model.SendList;
import com.momolela.service.ISendListService;

/**
 * 
 * @ClassName: SendListAction
 * @Description: 
 * @author: momolela
 * @date 2016-6-7 下午5:50:03
 * 
 */
@Controller("sendlistAction")
@Scope("prototype")
public class SendListAction extends BaseAction implements ServletRequestAware {

	private HttpServletRequest request;
	
	@Autowired
	private ISendListService SendListService;

	/**
	 * 加载所有的乐单
	 * @return
	 */
	public String querySendlist(){
		List<Map<String, String>> usersend_all = new ArrayList<Map<String, String>>();
		Integer[] curPage = new Integer[2];
		Integer page = Integer.parseInt(request.getParameter("pn"));
		List<SendList> sendlist = SendListService.queryUsersendList(page);
		for(SendList sl:sendlist){
			Map<String, String> usersend = new HashMap<String, String>();
			String username = SendListService.getUserByid(sl.getId()).getUsername();
			String userpicurl = SendListService.getUserByid(sl.getId()).getUserpicurl();
			Integer id = sl.getId();
			String title = sl.getTitle();
			String content = sl.getContent();
			String picurl = sl.getPicurl();
			usersend.put("username", username);
			usersend.put("userpicurl", userpicurl);
			usersend.put("id", id.toString());
			usersend.put("title", title);
			usersend.put("content", content);
			usersend.put("picurl", picurl);
			usersend_all.add(usersend);
		}
		request.setAttribute("usersend_all",usersend_all);
		Double i = (double) SendListService.count();
		curPage[1] = (int) Math.ceil(i/8);
		curPage[0] = page;
		request.setAttribute("curPage", curPage);
		return "usersend_all";
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
}
