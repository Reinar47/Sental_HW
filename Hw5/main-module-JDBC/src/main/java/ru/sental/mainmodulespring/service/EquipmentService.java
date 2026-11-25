package ru.sental.mainmodulespring.service;

import ru.sental.mainmodulespring.dto.request.EquipmentRequest;
import ru.sental.mainmodulespring.dto.response.EquipmentResponse;
import ru.sental.mainmodulespring.dto.response.lists.EquipmentResponseList;

public interface EquipmentService {

    EquipmentResponse create(EquipmentRequest request);

    EquipmentResponse getById(long id);

    EquipmentResponseList findAll();

    EquipmentResponse update(long id, EquipmentRequest request);

    void delete(long id);
}
