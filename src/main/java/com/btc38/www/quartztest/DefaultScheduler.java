package com.btc38.www.quartztest;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class DefaultScheduler {
	public static void main(String args[]) {
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler scheduler;
		try {
			scheduler = sf.getScheduler();
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

}
