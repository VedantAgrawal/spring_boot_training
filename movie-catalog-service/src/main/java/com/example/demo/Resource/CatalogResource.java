package com.example.demo.Resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.CatalogItem;
import com.example.demo.models.Movie;
import com.example.demo.models.UserRating;
import com.example.demo.services.MovieInfo;
import com.example.demo.services.UserRatingInfo;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

	public CatalogResource() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	/*
	@RequestMapping("/{userId}")
	@HystrixCommand(fallbackMethod = "getFallBackCatalog")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		UserRating userRating=restTemplate.getForObject("http://localhost:8883/ratingsdata/user/" + userId, UserRating.class);
		return userRating.getRatings().stream()
				.map(rating-> {
					Movie movie =restTemplate.getForObject("http://localhost:8882/movies/" + rating.getMovieId(),Movie.class);
					return new CatalogItem(movie.getName(),movie.getDescription(),rating.getRating());
				}).collect(Collectors.toList());
	}
	
	public List<CatalogItem> getFallBackCatalog(@PathVariable("userId") String userId){
		return Arrays.asList(new CatalogItem("No movie at this time","",0));
	}*/
	
	@Autowired 
	UserRatingInfo userRatingInfo;
	
	@Autowired
	MovieInfo movieInfo;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		UserRating userRating=userRatingInfo.getUserRating(userId);
		return userRating.getRatings().stream()
				.map(rating-> movieInfo.getCatalogItem(rating)).collect(Collectors.toList());
	}
}
