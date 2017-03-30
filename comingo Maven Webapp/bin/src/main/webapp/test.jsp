<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/insert.action" method="post">
    	用户名：<input type="text" name="username" /><br>
    	备注：<input type="text" name="remark" /><br>
    	<input type="submit" value="保存" />
    </form>
    <hr/>
    <form action="${pageContext.request.contextPath}/Find.action"method="post">
    </form>
    <hr/>
    <form action="${pageContext.request.contextPath}/delete.action"></form>
  </body>
</html>
