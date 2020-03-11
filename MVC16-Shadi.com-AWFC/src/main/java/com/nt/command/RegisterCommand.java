package com.nt.command;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter	
@ToString
public class RegisterCommand {
	private String name;
	private  String addrs="Hyd";
	private String gender="Female";
	private  Date  dob;
	private String qlfy;
	private String desg;
	private float salary;
	private String expDesg;
	private String[] hobies;
	private byte expAge;
	
	public RegisterCommand() {
		System.out.println("RegisterCommand :: 0-param constructor");
	}

}
