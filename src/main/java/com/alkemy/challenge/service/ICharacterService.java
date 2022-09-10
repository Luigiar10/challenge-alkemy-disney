package com.alkemy.challenge.service;

import com.alkemy.challenge.dto.CharacterDTO;
import com.alkemy.challenge.entity.Character;

import java.util.List;

public interface ICharacterService {
    List<Character> getAll();
    CharacterDTO getCharacterById(Long idCharacter);
    CharacterDTO saveCharacter(CharacterDTO characterDTO);
    Object deleteCharacterById(Long idCharacter);
    CharacterDTO updateCharacterById(Long idCharacter, CharacterDTO characterDTO);
}
