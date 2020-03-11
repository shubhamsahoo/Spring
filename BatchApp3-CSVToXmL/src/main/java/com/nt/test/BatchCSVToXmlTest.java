package com.nt.test;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BatchCSVToXmlTest {

	public static void main(String[] args) {
		ApplicationContext  ctx=null;
		JobLauncher launcher=null;
		Job job=null;
		JobExecution execution=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/batch-beans.xml");
		//get  JobLauncher
		launcher=ctx.getBean("jobLauncher",JobLauncher.class);
		job=ctx.getBean("job1",Job.class);
		//execute the JOB
		try {
			execution=launcher.run(job,new  JobParameters());
			System.out.println("Status ::"+execution.getStatus());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
