package ru.sental.mainmodulespring.service;

import ru.sental.mainmodulespring.dto.request.GameCharacterRequest;
import ru.sental.mainmodulespring.dto.response.GameCharacterResponse;

public interface GameCharacterService {

    GameCharacterResponse createGameCharacter(GameCharacterRequest gameCharacterRequest);

    GameCharacterResponse GameCharacterGetById(long characterId);

    GameCharacterResponse updateGameCharacter(long characterId, GameCharacterRequest request);

    void deleteGameCharacter(long characterId);
}
