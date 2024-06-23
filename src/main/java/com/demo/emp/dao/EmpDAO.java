package com.demo.emp.dao;

import com.demo.emp.exception.EmployeeAPIException;

public interface EmpDAO {

	String saveEmpData(int empId, String empName, String dept, String exp, double salary) throws EmployeeAPIException;

	String saveEmpData2(int empId, String empName, String dept, String exp, double salary);

	void updateEmpData(String empUpdateQuery);

	void deleteEmp(String deleteEmpQuery);

}
