package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.UserBO;
import com.nt.dao.LoginDAO;
import com.nt.dto.UserDTO;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private  LoginDAO dao;

	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public String authenticate(UserDTO dto) {
		UserBO bo=null;
		int count=0;
		//convert dto to BO
		bo=new UserBO();
		BeanUtils.copyProperties(dto, bo);
		//use dAO
		count=dao.validate(bo);
		//process the result
		if(count==0)
			  return "InValid Credentials";
		else
		  return "Valid Credentials";
	}

}
