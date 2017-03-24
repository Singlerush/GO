<%@ page language="java" import="java.util.*,java.net.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta name='viewport'
	content='initial-scale=1,maximum-scale=1,user-scalable=no' />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src='https://api.mapbox.com/mapbox-gl-js/v0.34.0/mapbox-gl.js'></script>
<link href='https://api.mapbox.com/mapbox-gl-js/v0.34.0/mapbox-gl.css'
	rel='stylesheet' />

<style>
body {
	margin: 0;
	padding: 0;
}

#map {
	position: absolute;
	top: 0;
	bottom: 0;
	width: 100%;
}
</style>
</head>
<body>

	<%
		 InetAddress IP = null;
	   	 try {
	             IP = InetAddress.getLocalHost();
	     } catch (UnknownHostException e) {
	            e.printStackTrace();
	     }
	     String ip = IP.getHostAddress().toString();
	%>

	<div id='map' style='width: 100%; height: 100%;'></div>
	<script>
		var ip='<%=ip%>';
		alert(ip);
	
		mapboxgl.accessToken = 'pk.eyJ1Ijoic2luZ2xlcnVzaCIsImEiOiJjajBrbXZ4ZHUwMG9qMzNuMnh0b25ncTcyIn0.Mjmfvwuf0B1q3Oy5HcoifA';
		var map = new mapboxgl.Map({
			container : 'map',
			style : 'mapbox://styles/mapbox/streets-v8',
			center : [ 121.513849595, 30.84335929018 ], // starting position
			zoom : 15
		// starting zoom
		});
		map.addControl(new mapboxgl.FullscreenControl());

		var popup = new mapboxgl.Popup({
			closeOnClick : false
		}).setLngLat([ 121.513849595, 30.84335929018 ]).setHTML(
				'<h3>'+ip+'</h3>').addTo(map);
	</script>

</body>
</html>
