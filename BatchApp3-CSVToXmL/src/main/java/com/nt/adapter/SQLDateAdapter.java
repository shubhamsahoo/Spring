package com.nt.adapter;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class SQLDateAdapter extends XmlAdapter<String, Date> {

	@Override
	public String marshal(Date date) throws Exception {
		return new SimpleDateFormat("MMM-dd-yyyy").format(date);
	}

	@Override
	public Date unmarshal(String date) throws Exception {
		return  java.sql.Date.valueOf(date);
	}

}
