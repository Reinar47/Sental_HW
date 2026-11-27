package ru.sental.mainmodulespring.service;

import ru.sental.mainmodulespring.dto.request.CharacterRaceRequest;
import ru.sental.mainmodulespring.dto.response.CharacterRaceResponse;
import ru.sental.mainmodulespring.dto.response.lists.CharacterRaceResponseList;

public interface CharacterRaceService {

    CharacterRaceResponse create(CharacterRaceRequest request);

    CharacterRaceResponse getById(long id);

    CharacterRaceResponseList findAll();

    CharacterRaceResponse update(long id, CharacterRaceRequest request);

    void delete(long id);
}
