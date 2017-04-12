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
<title></title>
<meta name='viewport'
	content='initial-scale=1,maximum-scale=1,user-scalable=no' />
<script
	src='https://api.tiles.mapbox.com/mapbox-gl-js/v0.34.0/mapbox-gl.js'></script>
<link
	href='https://api.tiles.mapbox.com/mapbox-gl-js/v0.34.0/mapbox-gl.css'
	rel='stylesheet' />
<link type="text/css" href='css/common-c43e2e93f4.css' rel='stylesheet	' />

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
	z-index: -1
}
</style>
</head>
<body>

	<div class="keep-header">
		<nav class="nav-wrapper-pc-wider">
			<div class="head-left">
				<a href="/"> <img
					src="//staticssl.keepcdn.com/show/images/logo-16fc21eba7.png"></a>
			</div>
			<div class="head-right">
				<div class="nav-pc">
					<a href="/explore">发现精选</a><a href="/training">课程内容</a><a
						href="javascript:;" class="keep-login-trigger"><i
						class="keep-icon-user"></i><span>登录</span></a>
				</div>
				<div class="social-media">
					<a href="javascript:;" class="wechat-link"><i
						class="keep-icon-wechat"></i>
					<div class="wechat-qr">
							<img
								src="//staticssl.keepcdn.com/show/images/wechat-qr-429ecdac26.jpg">
						</div></a><a href="http://weibo.com/p/1006065342268417/home" target="_blank"><i
						class="keep-icon-weibo"></i></a><a href="https://twitter.com/keephq"
						target="_blank"><i class="keep-icon-twitter"></i></a><a
						href="https://instagram.com/keep_app" target="_blank"><i
						class="keep-icon-instagram"></i></a>
				</div>
			</div>
		</nav>
		<nav class="nav-wrapper-phone">
			<div class="phone-head">
				<a href="/"><img
					src="//staticssl.keepcdn.com/show/images/phonelogo-b3150ff135.png"
					class="img"></a>
				<div id="header-tab-expand" class="act-tab keep-icon-menu"></div>
				<div id="header-tab-close" class="act-tab keep-icon-close"></div>
			</div>
			<div class="phone-tabs-wrap">
				<div class="login">
					<div class="user-avatar keep-login-trigger">
						<i class="keep-icon-user"></i>
					</div>
					<p class="keep-login-trigger">登录</p>
				</div>
				<div>
					<a href="/" class="link">首页</a><a href="/explore" class="link">发现精选</a><a
						href="/training" class="link">课程内容</a>
				</div>
			</div>
		</nav>
	</div>

	<style>
.marker {
	display: block;
	border: none;
	border-radius: 50%;
	cursor: pointer;
	padding: 0;
}
</style>

<script type="text/javascript"
		src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	
	<div id='map'></div>
	<script>
		mapboxgl.accessToken = 'pk.eyJ1Ijoic2luZ2xlcnVzaCIsImEiOiJjajBrbXZ4ZHUwMG9qMzNuMnh0b25ncTcyIn0.Mjmfvwuf0B1q3Oy5HcoifA';
		var geojson = {
			"type" : "FeatureCollection",
			"features" : [ {
				"type" : "Feature",
				"properties" : {
					"message" : "Foo",
					"iconSize" : [ 60, 60 ]
				},
				"geometry" : {
					"type" : "Point",
					"coordinates" : [ -66.324462890625, -16.024695711685304 ]
				}
			}, {
				"type" : "Feature",
				"properties" : {
					"message" : "Bar",
					"iconSize" : [ 50, 50 ]
				},
				"geometry" : {
					"type" : "Point",
					"coordinates" : [ -61.2158203125, -15.97189158092897 ]
				}
			}, {
				"type" : "Feature",
				"properties" : {
					"message" : "Baz",
					"iconSize" : [ 40, 40 ]
				},
				"geometry" : {
					"type" : "Point",
					"coordinates" : [ -63.29223632812499, -18.28151823530889 ]
				}
			} ]
		};

		var map = new mapboxgl.Map({
			container : 'map',
			style : 'mapbox://styles/mapbox/streets-v9',
			center : [ -65.017, -16.457 ],
			zoom : 5
		});

		// add markers to map
		geojson.features.forEach(function(marker) {
			// create a DOM element for the marker
			var el = document.createElement('div');
			el.className = 'marker';
			el.style.backgroundImage = 'url(https://placekitten.com/g/'
					+ marker.properties.iconSize.join('/') + '/)';
			el.style.width = marker.properties.iconSize[0] + 'px';
			el.style.height = marker.properties.iconSize[1] + 'px';

			el.addEventListener('click', function() {
				document.getElementById("username").innerHTML = "username: "
						+ marker.properties.message;
			});

			// add marker to map
			new mapboxgl.Marker(el, {
				offset : [ -marker.properties.iconSize[0] / 2,
						-marker.properties.iconSize[1] / 2 ]
			}).setLngLat(marker.geometry.coordinates).addTo(map);
		});
	</script>

</body>
</html>