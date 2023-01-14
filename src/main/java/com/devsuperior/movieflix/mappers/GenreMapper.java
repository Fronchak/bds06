package com.devsuperior.movieflix.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dtos.genre.GenreOutputAllDTO;
import com.devsuperior.movieflix.entities.Genre;

@Service
public class GenreMapper {

	public List<GenreOutputAllDTO> convertEntityListToGenreOutputDTOList(List<Genre> list) {
		return list.stream()
				.map(entity -> new GenreOutputAllDTO(entity))
				.collect(Collectors.toList());
	}
}
