package ru.sental.mainmodulespring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sental.mainmodulespring.constant.ArmorClass;
import ru.sental.mainmodulespring.dto.request.ArmorRequest;
import ru.sental.mainmodulespring.dto.response.ArmorResponse;
import ru.sental.mainmodulespring.dto.response.lists.ArmorResponseList;
import ru.sental.mainmodulespring.entity.Armor;
import ru.sental.mainmodulespring.exception.ResourceNotFoundException;
import ru.sental.mainmodulespring.mapper.ArmorMapper;
import ru.sental.mainmodulespring.repository.ArmorRepository;
import ru.sental.mainmodulespring.service.ArmorService;
import ru.sental.mainmodulespring.utils.FindAndCheckService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ArmorServiceImpl implements ArmorService {

    private final ArmorRepository armorRepository;
    private final ArmorMapper armorMapper;
    private final FindAndCheckService findAndCheckService;

    @Override
    public ArmorResponse create(ArmorRequest request) {

        Armor armor = armorMapper.toNewArmor(request);
        armorRepository.save(armor);

        return armorMapper.toArmorResponse(armor);
    }

    @Override
    public ArmorResponse getById(long id) {
        Armor armor = findAndCheckService.findAndCheckArmor(id);

        return armorMapper.toArmorResponse(armor);
    }

    @Override
    public ArmorResponseList findAll() {

        List<Armor> armors = armorRepository.findAll();

        List<ArmorResponse> armorResponseList = armorMapper.toArmorResponseList(armors);

        return new ArmorResponseList(armorResponseList);
    }

    @Override
    public ArmorResponse update(long id, ArmorRequest request) {

        Armor existingArmor = findAndCheckService.findAndCheckArmor(id);

        existingArmor.setArmorName(request.getArmorName());
        existingArmor.setArmorClass(ArmorClass.valueOf(request.getArmorClass().toUpperCase()));
        existingArmor.setArmorWeightLbs(request.getArmorWeightLbs());
        existingArmor.setArmorDescription(request.getArmorDescription());

        armorRepository.save(existingArmor);

        return armorMapper.toArmorResponse(existingArmor);
    }

    @Override
    public void delete(long id) {
        Armor existingArmor = findAndCheckService.findAndCheckArmor(id);
        armorRepository.delete(existingArmor.getArmorId());
    }
}
