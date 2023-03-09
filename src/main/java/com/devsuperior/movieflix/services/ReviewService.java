package com.devsuperior.movieflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dtos.review.ReviewDTO;
import com.devsuperior.movieflix.dtos.review.ReviewOutputAllDTO;
import com.devsuperior.movieflix.dtos.review.ReviewOutputDTO;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.mappers.ReviewMapper;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private ReviewMapper mapper;
	
	@Transactional
	public ReviewOutputDTO save(ReviewDTO insertDTO) {
		Review entity = new Review();
		copyDTOToEntity(insertDTO, entity);
		entity = repository.save(entity);
		return mapper.convertReviewEntityToReviewOutputDTO(entity);
	}
	
	private void copyDTOToEntity(ReviewDTO inputDTO, Review entity) {
		mapper.copyDTOToEntity(inputDTO, entity);
		entity.setMovie(movieRepository.getOne(inputDTO.getMovieId()));
		entity.setUser(authService.authenticated());
	}
	 
	@Transactional(readOnly = true)
	public List<ReviewOutputAllDTO> findByMovie(Long idMovie) {
		return repository.findByMovie(idMovie);
	}
}
