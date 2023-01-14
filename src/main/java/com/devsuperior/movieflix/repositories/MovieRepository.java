package com.devsuperior.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.dtos.movie.MovieOutputAllDTO;
import com.devsuperior.movieflix.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

	@Query("SELECT new com.devsuperior.movieflix.dtos.movie.MovieOutputAllDTO(obj.id, obj.title, obj.subTitle, obj.lauchYear, obj.imgUrl) " +
			"FROM Movie obj WHERE (:idGenre = 0L OR obj.genre.id = :idGenre) ORDER BY obj.title ASC")
	Page<MovieOutputAllDTO> findByGenre(Long idGenre, Pageable pageable);
}
