package com.nt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;
import com.nt.bo.EmployeeResultBO;


@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String  SEARCH_EMPS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO,MGR  FROM EMP WHERE EMPNO=? OR ENAME=? OR JOB=? OR SAL=?";
	
	@Autowired
	private  JdbcTemplate jt;

	
	@Override
	public List<EmployeeResultBO> search(EmployeeBO bo) {
		List<EmployeeResultBO>  listRBO=null;
		BeanPropertyRowMapper<EmployeeResultBO>  rowMapper=null;
		
		  // Create RowMapper
		rowMapper=new BeanPropertyRowMapper(EmployeeResultBO.class);
		listRBO=(List<EmployeeResultBO>) jt.query(SEARCH_EMPS, new RowMapperResultSetExtractor(rowMapper),bo.getEmpNo(),bo.getEname(),bo.getJob(),bo.getSal());		
	
		return listRBO;
	}//method
}//class
