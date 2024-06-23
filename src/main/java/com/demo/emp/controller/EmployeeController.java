package com.demo.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.emp.exception.EmployeeAPIException;
import com.demo.emp.model.Employee;
import com.demo.emp.service.EmpService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmpService empService;
	
	//http://localhost:8081/employee/getById/246
	@GetMapping("/getById/{id}")
	public String getEmp(@PathVariable String id) {
		
		String empInfo = null;
		try {
			empInfo = empService.getEmpInfo(id);
		} catch (EmployeeAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empInfo;
		
	}

	//http://localhost:8081/employee/createEmp
	@PostMapping("/createEmp")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp )  {
		
		try {
		System.out.println("emp =="+emp.getEmpId());
		empService.createNewEmp(emp);
		}catch(EmployeeAPIException eapi) {
			eapi.getMessage();
		}
		
		return new ResponseEntity<>(emp,HttpStatus.OK) ;
		
		
		
		
	}
	
	//http://localhost:8081/employee/updateEmpData
	@PostMapping("/updateEmpData")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp )  {
		
		try {
		System.out.println("emp =="+emp.getEmpId());
		empService.updateEmp(emp);
		}catch(EmployeeAPIException eapi) {
			eapi.getMessage();
		}
		
		return new ResponseEntity<>(emp,HttpStatus.OK) ;
		
		
	}
	
	//http://localhost:8081/employee/deleteEmp/246
	@DeleteMapping("/deleteEmp/{id}")
	public String deletEmpById(@PathVariable String id) {
		
		String empInfo = null;
		try {
			empInfo = empService.deletEmp(id);
		} catch (EmployeeAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empInfo;
		
	}
}
