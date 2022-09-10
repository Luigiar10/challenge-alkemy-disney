package com.alkemy.challenge.service.impl;

import com.alkemy.challenge.dto.MovieDTO;
import com.alkemy.challenge.entity.Movie;
import com.alkemy.challenge.mapper.MovieMapper;
import com.alkemy.challenge.repository.MovieRepository;
import com.alkemy.challenge.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieMapper movieMapper;

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @Override
    public MovieDTO getMovieById(Long idMovie) {
        return movieMapper.movieToMovieDto(movieRepository.findById(idMovie).orElseThrow(()->new RuntimeException("Not Found")));
    }

    @Override
    public MovieDTO saveMovie(MovieDTO movieDTO) {
        return movieMapper.movieToMovieDto(movieRepository.save(movieMapper.movieDtoToMovie(movieDTO)));
    }

    @Override
    public Object deleteMovieById(Long idMovie) {
        MovieDTO movieToDelete = getMovieById(idMovie);
        movieRepository.deleteById(movieToDelete.getIdMovie());
        Map<String, String> message = new HashMap<>();
        message.put("message", "movie deleted successful");
        return message;
    }

    @Override
    public MovieDTO updateMovieById(Long idMovie, MovieDTO movieDTO) {
        return null;
    }

    public List<MovieDTO> getMovieByName(String name) {
        return movieRepository.findByName(name);
    }

    public List<MovieDTO> getMovieByGenre(Long idGenre) {
        return movieRepository.findByGenreIdGenre(idGenre);
    }
}
