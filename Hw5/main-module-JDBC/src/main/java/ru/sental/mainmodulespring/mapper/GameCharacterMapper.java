package ru.sental.mainmodulespring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.sental.mainmodulespring.dto.request.GameCharacterRequest;
import ru.sental.mainmodulespring.dto.response.GameCharacterResponse;
import ru.sental.mainmodulespring.entity.GameCharacter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GameCharacterMapper {

    @Mapping(target = "characterDeleted", constant = "false")
    GameCharacter toNewGameCharacter(GameCharacterRequest gameCharacterRequest);

    GameCharacterResponse toGameCharacterResponse(GameCharacter gameCharacter);

    List<GameCharacterResponse> toGameCharacterResponseList(List<GameCharacter> gameCharacterList);

}
