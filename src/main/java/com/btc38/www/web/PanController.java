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

	/*private static List<String> fileList = new ArrayList<String>(50);
	static {
		try {
			fileList = FileUtils.readLines(new File("/www/client/monitor_crawler/link.txt"), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

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
		
		List<String> fileList = new ArrayList<String>(50);
		try {
			fileList = FileUtils.readLines(new File("/www/client/monitor_crawler/link.txt"), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		double iTotalScore = 0.00;
		double iScore = 0.00;
		double iValue = 0.00;
		
		double lv = 0.0445;
		int i = 0;
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
					iTotalScore += totalScore;
					iScore += (double) data.get("score");
					iValue += (double) data.get("estimateValue");
					
					sb
					.append("<th>").append(i+=1).append("</th>")
					.append("<th>").append(id).append("</th>")
					.append("<th>").append(totalScore).append("</th>")
					.append("<th>").append(data.get("score")).append("</th>")
					.append("<th>").append(data.get("estimateValue")).append("</th>")
					.append("<th>").append(name).append("</th>")
					.append("<th>").append(mobile).append("</th>")
					.append("<th>").append(card).append("</th>");

					resultSrc = resultSrc + "<tr>" + sb.toString() +"</tr>";
				}
			}
			SleepUtil.sleepByMilliSecond(10, 16);
		}
		iTotalScore = new BigDecimal(iTotalScore).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();;
		iScore = new BigDecimal(iScore).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		iValue = new BigDecimal(iValue).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		
		resultSrc = "<table width=\"400\" border=\"1\">"
		          + "<tr>"
		          + "<th>序</th>"
		          + "<th>总分</th>"
		          + "<th>"+iTotalScore+"</th>"
		          + "<th>"+iScore+"</th>"
		          + "<th>"+iValue+"</th>"
		          + "<th>"+new BigDecimal(iTotalScore*lv).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()+"</th>"
		          + "<th>"+new BigDecimal(iScore*lv).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()+"</th>"
		          + "<th>"+new BigDecimal(iValue*lv).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()+"</th>"
		          + "</tr>"
				  + resultSrc;
		resultSrc = resultSrc+"</table>";
		return resultSrc;
	}
	
	public static void main(String args[]){
		PanController pc = new PanController();
		System.out.println(pc.init());
	}

}
