package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/admissions")
public class AdmissionResource {

	public AdmissionResource() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/employees")
	public EmployeeList getEmplyees() {
		EmployeeList employeeList  = restTemplate.getForObject("http://localhost:8082/hr/employees",EmployeeList.class);
		//EmployeeList employeeList  = restTemplate.getForObject("http://hr-service/hr/employees",EmployeeList.class);
		return employeeList;
	}
	
	@RequestMapping("/diseases")
	public DiseaseList getDiseases() {
		//DiseaseList diseaseList  = restTemplate.getForObject("http://localhost:8083/pathalogy/diseases/",DiseaseList.class);
		DiseaseList diseaseList  = restTemplate.getForObject("http://pathalogy-service/pathalogy/diseases/",DiseaseList.class);
		return diseaseList;
	}
	
}
