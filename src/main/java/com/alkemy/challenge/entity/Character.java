package com.alkemy.challenge.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "character_table")
@Transactional(readOnly = true)
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_character")
    private Long idCharacter;
    private String image;
    private String name;
    private Integer age;
    private Integer weight;
    private String history;
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "characters")
    private List<Movie> movies;

    public Character() {
    }

    public Character(Long idCharacter, String image, String name, Integer age, Integer weight, String history, List<Movie> movies) {
        this.idCharacter = idCharacter;
        this.image = image;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.history = history;
        this.movies = movies;
    }

    public Long getIdCharacter() {
        return idCharacter;
    }

    public void setIdCharacter(Long idCharacter) {
        this.idCharacter = idCharacter;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    @JsonBackReference
    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
