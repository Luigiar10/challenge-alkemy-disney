package com.alkemy.challenge.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movie_table")
@Transactional(readOnly = true)
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movie")
    private Long idMovie;
    private String image;
    private String name;
    @Column(name = "created_at")
    private String createdAt;
    private Integer qualification;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_genre")
    private Genre genre;
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "movie_character",
            joinColumns = { @JoinColumn(name = "id_movie") },
            inverseJoinColumns = { @JoinColumn(name = "id_character") }
    )
    private List<Character> characters;

    public Movie(Long idMovie, String image, String name, String createdAt, Integer qualification, Genre genre, List<Character> characters) {
        this.idMovie = idMovie;
        this.image = image;
        this.name = name;
        this.createdAt = createdAt;
        this.qualification = qualification;
        this.genre = genre;
        this.characters = characters;
    }

    public Movie() {
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

    @JsonBackReference
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    //@JsonManagedReference
    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
