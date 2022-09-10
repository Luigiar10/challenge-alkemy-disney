package com.alkemy.challenge.dto;

import com.alkemy.challenge.entity.Movie;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional(readOnly = true)
public class CharacterDTO implements Serializable {
    private Long idCharacter;
    private String image;
    private String name;
    private Integer age;
    private Integer weight;
    private String history;
    private List<Movie> movies;

    public CharacterDTO(Long idCharacter, String image, String name, Integer age, Integer weight, String history, List<Movie> movies) {
        this.idCharacter = idCharacter;
        this.image = image;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.history = history;
        this.movies = movies;
    }

    public CharacterDTO() {
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

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
