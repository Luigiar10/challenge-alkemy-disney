package com.alkemy.challenge.controller;

import com.alkemy.challenge.dto.GenreDTO;
import com.alkemy.challenge.entity.Genre;
import com.alkemy.challenge.service.impl.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/genres")
    public ResponseEntity<List<Genre>> getAll() {
        return new ResponseEntity<>(genreService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/genres/{idGenre}")
    public ResponseEntity<GenreDTO> getGenreById(@PathVariable Long idGenre) {
        return new ResponseEntity<>(genreService.getGenreById(idGenre), HttpStatus.OK);
    }

    @PostMapping("/genres")
    public ResponseEntity<GenreDTO> saveGenre(@RequestBody GenreDTO genreDTO) {
        return new ResponseEntity<>(genreService.saveGenre(genreDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/genres/{idGenre}")
    public ResponseEntity<Object> deleteGenreById(@PathVariable Long idGenre) {
        return new ResponseEntity<>(genreService.deleteGenreById(idGenre), HttpStatus.ACCEPTED);
    }

    @PutMapping("/genres/{idGenre}")
    public ResponseEntity<GenreDTO> updateGenreById(@PathVariable Long idGenre, @RequestBody GenreDTO genreDTO) {
        return new ResponseEntity<>(genreService.updateGenreById(idGenre, genreDTO), HttpStatus.ACCEPTED);
    }

}
