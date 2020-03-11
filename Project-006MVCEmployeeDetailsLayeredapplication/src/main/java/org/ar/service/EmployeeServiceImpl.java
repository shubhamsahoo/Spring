package org.ar.service;

import java.util.ArrayList;
import java.util.List;

import org.ar.bo.EmployeeBO;
import org.ar.dao.EmployeeDetailsDAO;
import org.ar.dto.EmployeeDTO;
import org.springframework.beans.BeanUtils;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDetailsDAO dao;
	
	public EmployeeServiceImpl(EmployeeDetailsDAO dao) {
		super();
		this.dao = dao;
	}

	public List<EmployeeDTO> getDetails() {
		// TODO Auto-generated method stub
		List<EmployeeDTO> listdto=null;
		List<EmployeeBO> listbo=null;
		listdto=new ArrayList<EmployeeDTO>();
		listbo=dao.getAllEmployeeDetails();
	   for(EmployeeBO bo:listbo)
	   {
		   EmployeeDTO dto=null;
		   dto=new EmployeeDTO();
		   BeanUtils.copyProperties(bo, dto);
		   dto.setSid(1);
	   }
	   return listdto;
	}

}
