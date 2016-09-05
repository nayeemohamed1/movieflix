package io.egen.movieflix.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name="UserRating.findAll", query="SELECT ur from UserRating ur ORDER BY ur.userRating desc"),
	@NamedQuery(name="UserRating.findAllUserRatingsByMovieId", query="SELECT ur from UserRating ur ORDER BY ur.userRating desc"),
	
})

public class UserRating {
	
	
	@Id
	@GenericGenerator(name="customUUID", strategy="uuid2")
	@GeneratedValue(generator="customUUID")
	private String id;

	private int userRating;
	
	@OneToOne
	private Movie movie;
	

	@OneToOne
	private User user;
	
	public int getUserRating() {
		return userRating;
	}

	public void setUserRating(int userRating) {
		this.userRating = userRating;
	}
	
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser(){
		return user;
	}
	
	public void setUser(User user) {
		this.user=user;
	}
	
	
	
}
