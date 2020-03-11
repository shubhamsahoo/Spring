package org.ar.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.ar.bo.EmployeeBO;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class EmployeeDetailsDAOImpl implements EmployeeDetailsDAO{
    private JdbcTemplate jt;
    
    public EmployeeDetailsDAOImpl(JdbcTemplate jt) {
		super();
		this.jt = jt;
	}
	private static final String GET_ALL_EMP_DETAILS="SELECT EMPNO,ENAME,JOB,SAL FROM EMP";
	public List<EmployeeBO> getAllEmployeeDetails() {
		List<EmployeeBO> list=null;
		list=jt.query(GET_ALL_EMP_DETAILS, new ResultSetExtractor<List<EmployeeBO>>() {

			public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<EmployeeBO> list=null;
				EmployeeBO bo=null;
				list=new ArrayList<EmployeeBO>();
				while(rs.next())
				{
					bo=new EmployeeBO();
					bo.setEno(rs.getInt(1));
					bo.setEname(rs.getString(2));
					bo.setJob(rs.getString(3));
					bo.setSal(rs.getInt(4));
					list.add(bo);
				}
				return list;
			}
		});
		return list;
	}
	

}
