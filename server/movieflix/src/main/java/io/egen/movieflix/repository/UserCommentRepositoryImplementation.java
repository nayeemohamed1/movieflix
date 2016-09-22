package io.egen.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.entity.UserComment;

@Repository
public class UserCommentRepositoryImplementation implements UserCommentRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<UserComment> findAll() {
		TypedQuery<UserComment> query=em.createNamedQuery("UserComment.findAll", UserComment.class);
				return query.getResultList();
		 
	}

	@Override
	public List<UserComment> findAllUserCommentsByMovieId(String id) {
		TypedQuery<UserComment> query=em.createNamedQuery("UserComment.findAllUserCommentsByMovieId",UserComment.class);
		return query.getResultList();
	}

	@Override
	public UserComment findOne(String id) {
		return em.find(UserComment.class, id);
	}

	@Override
	public UserComment create(UserComment userComment) {
		em.persist(userComment);
		return userComment;
	}

	@Override
	public UserComment update(UserComment userComment) {
		return em.merge(userComment);
	}

	@Override
	public void delete(UserComment userComment) {
		em.remove(userComment);
	}

	
	
}
