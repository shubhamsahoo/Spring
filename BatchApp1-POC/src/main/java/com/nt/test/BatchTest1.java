package com.nt.test;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BatchTest1 {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		JobLauncher launcher=null;
		Job  job=null;
		JobExecution  excution=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/batch-beans.xml");
		//get JobLauncher
		launcher=ctx.getBean("jobLauncher",JobLauncher.class);
		//Get Job 
		job=ctx.getBean("job1",Job.class);
		try {
			excution=launcher.run(job, new JobParameters());
			System.out.println("Status ::"+excution.getStatus());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
		
	}

}
