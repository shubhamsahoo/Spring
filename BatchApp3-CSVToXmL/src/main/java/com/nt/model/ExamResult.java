package com.nt.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.nt.adapter.SQLDateAdapter;

@XmlRootElement(name="ExamResult")
public class ExamResult {
	private int id;
	private  float percentage;
	private java.sql.Date dob;
	private int semester;
	@XmlElement(name = "id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement(name = "percentage")
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	
	@XmlElement(name = "dob")
	@XmlJavaTypeAdapter(type = java.sql.Date.class,value = SQLDateAdapter.class)
	public java.sql.Date getDob() {
		return dob;
	}
	public void setDob(java.sql.Date dob) {
		this.dob = dob;
	}
	
	@XmlElement(name = "sem")
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}

}
