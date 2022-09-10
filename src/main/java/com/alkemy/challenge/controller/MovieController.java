package com.alkemy.challenge.controller;

import com.alkemy.challenge.dto.MovieDTO;
import com.alkemy.challenge.entity.Movie;
import com.alkemy.challenge.service.impl.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAll() {
        return new ResponseEntity<>(movieService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/movies/{idMovie}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable Long idMovie) {
        return new ResponseEntity<>(movieService.getMovieById(idMovie), HttpStatus.OK);
    }

    @PostMapping("/movies")
    public ResponseEntity<MovieDTO> saveMovie(@RequestBody MovieDTO movieDTO) {
        return new ResponseEntity<>(movieService.saveMovie(movieDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/movies/{idMovie}")
    public ResponseEntity<Object> deleteMovieById(@PathVariable Long idMovie) {
        return new ResponseEntity<>(movieService.deleteMovieById(idMovie), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/movies", params = "genre")
    public ResponseEntity<List<Movie>> getMovieByGenre(@RequestParam(name = "genre") Long idGenre){
        return new ResponseEntity<>(movieService.getMovieByGenre(idGenre), HttpStatus.OK);
    }

    @GetMapping(value = "/movies", params = "name")
    public ResponseEntity<List<Movie>> getMovieByName(@RequestParam String name){
        return new ResponseEntity<>(movieService.getMovieByName(name), HttpStatus.OK);
    }


}
