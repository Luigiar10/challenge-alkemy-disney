package com.alkemy.challenge.service;

import com.alkemy.challenge.dto.GenreDTO;
import com.alkemy.challenge.entity.Genre;

import java.util.List;

public interface IGenreService {
    List<Genre> getAll();
    GenreDTO getGenreById(Long idGenre);
    GenreDTO saveGenre(GenreDTO genreDTO);
    Object deleteGenreById(Long idGenre);
    GenreDTO updateGenreById(Long idGenre, GenreDTO genreDTO);
}
