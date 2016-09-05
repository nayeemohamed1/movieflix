package io.egen.movieflix.repository;

import java.util.List;

import io.egen.movieflix.entity.UserRating;

public interface UserRatingRepository {

	public List<UserRating> findAll();

	public List<UserRating> findAllUserRatingsByMovieId(String id);
	
	public UserRating findOne(String id);
	
	public UserRating create(UserRating userRating);
	
	public UserRating update(UserRating userRating);
	
	public void delete(UserRating userRating);

}
