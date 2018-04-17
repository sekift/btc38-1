package com.btc38.www.service;

import java.net.URL;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.btc38.www.util.DateUtil;
import com.btc38.www.util.JsonUtil;
import com.btc38.www.util.SleepUtil;

/**
 * 
 * @author:sekift
 * @time:2015-2-6 上午11:29:58
 * @version:
 */
public class Btc38  implements Runnable{ 
	private static final Logger logger = LoggerFactory.getLogger(Btc38.class);

	private static List<String> siteList = new ArrayList<String>();
	private static List<String> currentSiteList = new ArrayList<String>();
	private static Map<String, String> nameMap = new HashMap<String, String>();
	private static Map<String, Integer> volumnMap = new HashMap<String, Integer>();

	private static List<List<Object>> result = new ArrayList<List<Object>>();
	
	public String resultString = "";
	public boolean flag = false;

	static {
		getSiteList();
		getNameMap();
		getVolumnMap();
		getCurrentSiteList();
	}

	// 5 分钟线数据
	private static void getSiteList() {
		siteList.add("http://www.btc38.com/trade/getTrade5minLine.php?coinname=BTC&mk_type=CNY&n=");// MGC
		siteList.add("http://www.btc38.com/trade/getTrade5minLine.php?coinname=LTC&mk_type=CNY&n=");// MGC
		siteList.add("http://www.btc38.com/trade/getTrade5minLine.php?coinname=DOGE&mk_type=CNY&n=");// MGC
		siteList.add("http://www.btc38.com/trade/getTrade5minLine.php?coinname=XRP&mk_type=CNY&n=");// MGC
		siteList.add("http://www.btc38.com/trade/getTrade5minLine.php?coinname=MGC&mk_type=CNY&n=");// MGC
		siteList.add("http://www.btc38.com/trade/getTrade5minLine.php?coinname=NXT&mk_type=CNY&n=");// MGC
		siteList.add("http://www.btc38.com/trade/getTrade5minLine.php?coinname=XEM&mk_type=CNY&n=");// MGC
		siteList.add("http://www.btc38.com/trade/getTrade5minLine.php?coinname=EMC&mk_type=CNY&n=");// MGC
		siteList.add("http://www.btc38.com/trade/getTrade5minLine.php?coinname=XPM&mk_type=CNY&n=");// MGC
		siteList.add("http://www.btc38.com/trade/getTrade5minLine.php?coinname=MEC&mk_type=CNY&n=");// MGC
		siteList.add("http://www.btc38.com/trade/getTrade5minLine.php?coinname=RIC&mk_type=CNY&n=");// MGC
		// TODO 在这里添加适当合法的网址(下面需要对称)，网址后面需要加一个随机数&n=0.6520274267802858
	}

	// 当前价格数据
	private static void getCurrentSiteList() {
		currentSiteList.add("http://www.btc38.com/trade/getTradeList30.php?coinname=BTC&mk_type=CNY&n=");
		currentSiteList.add("http://www.btc38.com/trade/getTradeList30.php?coinname=LTC&mk_type=CNY&n=");
		currentSiteList.add("http://www.btc38.com/trade/getTradeList30.php?coinname=DOGE&mk_type=CNY&n=");
		currentSiteList.add("http://www.btc38.com/trade/getTradeList30.php?coinname=XRP&mk_type=CNY&n=");
		currentSiteList.add("http://www.btc38.com/trade/getTradeList30.php?coinname=MGC&mk_type=CNY&n=");
		currentSiteList.add("http://www.btc38.com/trade/getTradeList30.php?coinname=NXT&mk_type=CNY&n=");
		currentSiteList.add("http://www.btc38.com/trade/getTradeList30.php?coinname=XEM&mk_type=CNY&n=");
		currentSiteList.add("http://www.btc38.com/trade/getTradeList30.php?coinname=EMC&mk_type=CNY&n=");
		currentSiteList.add("http://www.btc38.com/trade/getTradeList30.php?coinname=XPM&mk_type=CNY&n=");
		currentSiteList.add("http://www.btc38.com/trade/getTradeList30.php?coinname=MEC&mk_type=CNY&n=");
		currentSiteList.add("http://www.btc38.com/trade/getTradeList30.php?coinname=RIC&mk_type=CNY&n=");
		// TODO 位置与上面对应
	}

