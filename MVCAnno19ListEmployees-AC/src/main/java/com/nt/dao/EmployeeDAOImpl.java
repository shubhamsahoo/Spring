package com.nt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String  GET_ALL_EMPLOYEES="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP";

	@Autowired
	private JdbcTemplate jt;


	@Override
	public List<EmployeeBO> getAllEmployees() {
		BeanPropertyRowMapper<EmployeeBO>  bprm=null;
		List<EmployeeBO>  listBO=null;
		
		bprm=new BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class);
		listBO=jt.query(GET_ALL_EMPLOYEES,new RowMapperResultSetExtractor<EmployeeBO>(bprm));
		
		return listBO;
		
			
			}//method
}//class
