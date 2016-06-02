package com.momolela.core.interceptor;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
//import com.momolela.model.User;
import com.momolela.model.User;
import com.momolela.util.TzConstanst;

/**
 * 
 * @ClassName: LoginInterceptor
 * @Description: 登录拦截器
 * @author: momolela
 * @date 2016-5-12 下午5:04:31
 * 
 */
@Component("loginInterceptor")
public class LoginInterceptor extends AbstractInterceptor{
	private static final long serialVersionUID = 1L;
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//System.out.println("您当前执行的Action是:"+invocation.getAction().getClass().getName());
		//System.out.println("您当前执行的方法是"+invocation.getProxy().getMethod());
		//获取Action的上下文
		ActionContext context = invocation.getInvocationContext();
		//获取Session里面的值
		User user = (User) context.getSession().get(TzConstanst.SESSION_USERKEY);
		if(user!=null){
			ServletActionContext.getRequest().getSession().setAttribute("Islogin","true");
			return invocation.invoke();
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("Islogin","false");
			return null;
		}
	}
}
