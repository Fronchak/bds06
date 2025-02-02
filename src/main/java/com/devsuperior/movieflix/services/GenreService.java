package com.devsuperior.movieflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dtos.genre.GenreOutputAllDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.mappers.GenreMapper;
import com.devsuperior.movieflix.repositories.GenreRepository;

@Service
public class GenreService {

	@Autowired
	private GenreRepository repository;
	
	@Autowired
	private GenreMapper mapper;
	
	@Transactional(readOnly = true)
	public List<GenreOutputAllDTO> findAll() {
		List<Genre> list = repository.findAll();
		return mapper.convertGenreEntityListToGenreOutputDTOList(list);
	}
}
