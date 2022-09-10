package com.alkemy.challenge.controller;

import com.alkemy.challenge.dto.CharacterDTO;
import com.alkemy.challenge.entity.Character;
import com.alkemy.challenge.service.impl.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/characters")
    public ResponseEntity<List<Character>> getAll() {
        return new ResponseEntity<>(characterService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/characters/{idCharacter}")
    public ResponseEntity<CharacterDTO> getCharacterById(@PathVariable Long idCharacter) {
        return new ResponseEntity<>(characterService.getCharacterById(idCharacter), HttpStatus.OK);
    }

    @PostMapping("/characters")
    public ResponseEntity<CharacterDTO> saveCharacter(@RequestBody CharacterDTO characterDTO) {
        return new ResponseEntity<>(characterService.saveCharacter(characterDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/characters/{idCharacter}")
    public ResponseEntity<Object> deleteCharacterById(@PathVariable Long idCharacter) {
        return new ResponseEntity<>(characterService.deleteCharacterById(idCharacter), HttpStatus.ACCEPTED);
    }

    @PutMapping("/characters/{idCharacter}")
    public ResponseEntity<CharacterDTO> updateCharacterById(@PathVariable Long idCharacter, @RequestBody CharacterDTO characterDTO) {
        return new ResponseEntity<>(characterService.updateCharacterById(idCharacter, characterDTO), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/characters", params = "name")
    public ResponseEntity<List<Character>> getCharactersByName(@RequestParam String name) {
        return new ResponseEntity<>(characterService.getCharactersByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "/characters", params = "age")
    public ResponseEntity<List<Character>> getCharactersByAge(@RequestParam Integer age) {
        return new ResponseEntity<>(characterService.getCharactersByAge(age), HttpStatus.OK);
    }

    @GetMapping(value = "/characters", params = "movies")
    public ResponseEntity<List<Character>> getCharactersByMovie(@RequestParam(name = "movies") Long idMovie) {
        return new ResponseEntity<>(characterService.getCharactersByMoviesIdMovie(idMovie), HttpStatus.OK);
    }

}
