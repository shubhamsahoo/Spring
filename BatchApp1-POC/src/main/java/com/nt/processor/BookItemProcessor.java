package com.nt.processor;

import org.springframework.batch.item.ItemProcessor;

public class BookItemProcessor implements ItemProcessor<String, String> {

	public String process(String bWOA) throws Exception {
		System.out.println("BookItemProcessor.process()");
		String bWA=null;
		if(bWOA.equalsIgnoreCase("CRJ"))
			bWA=bWOA+"--> HS";
		else if(bWOA.equalsIgnoreCase("TIJ"))
			bWA=bWOA+"--> BE";
		else if(bWOA.equalsIgnoreCase("EJ"))
			bWA=bWOA+"--> JB";
		else if(bWOA.equalsIgnoreCase("BBJ"))
			bWA=bWOA+"--> RNR";
		else if(bWOA.equalsIgnoreCase("NIT-Spring"))
			bWA=bWOA+"--> Nataraj";
		else
		  bWA=null;
		return bWA;
	}

}
