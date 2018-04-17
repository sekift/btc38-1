package com.btc38.www.web;

import com.btc38.www.util.SleepUtil;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({ "/pan" })
public class PanController {
	boolean flag = false;

	@RequestMapping(value = { "/tbpush" }, produces = { "text/event-stream;charset=UTF-8" })
	@ResponseBody
	public String push() {
		if (this.flag) {
			SleepUtil.sleepByMilliSecond(20950, 20950);
		}
		String resultSrc = "【暂时没有，请耐心等候或联系管理员。】";
		try {
			resultSrc = FileUtils.readFileToString(new File("/www/client/monitor_crawler/link.txt"), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.flag = true;
		return "data:" + resultSrc + "\n\n";
	}

	@RequestMapping(value = { "/init" }, method = { RequestMethod.GET }, produces = { "text/html;charset=UTF-8" })
	@ResponseBody
	public String init() {
		String resultSrc = "【暂时没有，请耐心等候或联系管理员。】";
		try {
			resultSrc = FileUtils.readFileToString(new File("/www/client/monitor_crawler/link.txt"), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultSrc;
	}
}
