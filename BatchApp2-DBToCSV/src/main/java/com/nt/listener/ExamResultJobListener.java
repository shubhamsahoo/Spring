package com.nt.listener;

import java.util.Date;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class ExamResultJobListener implements JobExecutionListener {
    private long start,end;
	public void beforeJob(JobExecution jobExecution) {
		start=System.currentTimeMillis();
		System.out.println("Job Started at::"+new Date());

	}

	public void afterJob(JobExecution jobExecution) {
		end=System.currentTimeMillis();
		System.out.println("Job Ended at ::"+new Date());
		System.out.println("Job is in execution for "+(end-start)+" ms");
		if(jobExecution.getStatus()==BatchStatus.COMPLETED)
			  System.out.println("Batch Completed");
		else if(jobExecution.getStatus()==BatchStatus.FAILED)
			System.out.println("Batch Completed");
		
		

	}

}
