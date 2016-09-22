package io.egen.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;


import io.egen.movieflix.entity.UserRating;

@Repository
public class UserRatingRepositoryImplementation implements UserRatingRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<UserRating> findAll(){
		TypedQuery<UserRating> query=em.createNamedQuery("UserRating.findAll",UserRating.class);
		return query.getResultList();		
	}
	
	@Override
	public List<UserRating> findAllUserRatingsByMovieId(String id) {
		TypedQuery<UserRating> query=em.createNamedQuery("UserRating.findAllUserRatingsByMovieId",UserRating.class);
		return query.getResultList();
	}


	@Override
	public UserRating findOne(String id) {

		return em.find(UserRating.class,id);
	}

	@Override
	public UserRating create(UserRating userRating) {
		em.persist(userRating);
		return userRating;
	}

	@Override
	public UserRating update(UserRating userRating) {

		return em.merge(userRating);
	}

	@Override
	public void delete(UserRating userRating) {

		em.remove(userRating);
	}

	@Override
	public double findAvgUserRatingsByMovieId(String id) {
		TypedQuery<Double> query=em.createNamedQuery("UserRating.findAvgUserRatingsByMovieId",Double.class);
		query.setParameter("pMovieId", id);
		double avg=query.getSingleResult();
				return avg;
	}

}
