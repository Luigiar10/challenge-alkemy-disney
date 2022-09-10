package com.alkemy.challenge.mapper;

import com.alkemy.challenge.dto.CharacterDTO;
import com.alkemy.challenge.entity.Character;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    Character characterDtoToCharacter(CharacterDTO characterDTO);
    CharacterDTO characterToCharacterDto(Character character);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntiry(CharacterDTO characterDTO, @MappingTarget Character character);
}
