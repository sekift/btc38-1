package com.btc38.www.web;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.btc38.www.util.SleepUtil;

@Controller
public class BtcController {
	boolean flag = false;

	@RequestMapping(value = "/push", produces = "text/event-stream;charset=UTF-8")
	public @ResponseBody String push() {
		if (flag) {
			SleepUtil.sleepBySecond(10, 10);
		}
		String resultSrc = null;
		try {
			resultSrc = FileUtils.readFileToString(new File("/www/client/monitor_crawler/btc.txt"), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		flag = true;
		return "data:" + resultSrc + "\n\n";
	}
}