	// 缩略和中文Map 27种
	private static void getNameMap() {
		nameMap.put("BTC", "比特币");
		nameMap.put("LTC", "莱特币");
		nameMap.put("DOGE", "狗狗币");
		nameMap.put("XRP", "瑞波币");
		nameMap.put("BTS", "比特股");
		nameMap.put("XLM", "恒星币");
		nameMap.put("NXT", "未来币");
		nameMap.put("BLK", "黑币");
		nameMap.put("XEM", "新经币");
		nameMap.put("EMC", "崛起币");
		nameMap.put("DASH", "达世币");
		nameMap.put("XZC", "零币");
		nameMap.put("VASH", "微币");
		nameMap.put("PPC", "点点币");
		nameMap.put("MGC", "合众币");
		nameMap.put("ZCC", "招财币");
		nameMap.put("XPM", "质数币");
		nameMap.put("YBC", "元宝币");
		nameMap.put("HLB", "活力币");
		nameMap.put("NCS", "资产股");
		nameMap.put("BOST", "增长币");
		nameMap.put("MEC", "美卡币");
		nameMap.put("DGC", "数码币");
		nameMap.put("BEC", "比奥币");
		nameMap.put("RIC", "黎曼币");
		nameMap.put("SRC", "安全币");
		nameMap.put("TAG", "悬赏币");
	}

	// 缩略和中文Map 27种
	private static void getVolumnMap() {
		volumnMap.put("BTC", 12);
		volumnMap.put("LTC", 250);
		volumnMap.put("DOGE", 50000000);
		volumnMap.put("XRP", 600000);
		volumnMap.put("BTS", 1200000);
		volumnMap.put("XLM", 2500000);
		volumnMap.put("NXT", 1000000);
		volumnMap.put("BLK", 20000);
		volumnMap.put("XEM", 120000);
		volumnMap.put("EMC", 7500);
		volumnMap.put("DASH", 125);
		volumnMap.put("XZC", 2700);
		volumnMap.put("VASH", 200000);
		volumnMap.put("PPC", 4000);
		volumnMap.put("MGC", 150000);
		volumnMap.put("ZCC", 250000);
		volumnMap.put("XPM", 30000);
		volumnMap.put("YBC", 5000);
		volumnMap.put("HLB", 500000);
		volumnMap.put("NCS", 200000);
		volumnMap.put("BOST", 20000);
		volumnMap.put("MEC", 30000);
		volumnMap.put("DGC", 130000);
		volumnMap.put("BEC", 6000);
		volumnMap.put("RIC", 30000);
		volumnMap.put("SRC", 20000);
		volumnMap.put("TAG", 10000);
	}

