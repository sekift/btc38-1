
package com.btc38.www.service;

import java.util.concurrent.ConcurrentHashMap;

public class Action {
	private static ConcurrentHashMap<String, Btc38Program> map = new ConcurrentHashMap<String, Btc38Program>();
	private static Btc38Program btc = null;

	static {
		if (map.isEmpty()) {
			if (null == btc) {
				btc = new Btc38Program();
			}
			map.put("btc", btc);
			btc = (Btc38Program) map.get("btc");
			btc.run();
		}
	}

}
