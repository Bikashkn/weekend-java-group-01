package com.demo.emp.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.emp.dao.EmpDAO;
import com.demo.emp.exception.EmployeeAPIException;
import com.demo.emp.utill.QueryUtil;

@Repository
public class EmpDAOImpl implements EmpDAO{
	
	@Autowired
	JdbcTemplate jdbctemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedJdbcTemplate;
	

	@Override
	public String saveEmpData(int empId, String empName, String dept, String exp, double salary)  {
		
		String query=QueryUtil.EMP_INSERT_QUERY;
		
		/*query.replaceAll(":empId", empId+"");
		query.replaceAll(":empName", empName);
		query.replaceAll(":dept", dept);
		query.replaceAll(":exp", exp);
		query.replaceAll(":salary", salary+"");
		
		
		//query=query+"("+empId+",'"+dept+"','"+empName+"','"+exp+"',"+salary+")";
		
		System.out.println("query == "+query.toString());
		
		namedJdbcTemplate.execute(query,queryMap);
		
		//jdbctemplate.execute(query);
		 **/
		 
		
		
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("empId", empId+"");
        map.put("empName", empName);
        map.put("dept", dept);
        map.put("exp", exp+"");
        map.put("salary", salary+"");
        namedJdbcTemplate.execute(query, map, new PreparedStatementCallback() {
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });

		return "EmpCreated "+empId;
	}
	
	@Override
	public String saveEmpData2(int empId, String empName, String dept, String exp, double salary)  {
		
		String query=QueryUtil.EMP_INSERT_QUERY_2;
		
		
		/*Map<String, Object> map = new HashMap<String, Object>();
        map.put("empId", empId+"");
        map.put("empName", empName);
        map.put("dept", dept);
        map.put("exp", exp+"");
        map.put("salary", salary+"");
        */
        jdbctemplate.execute(query, new PreparedStatementCallback() {
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
            	ps.setInt(1, empId);
            	ps.setString(2, empName);
            	ps.setString(3, dept);
            	ps.setString(4, exp);
            	ps.setDouble(5, salary);
                return ps.executeUpdate();
            }
        });

		return "EmpCreated "+empId;
	}

	@Override
	public void updateEmpData(String empUpdateQuery) {
		
		jdbctemplate.execute(empUpdateQuery);
		
	}

	@Override
	public void deleteEmp(String deleteEmpQuery) {

		jdbctemplate.execute(deleteEmpQuery);
		
	}

}
