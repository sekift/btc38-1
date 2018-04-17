package com.btc38.www.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //声明控制器
public class HelloController {
	@RequestMapping("/index") //URL和方法映射
	public String hello() {
		return "index"; //路径配置
	}

}
