package com.alkemy.challenge.dto;

import com.alkemy.challenge.entity.Movie;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

public class GenreDTO implements Serializable {
    private Long idGenre;
    @NotEmpty
    private String name;
    @NotEmpty
    private String image;
    private List<Movie> movies;

    public GenreDTO(Long idGenre, String name, String image, List<Movie> movies) {
        this.idGenre = idGenre;
        this.name = name;
        this.image = image;
        this.movies = movies;
    }

    public GenreDTO() {
    }

    public Long getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Long idGenre) {
        this.idGenre = idGenre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
