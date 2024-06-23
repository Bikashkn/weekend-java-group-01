package com.demo.emp.service;

import com.demo.emp.exception.EmployeeAPIException;
import com.demo.emp.model.Employee;

public interface EmpService {
	
	
	public String getEmpInfo(String id) throws EmployeeAPIException;

	public String createNewEmp(Employee emp) throws EmployeeAPIException;

	public void updateEmp(Employee emp) throws EmployeeAPIException;

	public String deletEmp(String id) throws EmployeeAPIException;

}
