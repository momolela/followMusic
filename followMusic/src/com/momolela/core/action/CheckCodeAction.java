/**   
 * @Title: CheckCodeAction.java  
 * @Package com.momolela.actions.utils  
 * @Description: TODO  
 * @author momolela   
 * @date 2016-4-20 下午12:41:43  
 * @version V1.0   
 */
package com.momolela.core.action;

import java.io.ByteArrayInputStream;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;

import com.momolela.util.CodeMake;
import com.momolela.util.ImgMake;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @ClassName: CheckCodeAction
 * @Description: 
 * @author: momolela
 * @date 2016-4-20 下午12:41:43
 * 
 */
@Component("checkCodeAction")
public class CheckCodeAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	
	//图片流
    private ByteArrayInputStream imageStream;  
    //session域  
    private Map<String, Object> session ;
    
	public ByteArrayInputStream getImageStream() {
		return imageStream;
	}
	public void setImageStream(ByteArrayInputStream imageStream) {
		this.imageStream = imageStream;
	}
	
	public String execute() throws Exception {
		//获取默认难度和长度的验证码  
        String securityCode = CodeMake.getSecurityCode();  
        imageStream = ImgMake.getImageAsInputStream(securityCode);  
        //放入session中  
        session.put("securityCode", securityCode);
        return "success"; 
	}
	

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
