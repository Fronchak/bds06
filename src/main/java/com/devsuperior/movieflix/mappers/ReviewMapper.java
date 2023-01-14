package com.devsuperior.movieflix.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dtos.review.ReviewDTO;
import com.devsuperior.movieflix.dtos.review.ReviewOutputDTO;
import com.devsuperior.movieflix.dtos.user.UserOutputDTO;
import com.devsuperior.movieflix.entities.Review;

@Service
public class ReviewMapper {

	@Autowired
	private UserMapper userMapper;
	
	public ReviewOutputDTO convertReviewEntityToReviewOutputDTO(Review entity) {
		ReviewOutputDTO dto = new ReviewOutputDTO();
		dto.setId(entity.getId());
		dto.setText(entity.getText());
		dto.setMovieId(entity.getMovie().getId());
		UserOutputDTO userDTO = userMapper.convertEntityToOutputDTO(entity.getUser());
		dto.setUser(userDTO);
		return dto;
	}
	
	public void copyDTOToEntity(ReviewDTO dto, Review entity) {
		entity.setText(dto.getText());
	}
}
