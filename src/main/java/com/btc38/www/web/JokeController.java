package com.btc38.www.web;

import com.btc38.www.util.SleepUtil;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JokeController {
	boolean flag = false;

	@RequestMapping(value = { "/ttpush" }, produces = { "text/event-stream;charset=UTF-8" })
	@ResponseBody
	public String push() {
		if (this.flag) {
			SleepUtil.sleepByMilliSecond(9950, 9950);
		}
		String resultSrc = null;
		try {
			resultSrc = FileUtils.readFileToString(new File("/www/client/monitor_crawler/joke.txt"), "UTF-8");
			System.out.println(resultSrc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.flag = true;
		return "data:" + resultSrc + "\n\n";
	}
}