	@Override
	public void run() {
		System.out.println("begin");
		flag = true;
		System.out.println(flag);
		Date date = null;
		Random rand = new Random();
		try {
			while (true) {
				date = new Date(System.currentTimeMillis());
				if (date.getHours() == 4) {
					SleepUtil.sleepByHour(7, 7);
				}
				for (int i = 0; i < siteList.size(); i++) {
					String site = siteList.get(i);
					System.out.println(site);
					String html = GetURLContent.getPageContent(site + rand.nextDouble());
					// logger.info("html" + html);
					ArrayList<ArrayList<Object>> htmlList = (ArrayList<ArrayList<Object>>) JsonUtil.toBean(html,
							List.class);
					ArrayList<Object> proList = (ArrayList<Object>) htmlList.get(htmlList.size() - 1);
					ArrayList<Object> preList = (ArrayList<Object>) htmlList.get(htmlList.size() - 2);

					// 转bean
					ContentVO vo1 = new ContentVO();
					ContentVO vo2 = new ContentVO();
					vo1.setTimestamp((Long) preList.get(0));
					if (preList.get(1) instanceof Integer) {
						vo1.setVolumn((Integer) preList.get(1));
					} else if (preList.get(1) instanceof Double) {
						vo1.setVolumn((Double) preList.get(1));
					}
					if (preList.get(2) instanceof Integer) {
						vo1.setBegin((Integer) preList.get(2));
					} else if (preList.get(2) instanceof Double) {
						vo1.setBegin((Double) preList.get(2));
					}
					if (preList.get(3) instanceof Integer) {
						vo1.setHight((Integer) preList.get(3));
					} else if (preList.get(3) instanceof Double) {
						vo1.setHight((Double) preList.get(3));
					}
					if (preList.get(4) instanceof Integer) {
						vo1.setLow((Integer) preList.get(4));
					} else if (preList.get(4) instanceof Double) {
						vo1.setLow((Double) preList.get(4));
					}
					if (preList.get(5) instanceof Integer) {
						vo1.setEnd((Integer) preList.get(5));
					} else if (preList.get(5) instanceof Double) {
						vo1.setEnd((Double) preList.get(5));
					}

					vo2.setTimestamp((Long) proList.get(0));
					if (proList.get(1) instanceof Integer) {
						vo2.setVolumn((Integer) proList.get(1));
					} else if (proList.get(1) instanceof Double) {
						vo2.setVolumn((Double) proList.get(1));
					}
					if (proList.get(2) instanceof Integer) {
						vo2.setBegin((Integer) proList.get(2));
					} else if (preList.get(2) instanceof Double) {
						vo2.setBegin((Double) proList.get(2));
					}
					if (proList.get(3) instanceof Integer) {
						vo2.setHight((Integer) proList.get(3));
					} else if (proList.get(3) instanceof Double) {
						vo2.setHight((Double) proList.get(3));
					}
					if (proList.get(4) instanceof Integer) {
						vo2.setLow((Integer) proList.get(4));
					} else if (preList.get(4) instanceof Double) {
						vo2.setLow((Double) proList.get(4));
					}
					if (proList.get(5) instanceof Integer) {
						vo2.setEnd((Integer) proList.get(5));
					} else if (proList.get(5) instanceof Double) {
						vo2.setEnd((Double) proList.get(5));
					}

					// System.out.println(vo1);
					// System.out.println(vo2);
					// 时间戳，交易量，开盘，最高，最低，收盘
					// 获取名称
					// System.out.println(nameMap.get(getCodeFromSite(site)));

					NumberFormat nf = NumberFormat.getInstance();
					// 成交量涨幅
					double valumnUp = ((vo2.getVolumn() - vo1.getVolumn()) / (vo1.getVolumn()) * 100.0);

					// 成交量与中位线比较
					double middle = ((vo2.getVolumn() / volumnMap.get(getCodeFromSite(site)) * 100.0));
					// System.out.println(nf.format(vo2.getVolumn()) + "(" +
					// nf.format(valumnUp) + "%,"
					// + nf.format(middle) + "%)");

					// 价格涨幅
					double priceUp = ((vo2.getEnd() - vo1.getEnd()) / (vo1.getEnd()) * 100.0);
					// System.out.println(nf.format(vo2.getEnd()) + "(" +
					// nf.format(priceUp) + "%)");

					// 当前价格
					String currentSite = currentSiteList.get(i);
					String currentHtml = GetURLContent.getPageContent(currentSite + rand.nextDouble());
					// System.out.println(currentHtml);
					// logger.info("currentHtml" + currentHtml);
					Map<String, List<List<Object>>> response = JsonUtil.toBean(currentHtml, Map.class);
					// 当前价格
					Object buyPrice = response.get("tradeStr").get(0).get(1);
					if (buyPrice instanceof Integer) {
						vo2.setCurrentPrice((Integer) buyPrice);
					} else if (buyPrice instanceof Double) {
						vo2.setCurrentPrice((Double) buyPrice);
					}

					// 当前涨幅
					double currentPriceUp = ((vo2.getCurrentPrice() - vo2.getEnd()) / (vo2.getEnd()) * 100.0);
					// System.out.println(vo2.getCurrentPrice() + "(" +
					// nf.format(currentPriceUp) + "%)");

					// 时间-最后一个时间即可
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					Date proDate = new Date(vo2.getTimestamp());
					String proStr = sdf.format(proDate);
					// System.out.println(proStr);
					
					int sortType = 0;
					// 流量异动
					boolean valumn = false;
					if((valumnUp > 500 && middle > 100)
							||(middle > 200)
				            ||(valumnUp > 800 && middle > 30)){
						valumn = true;
					}

					// 建议
					String recommend = "RE";
					if (valumnUp >= 500 && priceUp > 2 && currentPriceUp > 0) {
						recommend = "闪电买入";
						sortType = 1;
					} else if (middle > 100 && valumnUp > 100 && priceUp > 1 && currentPriceUp > 0) {
						recommend = "强烈买入";
						sortType = 2;
					} else if (middle > 100 && valumnUp > 100 && priceUp > 0) {
						recommend = "迅速买入";
						sortType = 3;
					} else if (middle > 60 && valumnUp > 60 && priceUp > 0 && currentPriceUp > 0) {
						recommend = "推荐买入";
						sortType = 4;
					} else if ((valumnUp > 100 && priceUp >= 1 && currentPriceUp >= 1)
							||(valumnUp>100 && currentPriceUp >= 2)) {
						recommend = "适当买入";
						sortType = 5;
					} else if (priceUp >= 1 && currentPriceUp >= 1) {
						recommend = "可以建仓";
						sortType = 6;
					} else if (middle <= 60 && middle >= 0 && valumnUp <= 60 && valumnUp >= 0 && priceUp >= 0) {
						recommend = "可以关注";
						sortType = 7;
					} else if (middle < 40 && middle > 0 && priceUp < 0 && currentPriceUp > 0) {
						recommend = "推荐卖出";
						sortType = 8;
					} else if (middle < 40 && middle > 0 && priceUp < 0 && currentPriceUp > -1) {
						recommend = "迅速卖出";
						sortType = 9;
					} else if ((middle > 20 && valumnUp > 50 && priceUp < -0.5 && currentPriceUp < -0.5)
							|| (priceUp <= -1.5 && currentPriceUp < 0.5) || (priceUp <= -1 && currentPriceUp <= -1)) {
						recommend = "强烈卖出";
						sortType = 10;
					} else if (priceUp < 0 && currentPriceUp < 0 && priceUp > currentPriceUp) {
						recommend = "闪电卖出";
						sortType = 11;
					} else {
						recommend = "静待观察";
						sortType = 12;
					}
					// System.out.println(recommend);
					/**
					 * 输出顺序：名称，是否异动/建议，当前价格（
					 * 与5分钟价格涨幅），5分钟价格（5分钟价格涨幅），5分钟量（5分钟量涨幅，与中位线比较），时间
					 * */
					List<Object> listObject = new ArrayList<Object>();
					listObject.add(sortType);
					listObject.add(nameMap.get(getCodeFromSite(site))+(valumn?"[量]":""));
					listObject.add(recommend);
					listObject.add(vo2.getCurrentPrice() + "<br />" + nf.format(currentPriceUp) + "%");
					listObject.add(nf.format(vo2.getEnd()) + "<br />" + nf.format(priceUp) + "%");
					listObject.add(nf.format(vo2.getVolumn()) + "<br />" + nf.format(valumnUp) + "%<br />" + nf.format(middle)
							+ "%");
					
					listObject.add(proStr);

					result.add(listObject);
					// 抓一个休息1-2秒钟
					SleepUtil.sleepBySecond(1, 2);
				}

				// 发邮件判断
				if (!result.isEmpty()) {
					// 邮件通知
					sendMessageByEmail("一览表", result, date);
					// 发送短信
					// sendMessageByMobile(time,content,siteList.get(i));

					// j++;
					// 防止出了问题疯狂地发邮件
					/*
					 * if (j > 1000) { break; }
					 */
				}

				// 置空
				result.clear();

				 System.out.println(DateUtil.convertDateToStr(date,
				 "yyyy-MM-dd HH:mm:ss") + " =====================");
				logger.info(DateUtil.convertDateToStr(date, "yyyy-MM-dd HH:mm:ss") + " =====================");
				SleepUtil.sleepByMinute(6, 8); // 4-5分钟随机时间
			}
		} catch (Exception e) {
			logger.error("抓取出错了: ", e);
			e.printStackTrace();
			// 1-2分钟随机时间
			SleepUtil.sleepByMinute(1, 2);

			// 出错后重新开始
			Thread t = new Thread(new Btc38());
			t.start();
			System.out.println("thread run again");
		} finally {
			result.clear();
		}
	}

