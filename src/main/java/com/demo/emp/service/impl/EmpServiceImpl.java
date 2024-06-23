package com.demo.emp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.emp.dao.EmpDAO;
import com.demo.emp.exception.EmployeeAPIException;
import com.demo.emp.model.Employee;
import com.demo.emp.service.EmpService;
import com.demo.emp.utill.QueryUtil;

@Service
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	EmpDAO dao;

	@Override
	public String getEmpInfo(String id) {

		return "EmpInfo "+id;
	}

	@Override
	public String createNewEmp(Employee emp) throws EmployeeAPIException {
		
		int empId = emp.getEmpId();
		String empName = emp.getEmpName();
		String dept = emp.getDept();
		String exp = emp.getExp();
		double salary = emp.getSalary();
		
		System.out.println(" "+empId+" "+empName+" "+dept+" "+exp+" "+salary);
		dao.saveEmpData(empId,empName,dept,exp,salary);
		return null;
	}

	@Override
	public void updateEmp(Employee emp) throws EmployeeAPIException {
		
		//Update employee set EMP_Name='',EMP_DEpartment='',EMP_SALARY='',EMP_AGE='' where EMP_ID=''
		
		String empUpdateQuery=QueryUtil.EMP_DATA_UPDATE_QUERY;
		
	 if(emp.getEmpId()!=null) {
		if(emp.getDept()!=null) {
			empUpdateQuery=empUpdateQuery+" EMP_DEpartment='"+emp.getDept()+"',";
		}
		if(emp.getEmpName()!=null) {
			empUpdateQuery=empUpdateQuery+" EMP_Name='"+emp.getEmpName()+"',";
		}
		if(emp.getSalary()!=0) {
			empUpdateQuery=empUpdateQuery+" EMP_SALARY='"+emp.getSalary()+"',";
		}
		if(emp.getExp()!=null) {
			empUpdateQuery=empUpdateQuery+" EMP_AGE='"+emp.getExp()+"',";
		}
		
		if(empUpdateQuery.endsWith(",")){
			empUpdateQuery=empUpdateQuery.substring(0, empUpdateQuery.length()-1);
		}
		System.out.println("empUpdateQuery "+empUpdateQuery);
		empUpdateQuery=empUpdateQuery+" Where EMP_ID='"+emp.getEmpId()+"' ";
		}else {
			throw new EmployeeAPIException("EMP ID cant be null");
		}
	 
	 
	 
	  dao.updateEmpData(empUpdateQuery);
		
	}

	@Override
	public String deletEmp(String id) throws EmployeeAPIException {
		
		System.out.println("id "+id);
		String deleteEmpQuery=QueryUtil.DELETE_EMP_DATA;
		deleteEmpQuery=deleteEmpQuery.replaceAll(":empId", id);
		
		dao.deleteEmp(deleteEmpQuery);
		
		return null;
	}

}
