package com.btc38.www.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.btc38.www.util.CloseUtil;

/**
 * 提供获取网页内容的类
 * 
 * @author:sekift
 * @time:2014-7-8 下午03:38:14
 */
public class GetURLContent {
	public static final Logger logger = LoggerFactory.getLogger(GetURLContent.class);

	public static void urlConnectionPost(String urlName) {
		StringBuilder sb = null;
		BufferedReader br = null;
		OutputStreamWriter osw = null;
		URL url;
		try {
			url = new URL(urlName);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setConnectTimeout(1000 * 5);
			osw = new OutputStreamWriter(conn.getOutputStream());
			osw.write("");
			osw.flush();
			// Get the response
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			sb = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("[sekiftutil]提供获取网页内容的类：", e);
		} finally {
			CloseUtil.closeSilently(osw);
			CloseUtil.closeSilently(br);
		}
	}

	/**
	 * 获取网页返回码
	 * 
	 * @param urlName
	 * @return
	 */
	public static int getPageStatus(String urlName) {
		GetMethod method = null;
		int statusCode = 0;
		HttpClient httpClient = null;
		try {
			httpClient = new HttpClient();
			// 1、网络请求
			method = new GetMethod(urlName);
			statusCode = httpClient.executeMethod(method);
			method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
		} catch (HttpException e) {
			// 发生致命的异常，可能是协议不对或者返回的内容有问题
			System.out.println("Please check your provided http address!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("[sekiftutil]提供获取网页内容的类--获取网页返回码：", e);
		} finally {
			// 释放连接
			method.releaseConnection();
			httpClient.getHttpConnectionManager().closeIdleConnections(0);
		}
		return statusCode;
	}

	/**
	 * 获取网页title
	 * 
	 * @param urlName
	 * @return
	 */
	public static String getPageTitle(String urlName) {
		String content = null;
		String title = null;
		GetMethod method = null;
		HttpClient httpClient = null;
		try {
			httpClient = new HttpClient();
			// 1、网络请求
			method = new GetMethod(urlName);
			int statusCode = httpClient.executeMethod(method);
			// method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
			// new DefaultHttpMethodRetryHandler());
			System.err.println(statusCode);
			if (statusCode == HttpStatus.SC_OK) {
				content = method.getResponseBodyAsString();
				// 结构化提取
				title = StringUtils.substringBetween(content, "<title>", "</title>");
			}
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: " + method.getStatusLine());
			}
		} catch (HttpException e) {
			// 发生致命的异常，可能是协议不对或者返回的内容有问题
			System.out.println("Please check your provided http address!");
			e.printStackTrace();
			logger.error("[sekiftutil]提供获取网页内容的类--获取网页title：", e);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("[sekiftutil]提供获取网页内容的类--获取网页title：", e);
		} finally {
			// 释放连接
			method.releaseConnection();
			httpClient.getHttpConnectionManager().closeIdleConnections(0);
		}
		return title;
	}

	/**
	 * 获取网页内容
	 * 
	 * @param urlName
	 * @return
	 */
	public static String getPageContent(String urlName) {
		String content = null;
		GetMethod method = null;
		HttpClient httpClient = null;
		try {
			httpClient = new HttpClient();
			// 1、网络请求
			method = new GetMethod(urlName);
			int statusCode = httpClient.executeMethod(method);
			if (statusCode == HttpStatus.SC_OK) {
				content = method.getResponseBodyAsString();
			}
		} catch (HttpException e) {
			e.printStackTrace();
			logger.error("[sekiftutil]提供获取网页内容的类--获取网页内容：", e);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("[sekiftutil]提供获取网页内容的类--获取网页内容：", e);
		} finally {
			// 释放连接
			method.releaseConnection();
			httpClient.getHttpConnectionManager().closeIdleConnections(0);
		}
		return content;
	}

	/**
	 * 下载网页到文件
	 * 
	 * @param urlName
	 * @param fileName
	 * @return
	 */
	public static String downPageToFile(String urlName, String fileName) {
		URL url = null;
		BufferedReader br = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		String result = null;
		try {
			url = new URL(urlName);
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			String str = null;

			fw = new FileWriter(fileName);
			bw = new BufferedWriter(fw);
			while ((str = br.readLine()) != null) {
				bw.write(str);
				bw.write("\r\t");
			}
			result = "done";
		} catch (MalformedURLException e) {
			e.printStackTrace();
			result = e.getMessage();
			logger.error("[sekiftutil]提供获取网页内容的类--下载网页到文件：", e);
		} catch (IOException e) {
			e.printStackTrace();
			result = e.getMessage();
			logger.error("[sekiftutil]提供获取网页内容的类--下载网页到文件：", e);
		} finally {
			CloseUtil.closeSilently(bw);
			CloseUtil.closeSilently(fw);
			CloseUtil.closeSilently(br);
		}
		return result;

	}
}