	// 邮箱通知 内容过滤
	private void sendMessageByEmail(String title, List<List<Object>> content, Date date) {
		String text = "排位,名称[量],建议,当前价（幅）,5分价(幅),5分量(幅/中),时间";
		//排序
		if (content.size() > 0) {
			Collections.sort(content, new Comparator<List<Object>>() {
				@Override
				public int compare(List<Object> vo1, List<Object> vo2) {
					if ((Integer)vo1.get(0) > (Integer)vo2.get(0)) {
						return 1;
					} else if ((Integer)vo1.get(0) < (Integer)vo2.get(0)) {
						return -1;
					}
					return 0;
				}
			});
		}
		
		StringBuilder msg = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String proStr = sdf.format(date);
		msg.append("现在的时间是：" + proStr + "，操作策略如下：");
		msg.append("<table border=\"1\">");
		msg.append("<tr>");
		String[] textArray = text.split(",");
		for (String str : textArray) {
			msg.append("<td>" + str + "</td>");
		}
		msg.append("</tr>");
		for (List<Object> list : content) {
			msg.append("<tr>");
			for (Object obj : list) {
				msg.append("<td>" + obj + "</td>");
			}
			msg.append("</tr>");
		}

		msg.append("</table>");
		System.out.println(msg.toString());
		resultString = msg.toString();
		System.out.println("2"+resultString);
		try {
			// 不同时间发送的邮箱不一样
			if (date.getHours() >= 9 && date.getHours() <= 18) {
				//MailUtil.sendHTML("sekift@163.com", title, msg.toString());
			} else {
				//MailUtil.sendHTML("574919797@qq.com", title, msg.toString());
			}

			// TODO 添加接收邮件的邮件
		} catch (Exception e) {
			System.out.println("marby mail's jar error，please check……");
			e.printStackTrace();
		}
		flag = false;
		System.out.println(flag);
	}

	// 获取网址币种
	private static String getCodeFromSite(String str) {
		String result = "";
		try {
			URL url = new URL(str);
			String query = url.getQuery();
			String type = "coinname=";
			String[] queryArray = query.split("\\&");
			for (String s : queryArray) {
				if (s.contains(type)) {
					result = s.replace(type, "");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) {
		Thread t = new Thread(new Btc38());
		t.start();
	}

}