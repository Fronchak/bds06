package com.devsuperior.movieflix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.dtos.review.ReviewOutputAllDTO;
import com.devsuperior.movieflix.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	@Query("SELECT new com.devsuperior.movieflix.dtos.review.ReviewOutputAllDTO(" +
			"obj.id, obj.text, obj.user.id, obj.user.name) " +
			"FROM Review obj WHERE obj.movie.id = :idMovie")
	List<ReviewOutputAllDTO> findByMovie(Long idMovie);
}
