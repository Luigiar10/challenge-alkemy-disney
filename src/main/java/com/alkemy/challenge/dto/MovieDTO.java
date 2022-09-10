package com.alkemy.challenge.dto;

import com.alkemy.challenge.entity.Genre;

import java.io.Serializable;

public class MovieDTO implements Serializable {
    private Long idMovie;
    private String image;
    private String name;
    private String createdAt;
    private Integer qualification;
    private Genre genre;

    public MovieDTO(Long idMovie, String image, String name, String createdAt, Integer qualification, Genre genre) {
        this.idMovie = idMovie;
        this.image = image;
        this.name = name;
        this.createdAt = createdAt;
        this.qualification = qualification;
        this.genre = genre;
    }

    public MovieDTO() {
    }

    public Long getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Long idMovie) {
        this.idMovie = idMovie;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getQualification() {
        return qualification;
    }

    public void setQualification(Integer qualification) {
        this.qualification = qualification;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
