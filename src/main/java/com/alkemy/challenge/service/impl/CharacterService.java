package com.alkemy.challenge.service.impl;

import com.alkemy.challenge.dto.CharacterDTO;
import com.alkemy.challenge.entity.Character;
import com.alkemy.challenge.mapper.CharacterMapper;
import com.alkemy.challenge.repository.CharacterRepository;
import com.alkemy.challenge.repository.MovieRepository;
import com.alkemy.challenge.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CharacterService implements ICharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CharacterMapper characterMapper;

    @Override
    public List<Character> getAll() {
        return characterRepository.findAll();
    }

    @Override
    public CharacterDTO getCharacterById(Long idCharacter) {
        return characterMapper.characterToCharacterDto(characterRepository.findById(idCharacter).orElseThrow(()->new RuntimeException("Not Found")));
    }

    @Override
    public CharacterDTO saveCharacter(CharacterDTO characterDTO) {
        return characterMapper.characterToCharacterDto(characterRepository.save(characterMapper.characterDtoToCharacter(characterDTO)));
    }

    @Override
    public Object deleteCharacterById(Long idCharacter) {
        CharacterDTO characterDTO = getCharacterById(idCharacter);
        characterRepository.deleteById(characterDTO.getIdCharacter());
        Map<String, String> message = new HashMap<>();
        message.put("message", "Character Deleted Successful");
        return message;
    }

    @Override
    public CharacterDTO updateCharacterById(Long idCharacter, CharacterDTO characterDTO) {
        CharacterDTO characterDTOToUpdate = getCharacterById(idCharacter);
        characterDTOToUpdate.setImage(characterDTO.getImage());
        characterDTOToUpdate.setName(characterDTO.getName());
        characterDTOToUpdate.setAge(characterDTO.getAge());
        characterDTOToUpdate.setWeight(characterDTO.getWeight());
        characterDTOToUpdate.setHistory(characterDTO.getHistory());
        characterRepository.save(characterMapper.characterDtoToCharacter(characterDTOToUpdate));
        return characterDTOToUpdate;
    }

    public List<Character> getCharactersByName(String name) {
        return characterRepository.findByNameStartingWith(name);
    }

    public List<Character> getCharactersByAge(Integer age) {
        return characterRepository.findByAge(age);
    }

    public List<Character> getCharactersByMoviesIdMovie(Long idMovie) {
        return characterRepository.findByMoviesIdMovie(idMovie);
    }
}
