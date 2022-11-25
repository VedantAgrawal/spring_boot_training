package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.CatalogItem;
import com.example.demo.models.Movie;
import com.example.demo.models.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieInfo {

	public MovieInfo() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="fallBackGetCatalogItem")
	public CatalogItem getCatalogItem(Rating rating) {
		Movie movie =restTemplate.getForObject("http://localhost:8882/movies/" + rating.getMovieId(),Movie.class);
		return new CatalogItem(movie.getName(),movie.getDescription(),rating.getRating());
	}
	
	public CatalogItem fallBackGetCatalogItem(Rating rating) {
		return new CatalogItem("Movie name not found","",rating.getRating());
	}
}
