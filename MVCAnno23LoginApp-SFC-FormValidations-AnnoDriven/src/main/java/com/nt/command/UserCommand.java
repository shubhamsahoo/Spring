package com.nt.command;



import java.util.Date;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserCommand {
	@NotBlank(message = "username must not be empty")
	private String username;
	@NotBlank(message = "Password must not be empty")
	private  String password;
	private int age;
	private String country;
	private  String[] hobies;
	private  Date dob;
	
	public UserCommand() {
		System.out.println("UserCommand:0-param constructor");
	}

}
