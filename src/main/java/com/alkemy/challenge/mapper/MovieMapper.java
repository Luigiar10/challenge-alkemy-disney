package com.alkemy.challenge.mapper;

import com.alkemy.challenge.dto.MovieDTO;
import com.alkemy.challenge.entity.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    Movie movieDtoToMovie(MovieDTO movieDTO);
    MovieDTO movieToMovieDto(Movie movie);
}
