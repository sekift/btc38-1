package com.btc38.www.quartztest;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class PrintPropsJob implements Job{
	public PrintPropsJob(){
		// 实例化一个job必须要有一个无参构造器。
	}
	
	public void execute(JobExecutionContext context)throws JobExecutionException{
		JobDataMap data = context.getMergedJobDataMap();
		System.out.println("someProp = " + data.getString("someProp"));
	}
}
