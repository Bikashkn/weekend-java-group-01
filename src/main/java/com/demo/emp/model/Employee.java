package com.demo.emp.model;

import lombok.Data;

@Data
public class Employee {
	
	private Integer empId;
	private String empName;
	private String dept;
	private String exp;
	private double salary;

}
