<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8" />
  <title>比特币：比特币策略</title>
  <link rel="shortcut icon" href="http://www.bubbt.com/assets/images/favicon.ico" type="image/x-icon" />
  <script type="text/javascript" src="http://bubbt-static.oss-cn-shenzhen.aliyuncs.com/vendor/jquery/1.7.1/jquery-1.7.1.min.js"></script>

  <link rel="stylesheet" href="http://bubbt-static.oss-cn-shenzhen.aliyuncs.com/vendor/bootstrap/css/bootstrap.min.css">
  <script type="text/javascript" src="http://bubbt-static.oss-cn-shenzhen.aliyuncs.com/vendor/bootstrap/js/bootstrap.min.js"></script>  

  <link rel="stylesheet" href="http://bubbt-static.oss-cn-shenzhen.aliyuncs.com/vendor/jquery-ui-1.8.18.custom/jquery-ui-1.8.18.custom.css">
  <script type="text/javascript" src="http://bubbt-static.oss-cn-shenzhen.aliyuncs.com/vendor/jquery-ui-1.8.18.custom/jquery-ui-1.8.18.custom.min.js"></script>

  <meta name="keywords" content="比特币，股票投资策略">
    <meta name="description" content="比特币，股票投资策略">
    <link rel="stylesheet" href="http://bubbt-static.oss-cn-shenzhen.aliyuncs.com/assets/css/amazeui.css" />
    <link rel="stylesheet" href="http://bubbt-static.oss-cn-shenzhen.aliyuncs.com/assets/css/common.min.css" />
    <link rel="stylesheet" href="http://bubbt-static.oss-cn-shenzhen.aliyuncs.com/assets/css/index.min.css" />
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
                    <li class="am-u-lg-2 am-u-sm-12"><a href=""><img src="http://bubbt-static.oss-cn-shenzhen.aliyuncs.com/assets/images/logo2.jpg" alt="" style="width:90%;height:90%;"/></a></li>
                    <li></li>
                    <li class=""><a href="http://www.bubbt.com">首页</a></li>
                    <li><a href="http://www.bubbt.com/mitiao/">密条</a></li>
                    <li><a href="http://www.bubbt.com/andu/?source=">案读</a></li>
                    <li><a href="http://www.bubbt.com/btc/btc">比特币</a></li>
                    <li><a href="#">句读</a></li>
                    <li><a href="#">博客</a></li>
                    <!-- <li><a href="html/about.html">关于</a></li> -->
                    </ul>
                </div>
            </div>
            <!--nav end-->
        </div>
    </div>
</div>

	<div style="font-family:'微软雅黑';font-size:16px;text-align:center;">
	    由于抓取需要时间（间隔为3-4分钟），本页面每10秒会自动加载数据，请勿自动刷新！
	</div>
	<div id="msgFrompPush" style="font-family:'微软雅黑';"></div>
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
			console.log("你的浏览器不支持sse");
		}
	</script>
</body>
</html>