package com.devsuperior.movieflix.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dtos.genre.GenreOutputAllDTO;
import com.devsuperior.movieflix.dtos.movie.MovieOutputDTO;
import com.devsuperior.movieflix.entities.Movie;

@Service
public class MovieMapper {

	@Autowired
	private GenreMapper genreMapper;
	
	public MovieOutputDTO convertMovieEntityToMovieOutputDTO(Movie entity) {
		MovieOutputDTO dto = new MovieOutputDTO();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setSubTitle(entity.getSubTitle());
		dto.setImgUrl(entity.getImgUrl());
		dto.setSynopsis(entity.getSynopsis());
		dto.setYear(entity.getLauchYear());
		GenreOutputAllDTO genreDTO = genreMapper.convertGenreEntityToGenreOutputAllDTO(entity.getGenre());
		dto.setGenre(genreDTO);
		return dto;
	}
}
