package com.nt.test;



import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.config.BatchConfig;

@SpringBootApplication
@Import(BatchConfig.class)
public class BatchBootApp4CsvToDbApplication {
	@Autowired
	private static JobLauncher launcher;

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		Job job=null;
		JobExecution execution;
		//get IOC container
		ctx=SpringApplication.run(BatchBootApp4CsvToDbApplication.class, args);
		//get Job object
		job=ctx.getBean("createJob1",Job.class);
		//execute the JOb
		try {
			execution= launcher.run(job,new JobParameters());
			System.out.println("Status::"+execution.getStatus());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
		
		
	}

}
