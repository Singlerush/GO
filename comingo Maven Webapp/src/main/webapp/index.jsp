<%@ page language="java" import="java.util.*,java.net.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset='utf-8' />
<title>GO API</title>
</head>
<body>
<h1>GO API</h1>
<hr>
</body>
</html>