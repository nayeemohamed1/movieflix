package io.egen.movieflix.service;

import java.util.List;

import io.egen.movieflix.entity.UserComment;

public interface UserCommentService {
	
	public List<UserComment> findAll();
	
	public List<UserComment> findAllUserCommentsByMovieId(String id);
	
	public UserComment findOne(String id);
	
	public UserComment create(UserComment userComment);
	
	public UserComment update(String id,UserComment update);
	
	public void delete(String id);
}
