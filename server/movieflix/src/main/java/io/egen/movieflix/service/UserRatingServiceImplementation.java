package io.egen.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.Movie;
import io.egen.movieflix.entity.User;
import io.egen.movieflix.entity.UserRating;
import io.egen.movieflix.exception.MovieNotFoundException;
import io.egen.movieflix.exception.UserNotFoundException;
import io.egen.movieflix.exception.UserRatingNotFoundException;
import io.egen.movieflix.repository.UserRatingRepository;

@Service
@Transactional
public class UserRatingServiceImplementation implements UserRatingService{
 
	@Autowired
	UserRatingRepository userRatingRepository;
	
	@Autowired
	MovieService movieService;

	@Autowired
	UserService userService;
	
	
	@Override
	public List<UserRating> findAll(){
		return userRatingRepository.findAll();
	}
	
	@Override
	public List<UserRating> findAllUserRatingsByMovieId(String id) {
		Movie existing=movieService.findOne(id);
		if(existing==null){
			throw new UserRatingNotFoundException("User Rating with movie id:"+id+" Not Found");

		}
		return userRatingRepository.findAllUserRatingsByMovieId(id) ;
	}


	
	@Override
	public UserRating findOne(String id) {
		
		UserRating existing= userRatingRepository.findOne(id);
		
		if(existing==null)
		{
			throw new UserRatingNotFoundException("User Rating with "+id+" Not Found");
		}
		return existing;
	}

	@Override
	@Transactional
	public UserRating create(UserRating userRating) {
		String movieId=userRating.getMovie().getId();
		String userId=userRating.getUser().getId();
		
		Movie movie=movieService.findOne(movieId);
		User user=userService.findOne(userId);
		
		if(movie==null){
			throw new MovieNotFoundException("Movie with id "+movieId+" Not Found");
		}
		
		if(user==null){
			throw new UserNotFoundException("User with id "+userId+" Not Found");
		}
		
		userRating.setMovie(movie);
		userRating.setUser(user);
		
		
		return userRatingRepository.create(userRating);
	}

	@Override
	@Transactional
	public UserRating update(String id, UserRating userRating) {
		
		UserRating existing=userRatingRepository.findOne(id);
		if(existing==null){
			throw new UserRatingNotFoundException("User Rating with id:"+id+" Not Found");
		}
		
		String movieId=existing.getMovie().getId();
		String userId=existing.getUser().getId();
		
		Movie movie=movieService.findOne(movieId);
		User user=userService.findOne(userId);
		
		if(movie==null){
			throw new MovieNotFoundException("Movie with id "+movieId+" Not Found");
		}
		
		if(user==null){
			throw new UserNotFoundException("User with id "+userId+" Not Found");
		}
		
		
		
		return userRatingRepository.update(userRating);
	}

	@Override
	@Transactional	
	public void delete(String id) {
	UserRating existing=userRatingRepository.findOne(id);
	
	if(existing==null){
		throw new UserRatingNotFoundException("Rating with id:"+id+" Not found");
	}
	
	userRatingRepository.delete(existing);	
	}

	@Override
	public double findAvgUserRatingsByMovieId(String id) {
		
		List<UserRating> existing=userRatingRepository.findAllUserRatingsByMovieId(id);
		
		if(existing.size()==0){

			throw new UserRatingNotFoundException("User ratings for the id:"+id+" Not found");
					}
		
		return userRatingRepository.findAvgUserRatingsByMovieId(id);
 
	}

	
}
