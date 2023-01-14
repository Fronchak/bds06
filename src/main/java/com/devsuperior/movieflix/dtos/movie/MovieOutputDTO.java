package com.devsuperior.movieflix.dtos.movie;

import com.devsuperior.movieflix.dtos.genre.GenreOutputAllDTO;

public class MovieOutputDTO extends MovieOutputAllDTO {

	private static final long serialVersionUID = 1L;
	
	private String synopsis;
	private GenreOutputAllDTO genre;
	
	public String getSynopsis() {
		return synopsis;
	}
	
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	public GenreOutputAllDTO getGenre() {
		return genre;
	}
	
	public void setGenre(GenreOutputAllDTO genre) {
		this.genre = genre;
	}
}
