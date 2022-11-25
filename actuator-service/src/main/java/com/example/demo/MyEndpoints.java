package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.pojo.SampleBean;

@RestController
public class MyEndpoints {
	
	@RequestMapping("/myFirstPage")
	public String firstPage() {
		return "My first Page";
	}
	
	@RequestMapping("/secondPage")
	public String secondPage(@RequestParam String name) {
		return "Hello " + name ; 
	}
	
	@RequestMapping(path = "/secondPage/{name}")
	public String secondPageWithPathVariable(@PathVariable String name) {
		return "Hello Path Vairables: " +name;
		
	}
	
	@GetMapping(path="/secondPage/")
	public SampleBean SampleBeanMethod() {
		return new SampleBean("newMessage");
	}
	
}
