package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hr")
public class HrResource {

	@Autowired
	EmployeeList employeeList;
	
	@RequestMapping("/employees")
	public List<Employee> getEmployees(){
		List<Employee> employees = Arrays.asList(new Employee("E1","Ram","Kumar","MD"),
				new Employee("E2","Ramesh","Kumar","MBBS"),
				new Employee("E3","Rakesh","Kumar","Dentist"),
				new Employee("E4","Rajesh","Kumar","MD"));
		
		employeeList.setEmployee(employees);
		return employeeList.getEmployee();
	}
	
	@RequestMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable("id") String Id){
		for(Employee employee : employeeList.getEmployee()) {
			if(employee.getId().equals(Id)) {
				return employee;
			}
		}
		return null;
	}
}
