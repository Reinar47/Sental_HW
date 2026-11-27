package ru.sental.mainmodulespring.mapper;

import org.mapstruct.Mapper;
import ru.sental.mainmodulespring.dto.request.CharacterRaceRequest;
import ru.sental.mainmodulespring.dto.response.CharacterRaceResponse;
import ru.sental.mainmodulespring.entity.CharacterRace;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CharacterRaceMapper {

    CharacterRace toNewCharacterRace(CharacterRaceRequest characterRaceRequest);

    CharacterRaceResponse toCharacterRaceResponse(CharacterRace characterRace);

    List<CharacterRaceResponse> toCharacterRaceResponseList(List<CharacterRace> characterRaceList);

}
