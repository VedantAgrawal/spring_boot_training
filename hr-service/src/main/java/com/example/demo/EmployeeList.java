package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EmployeeList {

	public EmployeeList() {
		// TODO Auto-generated constructor stub
	}
	
	private List<Employee> employee;

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	
	

}
