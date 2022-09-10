package com.alkemy.challenge.repository;

import com.alkemy.challenge.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    List<Character> findByNameStartingWith(String name);
    List<Character> findByAge(Integer age);
    List<Character> findByMoviesIdMovie(Long idMovie);
}
