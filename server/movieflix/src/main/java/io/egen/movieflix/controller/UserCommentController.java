package io.egen.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.entity.UserComment;
import io.egen.movieflix.service.UserCommentService;

@RestController 
@RequestMapping(path="usercomments")
public class UserCommentController {

	@Autowired
	UserCommentService userCommentService;
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<UserComment> findAll(){
		return userCommentService.findAll();
	}

	@RequestMapping(method=RequestMethod.GET, path="movieid/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<UserComment> findAllUserCommentsByMovieId(@PathVariable String id){
		return userCommentService.findAllUserCommentsByMovieId(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserComment findOne(@PathVariable("id") String id){
		return userCommentService.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserComment create(@RequestBody UserComment userComment){
		return userCommentService.create(userComment);
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="{id}",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserComment update(@PathVariable("id") String id, @RequestBody UserComment userComment){
		return userCommentService.update(id,userComment);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path="{id}")
	public void delete(@PathVariable("id") String id){
		userCommentService.delete(id);
	}
	
}
