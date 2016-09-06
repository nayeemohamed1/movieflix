package io.egen.movieflix.service;

import java.util.List;

import io.egen.movieflix.entity.Movie;

public interface MovieService {
	
	public List<Movie> findAll();
	
	public Movie findOne(String id);
	
	public Movie create(Movie mov);
	
	public Movie update(String id, Movie mov );
	
	public void delete(String id);
	
	public List<Movie> findByType(String type);
	
	public List<Movie> findByYear(int year);
	
	public List<Movie> findByGenre(String genre);
	
	public Movie findByTitle(String title);

	public List<Movie> sortByImdbRatings();
	
	public List<Movie> sortByYear();
	
	public List<Movie> sortByImdbVotes();
	
	public List<Movie> topRatedMovies();
	
	public List<Movie> topRatedSeries();
	
}
