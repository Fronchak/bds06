package com.devsuperior.movieflix.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.devsuperior.movieflix.dtos.review.ReviewOutputAllDTO;

@DataJpaTest
public class ReviewRepositoryTest {

	@Autowired
	private ReviewRepository repository;
	
	@Test
	public void findByMovieShouldReturnMoviesReviews() {
		List<ReviewOutputAllDTO> list = repository.findByMovie(1L);
		
		ReviewOutputAllDTO result = list.get(0);
		assertEquals(1L, result.getId());
		assertEquals("Meh, filme OK", result.getText());
		assertEquals(1L, result.getUser().getId());
		assertEquals("Bob", result.getUser().getName());
		
		result = list.get(1);
		assertEquals(2L, result.getId());
		assertEquals("Gostei e recomendo!", result.getText());
		assertEquals(1L, result.getUser().getId());
		assertEquals("Bob", result.getUser().getName());
	}
	
	@Test
	public void findByMovieShouldReturnMoviesReviews2() {
		List<ReviewOutputAllDTO> list = repository.findByMovie(2L);
		
		ReviewOutputAllDTO result = list.get(0);
		assertEquals(3L, result.getId());
		assertEquals("Que Filme!!!", result.getText());
		assertEquals(1L, result.getUser().getId());
		assertEquals("Bob", result.getUser().getName());
	}
}
