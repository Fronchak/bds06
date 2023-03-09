package com.devsuperior.movieflix.dtos.review;

import java.io.Serializable;

import com.devsuperior.movieflix.dtos.user.UserSimpleOutputDTO;

public class ReviewOutputAllDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String text;
	private UserSimpleOutputDTO user;
	
	public ReviewOutputAllDTO() {}
	
	public ReviewOutputAllDTO(Long id, String text, Long idUser, String name) {
		this.id = id;
		this.text = text;
		this.user = new UserSimpleOutputDTO(idUser, name);
	}

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

	public UserSimpleOutputDTO getUser() {
		return user;
	}

	public void setUser(UserSimpleOutputDTO user) {
		this.user = user;
	}
}
