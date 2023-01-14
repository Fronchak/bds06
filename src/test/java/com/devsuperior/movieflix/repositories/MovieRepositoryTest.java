package com.devsuperior.movieflix.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.devsuperior.movieflix.dtos.movie.MovieOutputAllDTO;

@DataJpaTest
public class MovieRepositoryTest {

	@Autowired
	private MovieRepository repository;
	private Pageable pageable;
	
	@BeforeEach
	public void setUp() {
		pageable = PageRequest.of(0, 10);
	}
	
	@Test
	public void findByGenreShouldReturnMoviesPageSortedByTitleWhenNoGenreWasSpecified() {
		
		Page<MovieOutputAllDTO> page = repository.findByGenre(0L, pageable);
		List<MovieOutputAllDTO> list = page.getContent();
		
		MovieOutputAllDTO result = list.get(0);
		assertEquals(6L, result.getId());
		assertEquals("A Voz do Silêncio", result.getTitle());
		assertEquals("Koe no Katachi", result.getSubTitle());
		assertEquals("https://image.tmdb.org/t/p/w533_and_h300_bestv2/5lAMQMWpXMsirvtLLvW7cJgEPkU.jpg", result.getImgUrl());
		assertEquals(2016, result.getYear());
		
		result = list.get(1);
		assertEquals(1L, result.getId());
		assertEquals("Bob Esponja", result.getTitle());
		assertEquals("O Incrível Resgate", result.getSubTitle());
		assertEquals("https://image.tmdb.org/t/p/w533_and_h300_bestv2/wu1uilmhM4TdluKi2ytfz8gidHf.jpg", result.getImgUrl());
		assertEquals(2020, result.getYear());
		
		result = list.get(2);
		assertEquals(5L, result.getId());
		assertEquals("Código de Conduta", result.getTitle());
		
		
		result = list.get(3);
		assertEquals(7L, result.getId());
		assertEquals("Kingsman", result.getTitle());
	}
	
	@Test
	public void findByGenreShouldReturnPageFilterByGenreAndSortedByTitle() {
		Page<MovieOutputAllDTO> page = repository.findByGenre(2L, pageable);
		List<MovieOutputAllDTO> list = page.getContent();
		
		MovieOutputAllDTO result = list.get(0);
		assertEquals(2L, result.getId());
		assertEquals("O Orfanato", result.getTitle());
		assertNull(result.getSubTitle());
		assertEquals("https://image.tmdb.org/t/p/w533_and_h300_bestv2/2AlVaQDH67RgulE2AqXBSPr2POF.jpg", result.getImgUrl());
		assertEquals(2007, result.getYear());
		
		result = list.get(1);
		assertEquals(10L, result.getId());
		assertEquals("O Segredo da Cabana", result.getTitle());
		assertNull(result.getSubTitle());
		assertEquals("https://image.tmdb.org/t/p/w533_and_h300_bestv2/5iiVfPS6LsAqmVQVOzhyCHhCFgU.jpg", result.getImgUrl());
		assertEquals(2012, result.getYear());
		
		result = list.get(2);
		assertEquals(9L, result.getId());
		assertEquals("Uma Noite de Crime", result.getTitle());
	}
}
