package ru.sental.mainmodulespring.service;

import ru.sental.mainmodulespring.dto.request.CharacterClassRequest;
import ru.sental.mainmodulespring.dto.response.CharacterClassResponse;
import ru.sental.mainmodulespring.dto.response.lists.CharacterClassResponseList;

public interface CharacterClassService {

    CharacterClassResponse create(CharacterClassRequest request);

    CharacterClassResponse getById(long id);

    CharacterClassResponseList findAll();

    CharacterClassResponse update(long id, CharacterClassRequest request);

    void delete(long id);
}
