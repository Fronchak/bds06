package com.devsuperior.movieflix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dtos.movie.MovieOutputAllDTO;
import com.devsuperior.movieflix.dtos.movie.MovieOutputDTO;
import com.devsuperior.movieflix.dtos.review.ReviewOutputAllDTO;
import com.devsuperior.movieflix.services.MovieService;
import com.devsuperior.movieflix.services.ReviewService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

	@Autowired
	private MovieService service;
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieOutputDTO> findById(@PathVariable Long id) {
		MovieOutputDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping
	public ResponseEntity<Page<MovieOutputAllDTO>> findByGenre(
			@RequestParam(name = "genreId", defaultValue = "0") Long idGenre,
			Pageable pageable) {
		Page<MovieOutputAllDTO> page = service.findByGenre(idGenre, pageable);
		return ResponseEntity.ok().body(page);
	}
	
	@GetMapping(value = "/{idMovie}/reviews")
	public ResponseEntity<List<ReviewOutputAllDTO>> review(@PathVariable Long idMovie) {
		List<ReviewOutputAllDTO> list = reviewService.findByMovie(idMovie);
		return ResponseEntity.ok().body(list);
	}
}
