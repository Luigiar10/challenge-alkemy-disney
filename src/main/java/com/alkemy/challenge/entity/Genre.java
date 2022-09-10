package com.alkemy.challenge.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genre_table")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genre")
    private Long idGenre;
    private String name;
    private String image;
    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Movie> movies;

    public Genre(Long idGenre, String name, String image, List<Movie> movies) {
        this.idGenre = idGenre;
        this.name = name;
        this.image = image;
        this.movies = movies;
    }

    public Genre() {
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

    //@JsonManagedReference
    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
