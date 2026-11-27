package ru.sental.mainmodulespring.service;

import ru.sental.mainmodulespring.dto.request.WeaponRequest;
import ru.sental.mainmodulespring.dto.response.WeaponResponse;
import ru.sental.mainmodulespring.dto.response.lists.WeaponResponseList;

public interface WeaponService {

    WeaponResponse create(WeaponRequest request);

    WeaponResponse getById(long id);

    WeaponResponseList findAll();

    WeaponResponse update(long id, WeaponRequest request);

    void delete(long id);
}
