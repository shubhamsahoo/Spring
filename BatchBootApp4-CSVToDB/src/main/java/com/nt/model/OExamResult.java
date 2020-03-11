package com.nt.model;

import java.sql.Date;

import lombok.Data;

@Data
public class OExamResult {
	private int id;
	private int semester;
	private float percentage;
	private  Date dob;

}
