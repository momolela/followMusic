/**   
 * @Title: SendMail.java  
 * @Package com.momolela.util  
 * @Description: TODO  
 * @author momolela   
 * @date 2016-5-30 下午10:33:11  
 * @version V1.0   
 */
package com.momolela.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import com.momolela.model.MyAuthenticator;
// import com.momolela.model.User;
// import com.opensymphony.xwork2.ActionContext;
import com.momolela.model.User;

/**
 * @ClassName: SendMail
 * @Description: 
 * @author: momolela
 * @date 2016-5-30 下午10:33:11
 * 
 */
public class SendMail implements Runnable{

	private User user;
	public void setUser(User u){
		this.user = u;
	}
	public void run() {
		Properties props = new Properties();
		props.setProperty("mail.smtp.host", "smtp.qq.com");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");

		String userName = "1083910359@qq.com";
		String emailpassword = "hfy520szj@";
		Authenticator authenticator = new MyAuthenticator(userName,
				emailpassword);

		javax.mail.Session session = javax.mail.Session.getDefaultInstance(
				props, authenticator);
		//session.setDebug(true);//可以从控制台看到信息

		try {
			Address from = new InternetAddress(userName);
			Address to = new InternetAddress(user.getEmail());

			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(from);
			msg.setSubject("follow音乐网注册邮件");
			msg.setSentDate(new Date());
			msg.setContent("恭喜您已经成功注册成为follow音乐的一员，你的账号是:" + user.getUsername()
					+ "\t你的密码为" + user.getPassword()
					+ "请妥善保管，忘记密码请联系管理员。QQ:1278413504",
					"text/html;charset=utf-8");
			msg.setRecipient(RecipientType.TO, to);
			Transport.send(msg);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
