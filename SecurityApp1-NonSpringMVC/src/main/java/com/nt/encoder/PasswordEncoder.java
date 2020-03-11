package com.nt.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		BCryptPasswordEncoder pwdEncoder=null;
		pwdEncoder=new BCryptPasswordEncoder(11);
		
		System.out.println(pwdEncoder.encode("hyd"));
		System.out.println(pwdEncoder.encode("rani"));
		
	}

}
