package com.alkemy.challenge.mapper;

import com.alkemy.challenge.dto.GenreDTO;
import com.alkemy.challenge.entity.Genre;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    Genre genreDtoToEntity(GenreDTO genreDTO);
    GenreDTO genreToGenreDto(Genre genre);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(GenreDTO genreDTO, @MappingTarget Genre genre);
}
