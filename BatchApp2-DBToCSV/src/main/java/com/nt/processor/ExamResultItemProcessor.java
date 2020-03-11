package com.nt.processor;

import org.springframework.batch.item.ItemProcessor;

import com.nt.model.ExamResult;

public class ExamResultItemProcessor   implements  ItemProcessor<ExamResult,ExamResult>{

	public ExamResult process(ExamResult item) throws Exception {
		   if(item.getPercentage()>=60)
			   return item;
		   else
		      return null;
	}

}
