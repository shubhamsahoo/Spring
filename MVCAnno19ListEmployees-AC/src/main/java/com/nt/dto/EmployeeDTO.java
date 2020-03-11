package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int sno;
	private int empNo;
	private String ename;
	private String job;
	private float salary;
	private int deptNo;

}
