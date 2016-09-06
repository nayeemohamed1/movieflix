package io.egen.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.entity.Movie;

@Repository
public class MovieRepositoryImplementation implements MovieRepository{
	
	@PersistenceContext
	EntityManager em1;

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query=em1.createNamedQuery("Movie.findAll",Movie.class);
		return query.getResultList();
	}

		
	@Override
	public Movie findOne(String id) {
		return em1.find(Movie.class, id);
	}
	
	@Override
	public Movie findByTitle(String title) {
		TypedQuery<Movie> query=em1.createNamedQuery("Movie.findByTitle",Movie.class);
		query.setParameter("pTitle", title);
		List<Movie> movies=query.getResultList();
		if(movies!=null && movies.size()==1)
		{
			return movies.get(0);
		}
		
		return null;
	}

	@Override
	public Movie create(Movie mov) {
		em1.persist(mov);
		return mov;
	}

	@Override
	public Movie update(Movie mov) {
		return em1.merge(mov);
	}

	@Override
	public void delete(Movie mov) {
		em1.remove(mov);
		
	}


	@Override
	public List<Movie> findByType(String type) {
		TypedQuery<Movie> query=em1.createNamedQuery("Movie.findByType",Movie.class);
		query.setParameter("pType", type);
		List<Movie> movies=query.getResultList();
		if(movies!=null && movies.size()>0)
		{
			return movies;
		}
				return null;
	}


	@Override
	public List<Movie> findByYear(int year) {
		TypedQuery<Movie> query=em1.createNamedQuery("Movie.findByYear", Movie.class);
		query.setParameter("pYear", year);
		List<Movie> movies=query.getResultList();
		
		if(movies!=null && movies.size()>0){
			return movies;
		}
		
		
		return null;
	}


	@Override
	public List<Movie> findByGenre(String genre) {
		TypedQuery<Movie> query=em1.createNamedQuery("Movie.findByGenre",Movie.class);
		query.setParameter("pGenre", genre);
		List<Movie> movies=query.getResultList();
		if(movies!=null && movies.size()>0)
		{
			return movies;
		}
		return null;
	}


	@Override
	public List<Movie> sortByImdbRatings() {
		TypedQuery<Movie> query=em1.createNamedQuery("Movie.sortByImdbRatings",Movie.class);
		List<Movie> movies=query.getResultList();
		
		if(movies!=null && movies.size()>0)
		{
			return movies;
		}
		
		return null;
	}


	@Override
	public List<Movie> sortByYear() {
		TypedQuery<Movie> query=em1.createNamedQuery("Movie.sortByYear",Movie.class);
		List<Movie> movies=query.getResultList();
		
		if(movies!=null && movies.size()>0){
			return movies;
		}
		
		return null;
	}


	@Override
	public List<Movie> sortByImdbVotes() {
		TypedQuery<Movie> query=em1.createNamedQuery("Movie.sortByImdbVotes",Movie.class);
		List<Movie> movies=query.getResultList();
		
		if(movies!=null && movies.size()>0){
			return movies;
		}
		
		return null;
	}

	
}
