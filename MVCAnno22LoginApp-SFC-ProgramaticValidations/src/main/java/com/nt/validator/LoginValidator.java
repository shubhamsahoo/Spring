package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.UserCommand;

@Component("loginValidator")
public class LoginValidator  implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return  clazz.isAssignableFrom(UserCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
	   UserCommand cmd=null;
		//type casting
	   cmd=(UserCommand)target;
	   //form validation  logic
	   if(cmd.getUsername().equals("") || cmd.getUsername()==null || cmd.getUsername().length()==0)
		   errors.rejectValue("username", "uname.required");
	   
	   if(cmd.getPassword().equals("") || cmd.getPassword()==null || cmd.getPassword().length()==0)
		   errors.rejectValue("password", "pwd.required");
	   
	   
		
		
	}

}
