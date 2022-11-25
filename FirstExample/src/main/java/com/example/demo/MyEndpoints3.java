package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.ExampleProperties;

@RestController
public class MyEndpoints3 {

	@Autowired
	private ExampleProperties props;
	
	@GetMapping("/greetothers")
	public String greet(@RequestParam String details) {
		return props.getGreeting() + details;
	}
	
}
