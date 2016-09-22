package io.egen.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.Movie;
import io.egen.movieflix.entity.User;
import io.egen.movieflix.entity.UserComment;
import io.egen.movieflix.exception.MovieNotFoundException;
import io.egen.movieflix.exception.UserCommentNotFoundException;
import io.egen.movieflix.exception.UserNotFoundException;
import io.egen.movieflix.repository.UserCommentRepository;

@Service
@Transactional
public class UserCommentServiceImplementation implements UserCommentService{

	@Autowired
	UserCommentRepository userCommentRepository;
	
	@Autowired
	MovieService movieService;
	
	@Autowired
	UserService userService;
	
	@Override
	public List<UserComment> findAll() {
		return userCommentRepository.findAll();
	}

	@Override
	public List<UserComment> findAllUserCommentsByMovieId(String id) {
		Movie existing=movieService.findOne(id);
		if(existing==null){
			throw new UserCommentNotFoundException("User Comments for movie id:"+id+" Not Found");
		}
		
		return userCommentRepository.findAllUserCommentsByMovieId(id);
	}

	@Override
	public UserComment findOne(String id) {
		
		UserComment existing=userCommentRepository.findOne(id);
		if(existing==null){
			throw new UserCommentNotFoundException("User Comment with id:"+id+" Not Found");
			
		}
		
		return userCommentRepository.findOne(id);
	}

	@Override
	@Transactional
	public UserComment create(UserComment userComment) {
		String movieId=userComment.getMovie().getId();
		String userId=userComment.getUser().getId();
		
		Movie movie=movieService.findOne(movieId);
		User user=userService.findOne(userId);
		
		if(movie==null){
			throw new MovieNotFoundException("Movie with id:"+movieId+" Not found");
		}
		
		if(user==null){
			throw new UserNotFoundException("User with id:"+userId+" Not found");
		}
		
		userComment.setMovie(movie);
		userComment.setUser(user);
		
		return userCommentRepository.create(userComment);
	}

	@Override
	@Transactional
	public UserComment update(String id, UserComment userComment) {

		UserComment existing=userCommentRepository.findOne(id);
		
		if(existing==null){
			throw new UserCommentNotFoundException("User Comment with id:"+id+" Not found");
		}
		
		String movieId= userComment.getMovie().getId();
		String userId=userComment.getUser().getId();
		
		Movie movie=movieService.findOne(movieId);
		User user=userService.findOne(userId);
		
		if(movie==null){
			throw new MovieNotFoundException("Movie with id:"+movieId+" Not found");
		}
		
		if(user==null){
			throw new UserNotFoundException("User with id:"+userId+" Not found");
		}
		
		
		return userCommentRepository.update(userComment);
	}

	@Override
	@Transactional
	public void delete(String id) {
		UserComment existing=userCommentRepository.findOne(id);
		
		if(existing==null){
			throw new UserCommentNotFoundException("Comment with id:"+id+" Not found");
		}
		userCommentRepository.delete(existing);
	}

	
	
}
