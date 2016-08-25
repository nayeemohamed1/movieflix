package io.egen.movieflix.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.Movie;
import io.egen.movieflix.exception.MovieAlreadyExistsException;
import io.egen.movieflix.exception.MovieNotFoundException;
import io.egen.movieflix.repository.MovieRepository;

@Service
public class MovieServiceImplementation implements MovieService{

	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	@Override
	@Transactional
	public Movie findOne(String id) {
		Movie existing= movieRepository.findOne(id);
			if(existing==null){
			  throw new MovieNotFoundException("Movie with id:"+id+" Not found ");
			}
			return existing;
	}

	@Override
	@Transactional
	public Movie create(Movie mov) {
		
		Movie existing= movieRepository.findByTitle(mov.getTitle());
		if(existing!=null){
			  throw new MovieAlreadyExistsException("Movie with title:"+mov.getTitle()+" is already in Use");
			}
			return movieRepository.create(mov);
		
	}

	@Override
	@Transactional
	public Movie update(String id, Movie mov) {
		Movie existing= movieRepository.findOne(id);
		if(existing==null){
		  throw new MovieNotFoundException("Movie with id:"+id+" Not found ");
		}
		return movieRepository.update(mov);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Movie existing= movieRepository.findOne(id);
		if(existing==null){
		  throw new MovieNotFoundException("Movie with id:"+id+" Not found ");
		}
		movieRepository.delete(existing);
	}

}
