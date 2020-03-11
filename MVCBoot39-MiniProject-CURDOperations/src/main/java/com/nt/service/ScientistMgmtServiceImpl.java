package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.ScientistBO;
import com.nt.dao.ScientistDAO;
import com.nt.dto.ScientistDTO;

@Service("scService")
public class ScientistMgmtServiceImpl implements ScientistMgmtService {

	 @Autowired
	private  ScientistDAO  dao;



	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = true,transactionManager = "transactionManager")
	public List<ScientistDTO> fetchAllScientists() {
		List<ScientistBO> listBO=null;
		List<ScientistDTO> listDTO=new ArrayList();
		//use DAO
		listBO=dao.getAllScientists();
		//convert listBO to  listDTO
		listBO.forEach(bo->{
			ScientistDTO dto=new ScientistDTO();
			BeanUtils.copyProperties(bo,dto);
			dto.setSrno(listDTO.size()+1);
			listDTO.add(dto);
		});
		return listDTO;
	}//method
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = true,transactionManager = "transactionManager")
	public ScientistDTO fetchScientistById(int id) {
		ScientistBO bo=null;
		ScientistDTO dto=null;
	//use DAO
		bo=dao.getScientistById(id);
		//convert  bo to DTO
		dto=new ScientistDTO();
		BeanUtils.copyProperties(bo,dto);
		return dto;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly =false,transactionManager = "transactionManager")
	public String modifyScientistById(ScientistDTO dto) {
		ScientistBO  bo=null;
		int count=0;
		// convert DTO  to BO
		bo=new ScientistBO();
		BeanUtils.copyProperties(dto, bo);
		//use dao
		count=dao.upateScientistById(bo);
		if(count==0)
		    return "Scientist Details are not updated";
		else
			return "Scientist Details are  updated";
	}//method
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false,transactionManager = "transactionManager")
	public String removeScientistById(int id) {
		//use DAO
		String msg=dao.deleteScientistById(id)==1?"Scientist is removed":"Scientist is not Removed";
		return msg;
	}
	
}//class
