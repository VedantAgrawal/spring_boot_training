package com.example.demo.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.Rating;
import com.example.demo.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserRatingInfo {

	public UserRatingInfo() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="fallBackGetUserRating")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		return restTemplate.getForObject("http://localhost:8883/ratingsdata/user/" + userId,UserRating.class);
	}

	public UserRating fallBackGetUserRating(@PathVariable("userId") String userId) {
		UserRating userRating = new UserRating();
		
		userRating.setUserId(userId);
		userRating.setRatings(Arrays.asList(new Rating("100",0)));
		return userRating;
	}
	
}
