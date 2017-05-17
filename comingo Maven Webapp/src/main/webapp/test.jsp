<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="com.comingo.util.JavaMail" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>Mail Test</title>
  </head>
  <body>
	<%
		Map<String,String> map= new HashMap<String,String>();
		JavaMail mail = new JavaMail();
		map.put("mail.smtp.host", "smtp.qq.com");
		map.put("mail.smtp.auth", "true");
        map.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        map.put("mail.smtp.port", "465");
        map.put("mail.smtp.socketFactory.port", "465");
        mail.setPros(map);
        mail.initMessage();
        mail.setDefaultMessagePros("哈哈哈", "760184287@qq.com");
		try{
			mail.sendMessage();
		}catch(Exception e){
			e.printStackTrace();
			out.println("出错了");
		}
	%>
  </body>
</html>
