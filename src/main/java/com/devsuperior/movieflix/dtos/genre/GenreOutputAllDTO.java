package com.devsuperior.movieflix.dtos.genre;

import java.io.Serializable;

import com.devsuperior.movieflix.entities.Genre;

public class GenreOutputAllDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	public GenreOutputAllDTO() {}
	
	public GenreOutputAllDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public GenreOutputAllDTO(Genre entity) {
		this(entity.getId(), entity.getName());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
