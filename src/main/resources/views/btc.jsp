<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8" />
<title>比特币：比特币策略</title>

<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?6015536b970ef148edc32e4ab81fdc34";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>


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

<meta name="keywords" content="比特币，股票投资策略">
<meta name="description" content="比特币，股票投资策略">
<link rel="stylesheet"
	href="http://bubbt-static.oss-cn-shenzhen.aliyuncs.com/assets/css/amazeui.css" />
<link rel="stylesheet"
	href="http://bubbt-static.oss-cn-shenzhen.aliyuncs.com/assets/css/common.min.css" />
<link rel="stylesheet"
	href="http://bubbt-static.oss-cn-shenzhen.aliyuncs.com/assets/css/index.min.css" />

<script type="text/javascript">
	//一个小时，按秒计算，可以自己调整时间
	var maxtime = 8;
	function CountDown() {
		if (maxtime >= 0) {
			minutes = Math.floor(maxtime / 60);
			seconds = Math.floor(maxtime % 60);
			msg = "<h1>请等待 <span style=\"color:red;\">" + seconds
					+ " </span>秒,精彩即将呈现...</h1>";
			document.all["timer"].innerHTML = msg;
			//if(maxtime == 5*60) alert('注意，还有5分钟!');
			--maxtime;
		} else {
			clearInterval(timer);
			var ui = document.all["timer"];
			ui.style.display = "none";
		}
	}
	timer = setInterval("CountDown()", 1000);
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
							<li><a href="http://www.bubbt.com/btc/btc">比特币</a></li>
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

<!--mobile header start
    <div class="m-header">
      <div class="am-g am-show-sm-only">
        <script src="http://www.bubbt.com/assets/js/header_m.js"></script>
      </div>-->
    <!--mobile header end-->
    <!--</div>-->

	<div style="font-family: '微软雅黑'; font-size: 16px; text-align: center;">
                著名的BTC交易平台：<a href="http://www.btc38.com/" target="_blank">比特时代</a>&nbsp;&nbsp;<a href="https://www.huobi.com/" target="_blank">火币网</a>&nbsp;&nbsp;<a href="http://www.okcoin.cn/" target="_blank">okcoin</a>&nbsp;&nbsp;<a href="http://www.btctrade.com/" target="_blank">BTCTrade</a>&nbsp;&nbsp;<a href="http://www.btcchina.com/" target="_blank">比特币中国</a>&nbsp;&nbsp;<a href="https://www.bitstamp.net/" target="_blank">Bitstamp</a>&nbsp;&nbsp;<a href="https://www.btc-e.com/" target="_blank">BTC-E</a><br />
                访问本页面请使用高级浏览器，例如Firefox或Chrome，切勿使用IE等低端浏览器！本站策略地址：<a href="http://bbs.bubbt.com/symphony/article/1495550617662" target="_blank">监控策略</a><br />
		由于抓取需要时间（间隔为2-3分钟），同时本页面每10秒会自动加载数据，无需手动刷新！</div>
	<div id="timer"
		style="font-family: '微软雅黑'; font-size: 16px; text-align: center;"></div>
	<div id="msgFrompPush" style="font-family: '微软雅黑';"></div>
	

<script type="text/javascript">
		if (!!window.EventSource) {
			var source = new EventSource('push');
			s = '';
			source.addEventListener('message', function(e) {
				s = e.data + "<br/>";
				$("#msgFrompPush").html(s);
			});

			source.addEventListener('open', function(e) {
				console.log("连接打开.");
			}, false);

			source.addEventListener('error', function(e) {
				if (e.readyState == EventSource.CLOSED) {
					console.log("连接关闭");
				} else {
					console.log(e);
					console.log(e.readyState);
				}

			}, false);
		} else {
                        alert("你的浏览器不支持sse，请换Chrome或Firefox！");
			console.log("你的浏览器不支持sse");
		}
	</script>
<%-- <script type="text/javascript" src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script> --%>
</body>
</html>
