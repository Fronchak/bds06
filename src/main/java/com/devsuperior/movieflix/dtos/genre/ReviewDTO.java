package com.devsuperior.movieflix.dtos.genre;

import java.io.Serializable;

public class ReviewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String text;
	private Long movieId;
	
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
}
