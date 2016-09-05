package io.egen.movieflix.service;

import java.util.List;

import io.egen.movieflix.entity.UserRating;

public interface UserRatingService {
	
	public List<UserRating> findAll();
	
	public List<UserRating> findAllUserRatingsByMovieId(String id);
	
	public UserRating findOne(String id);
	
	public UserRating create(UserRating userRating);
	
	public UserRating update(String id, UserRating userRating);
	
	public void delete(String id);
	

}
