package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.User;
import com.example.demo.pojo.UserDaoService;
//import daoservice.UserDaoService;

@RestController
public class MyEndpoints2 {

	
	@Autowired
	private UserDaoService userDaoService;
	/*private UserDaoService userDaoService = new UserDaoService();*/
	
	
	
	@GetMapping(path="/userPath")
	public List<User> getuserMethod(){
		return userDaoService.findAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id) {
		return userDaoService.findUser(id);
	}
	
	@PostMapping("/userPath")
	public List<User> addUserMethod(@RequestBody User user){
		userDaoService.addUser(user);
		return userDaoService.findAllUsers();
	}
	
}
