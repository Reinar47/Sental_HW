package ru.sental.mainmodulespring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sental.mainmodulespring.dto.request.EquipmentRequest;
import ru.sental.mainmodulespring.dto.response.EquipmentResponse;
import ru.sental.mainmodulespring.dto.response.lists.EquipmentResponseList;
import ru.sental.mainmodulespring.entity.Equipment;
import ru.sental.mainmodulespring.exception.ResourceNotFoundException;
import ru.sental.mainmodulespring.mapper.EquipmentMapper;
import ru.sental.mainmodulespring.repository.EquipmentRepository;
import ru.sental.mainmodulespring.service.EquipmentService;
import ru.sental.mainmodulespring.utils.FindAndCheckService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentMapper equipmentMapper;
    private final FindAndCheckService findAndCheckService;

    @Override
    public EquipmentResponse create(EquipmentRequest request) {

        Equipment equipment = equipmentMapper.toNewEquipment(request);
        equipmentRepository.save(equipment);

        return equipmentMapper.toEquipmentResponse(equipment);
    }

    @Override
    public EquipmentResponse getById(long id) {

        Equipment equipment = findAndCheckService.findAndCheckEquipment(id);

        return equipmentMapper.toEquipmentResponse(equipment);
    }

    @Override
    public EquipmentResponseList findAll() {

        List<Equipment> equipments = equipmentRepository.findAll();

        List<EquipmentResponse> equipmentResponseList = equipmentMapper.toEquipmentResponseList(equipments);

        return new EquipmentResponseList(equipmentResponseList);
    }

    @Override
    public EquipmentResponse update(long id, EquipmentRequest request) {

        Equipment existingEquipment = findAndCheckService.findAndCheckEquipment(id);

        existingEquipment.setEquipmentName(request.getEquipmentName());
        existingEquipment.setEquipmentDescription(request.getEquipmentDescription());
        existingEquipment.setEquipmentAmount(request.getEquipmentAmount());
        existingEquipment.setEquipmentType(request.getEquipmentType());

        equipmentRepository.save(existingEquipment);

        return equipmentMapper.toEquipmentResponse(existingEquipment);
    }

    @Override
    public void delete(long id) {

        Equipment equipment = findAndCheckService.findAndCheckEquipment(id);

        equipmentRepository.delete(equipment.getEquipmentId());
    }
}
