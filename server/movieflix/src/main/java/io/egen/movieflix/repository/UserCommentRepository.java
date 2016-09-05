package io.egen.movieflix.repository;

import java.util.List;

import io.egen.movieflix.entity.UserComment;

public interface UserCommentRepository {
	
	public List<UserComment> findAll();
	
	public List<UserComment> findAllUserCommentsByMovieId(String id);
	
	public UserComment findOne(String id);
	
	public UserComment create(UserComment userComment);
	
	public UserComment update(UserComment userComment);
	
	public void delete(UserComment userComment);

}
