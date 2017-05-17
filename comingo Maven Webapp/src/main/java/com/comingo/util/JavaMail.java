package com.comingo.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMail {
	private String username = "372958366@qq.com";
	private String password = "roglmrxgqnkgcafb";
	private Authenticator auth = null;
	private MimeMessage mimeMessage = null;
	private Properties pros = null;

	/**
	 * 初始化账号密码并验证 创建MimeMessage对象 发送邮件必须的步骤:1
	 * 
	 */
	public JavaMail() {
	}

	/**
	 * 初始化MimeMessage对象 发送邮件必须的步骤:3
	 */
	public void initMessage() {
		this.auth = new Email_Autherticator();
		Session session = Session.getDefaultInstance(pros, auth);
		session.setDebug(true); // 设置获取 debug 信息
		mimeMessage = new MimeMessage(session);
	}

	/**
	 * 设置email系统参数 接收一个map集合key为string类型，值为String 发送邮件必须的步骤:2
	 * 
	 * @param map
	 */
	public void setPros(Map<String, String> map) {
		pros = new Properties();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			pros.setProperty(entry.getKey(), entry.getValue());
		}
	}

	/**
	 * 验证账号密码 发送邮件必须的步骤
	 * 
	 * @author Administrator
	 * 
	 */
	public class Email_Autherticator extends Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	}

	/**
	 * 设置发送邮件的基本参数(去除繁琐的邮件设置)
	 * 
	 * @param sub
	 *            设置邮件主题
	 * @param text
	 *            设置邮件文本内容
	 * @param rec
	 *            设置邮件接收人
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public void setDefaultMessagePros(String text, String rec)
			throws MessagingException, UnsupportedEncodingException {
		mimeMessage.setSubject("GO 组织用户激活");
		mimeMessage.setText(text);
		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(
				rec));
		mimeMessage.setSentDate(new Date());
		mimeMessage.setFrom(new InternetAddress(username, username));
	}

	/**
	 * 设置邮件头部
	 * 
	 * @param arg0
	 * @param arg1
	 * @throws MessagingException
	 */
	public void setHeader(String arg0, String arg1) throws MessagingException {
		mimeMessage.setHeader(arg0, arg1);
	}

	/**
	 * 发送邮件<单人发送> return 是否发送成功
	 * 
	 * @throws MessagingException
	 */
	public String sendMessage() throws MessagingException {
		Transport.send(mimeMessage);
		return "success";
	}
}
