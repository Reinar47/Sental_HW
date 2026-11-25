package ru.sental.mainmodulespring.mapper;

import org.mapstruct.Mapper;
import ru.sental.mainmodulespring.dto.request.CharacterClassRequest;
import ru.sental.mainmodulespring.dto.response.CharacterClassResponse;
import ru.sental.mainmodulespring.entity.CharacterClass;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CharacterClassMapper {

    CharacterClass toNewCharacterClass(CharacterClassRequest characterClassRequest);

    CharacterClassResponse toCharacterClassResponse(CharacterClass characterClass);

    List<CharacterClassResponse> toCharacterClassResponseList(List<CharacterClass> characterClassList);
}
