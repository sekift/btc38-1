package com.btc38.www.quartztest;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import com.btc38.www.util.SleepUtil;

public class SchedulerJob {
	public static void main(String args[]) {
		SchedulerFactory sf = new StdSchedulerFactory();
		JobDataMap newJobDataMap = new JobDataMap();
		newJobDataMap.put("someProp", "my first job.");
		
		try {
			Scheduler sched = sf.getScheduler();
			sched.start();
			JobDetail job1 = newJob(PrintPropsJob.class).withIdentity("job1", "group1").usingJobData(newJobDataMap)
					.build();
			Trigger trigger1 = newTrigger().withIdentity("trigger1", "group1").startNow()
					.withSchedule(simpleSchedule()
				            .withIntervalInSeconds(10)
				            .repeatForever())
					.build();

			sched.scheduleJob(job1, trigger1);
			

			SleepUtil.sleepBySecond(60, 60);
			sched.shutdown();
		} catch (SchedulerException e) {
			e.printStackTrace(); 
		}

	}

}
