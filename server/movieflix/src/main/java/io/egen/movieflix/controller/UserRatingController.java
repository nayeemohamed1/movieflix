package io.egen.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.entity.UserRating;
import io.egen.movieflix.service.UserRatingService;

@RestController
@RequestMapping(path="userratings")
public class UserRatingController {
	
	@Autowired
	UserRatingService userRatingService;
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<UserRating> findAll(){
		return userRatingService.findAll();
	}

	@RequestMapping(method=RequestMethod.GET,path="movieid/{id}" ,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<UserRating> findAllUserRatingsByMovieId(@PathVariable String id){
		return userRatingService.findAllUserRatingsByMovieId(id);
		
	}

	@RequestMapping(method=RequestMethod.GET, path="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserRating findOne(@PathVariable String id){
		return userRatingService.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE )
	public UserRating create(@RequestBody UserRating userRating){
		return userRatingService.create(userRating);
	}
	
	@RequestMapping(method=RequestMethod.PUT,path="{id}", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserRating update(@PathVariable("id") String userRatingId, @RequestBody UserRating userRating){
		return userRatingService.update(userRatingId, userRating);
	}

	@RequestMapping(method=RequestMethod.DELETE, path="{id}")
	public void delete(@PathVariable String id){
		userRatingService.delete(id);
	}
}
