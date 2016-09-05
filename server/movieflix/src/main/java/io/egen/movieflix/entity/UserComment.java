package io.egen.movieflix.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name="UserComment.findAll", query="SELECT uc from UserComment uc"),
	@NamedQuery(name="UserComment.findAllUserCommentsByMovieId", query="SELECT uc from UserComment uc")
})
public class UserComment {
	
	@Id
	@GenericGenerator(name="customUUID", strategy="uuid2" )
	@GeneratedValue(generator="customUUID")
	private String id;
	
	private String comment;

	@ManyToOne
	private Movie movie;
	
	@ManyToOne
	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
