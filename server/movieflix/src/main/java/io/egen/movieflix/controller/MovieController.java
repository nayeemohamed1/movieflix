package io.egen.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.entity.Movie;
import io.egen.movieflix.service.MovieService;

@RestController
@RequestMapping(path="movies")

public class MovieController {
	
	@Autowired
	MovieService movieService;

	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAll(){
		return movieService.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findOne(@PathVariable("id") String movieId){
		return movieService.findOne(movieId);
	}
	
	@RequestMapping(method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie create(@RequestBody Movie mov){
		return movieService.create(mov);
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="{title}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie update(@PathVariable("title") String title, @RequestBody Movie mov){
		return movieService.update(title, mov);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path="{id}")
	public void delete(@PathVariable("id") String movieId){
		movieService.delete(movieId);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="findbytype/{type}")
	public List<Movie> findByType(@PathVariable("type") String type){
		return movieService.findByType(type);
	}
	
	//filter the catalog
	
	@RequestMapping(method=RequestMethod.GET, path="findbyyear/{year}")
	public List<Movie> findByYear(@PathVariable("year") int year){
		return movieService.findByYear(year);
		}
	
	@RequestMapping(method=RequestMethod.GET, path="findbygenre/{genre}")
	public List<Movie> findByGenre(@PathVariable("genre") String genre){
		return movieService.findByGenre(genre);
	}

	@RequestMapping(method=RequestMethod.GET, path="findbytitle/{title}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Movie findByTitle(@PathVariable("title") String title){
		return movieService.findByTitle(title);
	
	}
	//Sort the catalog
		
	@RequestMapping(method=RequestMethod.GET, path="sortbyimdbratings", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortByImdbRating(){
		return movieService.sortByImdbRatings();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="sortbyyears", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)	
	public List<Movie> sortByYear(){
		return movieService.sortByYear();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="sortbyimdbvotes", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortByImdbVote(){
		return movieService.sortByImdbVotes();
	}
 	
	@RequestMapping(method=RequestMethod.GET, path="topmovies", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> topRatedMovies(){
		return movieService.topRatedMovies();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="topseries", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> topRatedSeries(){
		return movieService.topRatedSeries();
	}
}		
	
	
