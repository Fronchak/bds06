package com.devsuperior.movieflix.dtos.user;

import java.io.Serializable;

import com.devsuperior.movieflix.entities.User;

public class UserSimpleOutputDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	public UserSimpleOutputDTO() {}
	
	public UserSimpleOutputDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public UserSimpleOutputDTO(User entity) {
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
