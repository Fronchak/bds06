package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dtos.movie.MovieOutputDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.exceptions.ResourceNotFoundException;
import com.devsuperior.movieflix.mappers.MovieMapper;
import com.devsuperior.movieflix.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;
	
	@Autowired
	private MovieMapper mapper;
	
	@Transactional(readOnly = true)
	public MovieOutputDTO findById(Long id) {
		Movie entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Movie", id.toString()));
		return mapper.convertMovieEntityToMovieOutputDTO(entity);
	}
}
