package com.example.demo.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.pojo.User;

@Component
public class UserDaoService {
	private static List<User> userList = new ArrayList<>();
	private static int userCount = 4;
	
	static {
		userList.add(new User(1,"ab",new Date()));
		userList.add(new User(2,"bc",new Date()));
		userList.add(new User(3,"cd",new Date()));
		userList.add(new User(4,"de",new Date()));
		
	}
	
	public List<User> findAllUsers(){
		return userList;
	}
	
	public void addUser(User user) {
		
		//if(user.getId() == null) {
			user.setId(++userCount);
	//	}
		userList.add(user);
	}
	
	public User findUser(int id) {
		for(User user : userList) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}

}
