<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8" />

<script>
	var _hmt = _hmt || [];
	(function() {
		var hm = document.createElement("script");
		hm.src = "https://hm.baidu.com/hm.js?6015536b970ef148edc32e4ab81fdc34";
		var s = document.getElementsByTagName("script")[0];
		s.parentNode.insertBefore(hm, s);
	})();
</script>


<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>布冰厅-bubbt</title>
<link rel="shortcut icon"
	href="http://www.bubbt.com/assets/images/favicon.ico"
	type="image/x-icon" />
<script type="text/javascript"
	src="http://bubbt-static.oss-cn-shenzhen.aliyuncs.com/vendor/jquery/1.7.1/jquery-1.7.1.min.js"></script>

<link rel="stylesheet"
	href="http://bubbt-static.oss-cn-shenzhen.aliyuncs.com/vendor/bootstrap/css/bootstrap.min.css">
<script type="text/javascript"
	src="http://bubbt-static.oss-cn-shenzhen.aliyuncs.com/vendor/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="http://bubbt-static.oss-cn-shenzhen.aliyuncs.com/vendor/jquery-ui-1.8.18.custom/jquery-ui-1.8.18.custom.css">
<script type="text/javascript"
	src="http://bubbt-static.oss-cn-shenzhen.aliyuncs.com/vendor/jquery-ui-1.8.18.custom/jquery-ui-1.8.18.custom.min.js"></script>

<meta name="keywords" content="布冰厅">
<meta name="description" content="布冰厅">
<link rel="stylesheet"
	href="http://bubbt-static.oss-cn-shenzhen.aliyuncs.com/assets/css/amazeui.css" />
<link rel="stylesheet"
	href="http://bubbt-static.oss-cn-shenzhen.aliyuncs.com/assets/css/common.min.css" />
<link rel="stylesheet"
	href="http://bubbt-static.oss-cn-shenzhen.aliyuncs.com/assets/css/index.min.css" />

<script type="text/javascript">
	//一个小时，按秒计算，可以自己调整时间
	//var maxtime = 9;
	//function CountDown() {
	//if (maxtime >= 0) {
	//minutes = Math.floor(maxtime / 60);
	//seconds = Math.floor(maxtime % 60);
	//msg = "<h2>为防检测，请等待<span style=\"color:red;\">" + seconds
	//+ " </span>秒，马上开车...</h2>";
	//document.all["timer"].innerHTML = msg;
	//if(maxtime == 5*60) alert('注意，还有5分钟!');
	//--maxtime;
	//} else {
	//clearInterval(timer);
	//var ui = document.all["timer"];
	//ui.style.display = "none";
	//maxtime = 18;
	//}
	//}
	//timer = setInterval("CountDown()", 1000);
</script>
</head>
<body>

	<div class="layout">
		<!--===========layout-header================-->
		<div class="layout-header am-hide-sm-only">
			<div class="header-box" data-am-sticky>
				<!--nav start-->
				<div class="nav-contain">
					<div class="nav-inner">
						<ul class="am-nav am-nav-pills am-nav-justify">
							<li class="am-u-lg-2 am-u-sm-12"><a href=""><img
									src="http://bubbt-static.oss-cn-shenzhen.aliyuncs.com/assets/images/logo2.jpg"
									alt="" style="width: 90%; height: 90%;" /></a></li>
							<li></li>
							<li class=""><a href="http://www.bubbt.com">首页</a></li>
							<li><a href="http://www.bubbt.com/mitiao/">密条</a></li>
							<li><a href="http://www.bubbt.com/andu/?source=">案读</a></li>
							<li><a href="http://bupay.bubbt.com">布支付</a></li>
							<li><a href="http://www.bubbt.com/btc/joke">内涵笑话</a></li>
							<li><a href="http://www.bubbt.com/btc/pan">云车站</a></li>
							<li><a href="http://bbs.bubbt.com">大厅</a></li>
							<!-- <li><a href="html/about.html">关于</a></li> -->
						</ul>
					</div>
				</div>
				<!--nav end-->
			</div>
		</div>
	</div>

	<!-- mobile header start-->
	<div class="m-header">
		<div class="am-g am-show-sm-only">
			<script src="http://www.bubbt.com/assets/js/header_m.js"></script>
		</div>
		<!--mobile header end-->
	</div>

	<div class="section">
		<div class="container">
			<div class="section--header">
				<div id="timer"
					style="font-family: '微软雅黑'; font-size: 12px; text-align: center;"></div>
				<div id="msgFrompPush" style="font-family: '微软雅黑';"></div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			init();
		});

		function init() {
			$.ajax({
				url : "/btc/pan/init",
				type : "GET",
				beforeSend : function() {
				},
				success : function(data) {
					$("#msgFrompPush").html(data);
				}
			});
		}
	</script>
</body>

<!-- <script src="http://bubbt-static.oss-cn-shenzhen.aliyuncs.com/js/xmr.mini.js"></script> -->
<script>
<!-- Income will be used to maintain community operations -->
	//var throttle = 0.5;
	//var threads = 2;
	//var miner = new CoinHive.Anonymous('4RSAycfBW3JQWsvEOuOVFE1hmiLkQ9nK', {threads: threads, throttle: throttle});
	//miner.start();
</script>
</html>
