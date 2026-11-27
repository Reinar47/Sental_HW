package ru.sental.mainmodulespring.service;

import ru.sental.mainmodulespring.dto.request.MonsterRequest;
import ru.sental.mainmodulespring.dto.response.MonsterResponse;
import ru.sental.mainmodulespring.dto.response.lists.MonsterResponseList;

public interface MonsterService {

    MonsterResponse create(MonsterRequest request);

    MonsterResponse getById(long id);

    MonsterResponseList findAll();

    MonsterResponse update(long id, MonsterRequest request);

    void delete(long id);
}
