package com.btc38.www.web;

import com.btc38.www.service.GetURLContent;
import com.btc38.www.util.JsonUtil;
import com.btc38.www.util.SleepUtil;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({ "/pan" })
public class PanController {
	boolean flag = false;
	// 链接
	private static final String TYT_URL = "http://tyt.tianya.cn/reward/getUserScore.do?userId=";

	// 首次引入
	private static List<String> fileList = new ArrayList<String>(50);
	static {
		try {
			fileList = FileUtils.readLines(new File("/www/client/monitor_crawler/link.txt"), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
		String resultSrc = "";
		for (String str : fileList) {
			String id = str.split("\t")[0];
			String name = str.split("\t")[1];
			String mobile = str.split("\t")[2];
			String card = str.split("\t")[3];

			String doc = GetURLContent.getPageContent(TYT_URL + id);
			if (doc != null) {
				Map result = JsonUtil.toBean(doc, Map.class);
				if (result != null) {
					StringBuilder sb = new StringBuilder();
					Map data = (Map) result.get("data");
					double total = (double) data.get("score") + (double) data.get("estimateValue");
					double totalScore = new BigDecimal(total).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
					sb.append(id).append("\t")
					        .append(totalScore).append("|")
					        .append(data.get("score")).append("|")
							.append(data.get("estimateValue")).append("\t")
							.append(name).append("\t")
							.append(mobile).append("\t").append(card);

					resultSrc = resultSrc + "<p>" + sb.toString() +"</p>";
				}
			}
			SleepUtil.sleepByMilliSecond(30, 50);
		}
		return resultSrc;
	}
	
	public static void main(String args[]){
		PanController pc = new PanController();
		System.out.println(pc.init());
	}

}
