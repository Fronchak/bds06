package com.devsuperior.movieflix.dtos.review;

import java.io.Serializable;

import com.devsuperior.movieflix.dtos.user.UserOutputDTO;

public class ReviewOutputDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String text;
	private Long movieId;
	private UserOutputDTO user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Long getMovieId() {
		return movieId;
	}
	
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	
	public UserOutputDTO getUser() {
		return user;
	}
	
	public void setUser(UserOutputDTO user) {
		this.user = user;
	}
}
