package com.devsuperior.movieflix.dtos.review;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class ReviewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "Movie's review cannot be empty")
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
