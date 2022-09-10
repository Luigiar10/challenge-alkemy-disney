package com.alkemy.challenge.repository;

import com.alkemy.challenge.dto.MovieDTO;
import com.alkemy.challenge.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<MovieDTO> findByName(String name);
    List<MovieDTO> findByGenreIdGenre(Long idGenre);
}
