package com.alkemy.challenge.service.impl;

import com.alkemy.challenge.dto.GenreDTO;
import com.alkemy.challenge.entity.Genre;
import com.alkemy.challenge.mapper.GenreMapper;
import com.alkemy.challenge.repository.GenreRepository;
import com.alkemy.challenge.service.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GenreService implements IGenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private GenreMapper genreMapper;

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    @Override
    public GenreDTO getGenreById(Long idGenre) {
        return genreMapper.genreToGenreDto(genreRepository.findById(idGenre).orElseThrow(()->new RuntimeException("Not Found")));
    }

    @Override
    public GenreDTO saveGenre(GenreDTO genreDTO) {
        return genreMapper.genreToGenreDto(genreRepository.save(genreMapper.genreDtoToEntity(genreDTO)));
    }

    @Override
    public Object deleteGenreById(Long idGenre) {
        GenreDTO genreDTO = getGenreById(idGenre);
        genreRepository.deleteById(genreDTO.getIdGenre());
        Map<String, String> message = new HashMap<>();
        message.put("message", "Genre deleted successful");
        return message;
    }

    @Override
    public GenreDTO updateGenreById(Long idGenre, GenreDTO genreDTO) {
        GenreDTO genreDTOToUpdate = getGenreById(idGenre);
        genreDTOToUpdate.setName(genreDTO.getName());
        genreDTOToUpdate.setImage(genreDTO.getImage());
        genreRepository.save(genreMapper.genreDtoToEntity(genreDTOToUpdate));
        return genreDTOToUpdate;
    }
}
