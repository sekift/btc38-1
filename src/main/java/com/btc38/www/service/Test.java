package com.btc38.www.service;

import java.util.Random;

/**
 * @author 作者:sekift
 * @author E-mail:sekiftlyz@gmail.com
 * @version 创建时间：2017-5-8 下午11:26:08 类说明:[]
 */
public class Test {
	public static void main(String args[]) {
		String urlAfter = "https://www.biguyuan.com";
				//+ new Random().nextDouble();
		String html = GetURLContent.getPageContent(urlAfter);
		System.out.println(html);
	}

}
