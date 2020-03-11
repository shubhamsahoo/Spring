package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;


@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO dao;
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,transactionManager = "dsTxMgmr",readOnly = true)
	public List<EmployeeDTO> fetchAllEmployees() {
		List<EmployeeBO> listBO=null;
		List<EmployeeDTO> listDTO=null;
		EmployeeDTO dto=null;
		//use DAO
		listBO=dao.getAllEmployees();
		//copy listBO to listDTO
		listDTO=new ArrayList();
		for(EmployeeBO bo:listBO) {
			 dto=new EmployeeDTO();
			 BeanUtils.copyProperties(bo, dto);
			 dto.setSno(listDTO.size()+1);
			 listDTO.add(dto);
		}
		
		return listDTO;
	}//method
}//class
