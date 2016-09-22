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

	@Override
	public List<Movie> findByType(String type) {
			
		return movieRepository.findByType(type);
	}

	@Override
	public List<Movie> findByYear(int year) {
		return movieRepository.findByYear(year);
	}

	@Override
	public List<Movie> findByGenre(String genre) {
		return movieRepository.findByGenre(genre);
	}

	@Override
	public Movie findByTitle(String title) {
		return movieRepository.findByTitle(title);
	}

	@Override
	public List<Movie> sortByImdbRatings() {
		return movieRepository.sortByImdbRatings();
	}

	@Override
	public List<Movie> sortByYear() {
		return movieRepository.sortByYear();
	}

	@Override
	public List<Movie> sortByImdbVotes() {
		return movieRepository.sortByImdbVotes();
	}

	@Override
	public List<Movie> topRatedMovies(){
		return movieRepository.topRatedMovies();
	}
	@Override
	public List<Movie> topRatedSeries() {

		return movieRepository.topRatedSeries();
	}


}
