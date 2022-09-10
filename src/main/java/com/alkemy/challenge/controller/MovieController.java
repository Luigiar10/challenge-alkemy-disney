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
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAll() {
        return new ResponseEntity<>(movieService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{idMovie}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable Long idMovie) {
        return new ResponseEntity<>(movieService.getMovieById(idMovie), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MovieDTO> saveMovie(@RequestBody MovieDTO movieDTO) {
        return new ResponseEntity<>(movieService.saveMovie(movieDTO), HttpStatus.CREATED);
    }

    public ResponseEntity<Object> deleteMovieById(Long idMovie) {
        return new ResponseEntity<>(movieService.deleteMovieById(idMovie), HttpStatus.ACCEPTED);
    }

    @GetMapping(
            params = "genre"
    )
    public ResponseEntity<List<MovieDTO>> getMovieByGenre(@RequestParam(name = "genre") Long idGenre){
        return new ResponseEntity<>(movieService.getMovieByGenre(idGenre), HttpStatus.OK);
    }

    @GetMapping(
            params = "name"
    )
    public ResponseEntity<List<MovieDTO>> getMovieByName(@RequestParam String name){
        return new ResponseEntity<>(movieService.getMovieByName(name), HttpStatus.OK);
    }


}
