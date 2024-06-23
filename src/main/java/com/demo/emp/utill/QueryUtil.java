package com.demo.emp.utill;

public class QueryUtil {
	
	
	public static String EMP_INSERT_QUERY_2="INSERT INTO employee ('EMP_ID','EMP_NAME','EMP_DEPARTMENT','EMP_AGE','EMP_SALARY') VALUES (?,?,?,?,?)";
	
	public static String EMP_INSERT_QUERY="INSERT INTO employee (EMP_ID,EMP_DEPARTMENT,EMP_NAME,EMP_AGE,EMP_SALARY) VALUES (:empId,:dept,:empName,:exp,:salary)";
	
	public static String EMP_DATA_UPDATE_QUERY="Update employee set";
	
	public static String DELETE_EMP_DATA="Delete from employee where EMP_ID=:empId";

}
