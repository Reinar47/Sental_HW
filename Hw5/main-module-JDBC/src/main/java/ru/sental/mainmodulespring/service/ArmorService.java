package ru.sental.mainmodulespring.service;

import ru.sental.mainmodulespring.dto.request.ArmorRequest;
import ru.sental.mainmodulespring.dto.response.ArmorResponse;
import ru.sental.mainmodulespring.dto.response.lists.ArmorResponseList;

public interface ArmorService {

    ArmorResponse create(ArmorRequest request);

    ArmorResponse getById(long id);

    ArmorResponseList findAll();

    ArmorResponse update(long id, ArmorRequest request);

    void delete(long id);
}
