package io.egen.movieflix.repository;

import java.util.List;

import io.egen.movieflix.entity.Movie;

public interface MovieRepository {

	public List<Movie> findAll();
	
	public Movie findOne(String id);
	
	public Movie findByTitle(String title);
	
	public Movie create(Movie mov);
	
	public Movie update(Movie mov);
	
	public void delete(Movie mov);
	
	public List<Movie> findByType(String type);
	
	public List<Movie> findByYear(int year);
	
	public List<Movie> findByGenre(String genre);
	
	public List<Movie> sortByImdbRatings();
	
	public List<Movie> sortByYear();
	
	public List<Movie> sortByImdbVotes();
	
	public List<Movie> topRatedMovies();
	
	public List<Movie> topRatedSeries();
	

}
