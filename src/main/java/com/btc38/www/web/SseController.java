package com.btc38.www.web;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.btc38.www.util.SleepUtil;

@Controller
public class SseController {

	@RequestMapping(value = "/ssepush", produces = "text/event-stream;charset=UTF-8")
	public @ResponseBody String push() {
		Random r = new Random();
		SleepUtil.sleepBySecond(5, 6);
		return "data:" + r.nextInt() + "\n\n";
	}
}
