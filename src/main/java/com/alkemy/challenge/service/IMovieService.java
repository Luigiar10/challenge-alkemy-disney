package com.alkemy.challenge.service;

import com.alkemy.challenge.dto.MovieDTO;
import com.alkemy.challenge.entity.Movie;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IMovieService {
    List<Movie> getAll();
    MovieDTO getMovieById(Long idMovie);
    MovieDTO saveMovie(MovieDTO movieDTO);
    Object deleteMovieById(Long idMovie);
    MovieDTO updateMovieById(Long idMovie, MovieDTO movieDTO);
}
