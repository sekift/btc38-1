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
<title>内涵笑话</title>
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

<meta name="keywords" content="内涵笑话，免刷新爆笑">
<meta name="description" content="内涵笑话，免刷新爆笑">
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
			msg = "<h3>距离下一条爆笑还剩 <span style=\"color:red;\">" + seconds
					+ " </span>秒...</h3>";
			document.all["timer"].innerHTML = msg;
			//if(maxtime == 5*60) alert('注意，还有5分钟!');
			--maxtime;
		} else {
			//clearInterval(timer);
			//var ui = document.all["timer"];
			//ui.style.display = "none";
			maxtime = 13;
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

	<!--<div class="section">-->
		<div class="container">
			<div class="section--header">
				<div 
					style="font-family: '微软雅黑'; font-size: 10px; text-align: center;">
					请使用Firefox或Chrome等高级浏览器<br />
					本页面大约每10秒会自动增加一条笑话，无需手动刷新！
				</div>
				<div id="timer"
					style="font-family: '微软雅黑'; font-size: 12px; text-align: center;"></div>
				<div  id="msgFrompPush" style="font-family: '微软雅黑';"></div>
				<div id="text" style="font-family: '微软雅黑';">
					<table class="table table-condensed">
						<tbody>
							<tr>
								<td>[置顶]-内涵指数[46519]<br />和相处了五年的女朋友订婚了，准备年底结婚，谈了一上午刚从丈母娘家出来，最后以925.9一斤的价格成交。。。</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div id="text" style="font-family: '微软雅黑';">
					<table class="table table-condensed">
						<tbody>
							<tr>
								<td>[置顶]-内涵指数[72]<br />去上厕所时，看到厕所门上只标一NC的缩写，同去的英语达人曰：NC就是男厕嘛。于是豁然开朗，进，脱，蹲，一气呵成，忽灵光一闪，女厕的缩写是什么来着。</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	<!-- </div> -->


	<script type="text/javascript">
		if (!!window.EventSource) {
			var source = new EventSource('ttpush');
			s = '';
			source.addEventListener('message', function(e) {
				s = e.data + s;
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
</body>
</html>
