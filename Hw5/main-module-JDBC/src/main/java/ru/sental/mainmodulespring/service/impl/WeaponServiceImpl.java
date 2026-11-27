package ru.sental.mainmodulespring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sental.mainmodulespring.constant.WeaponBonus;
import ru.sental.mainmodulespring.constant.WeaponDmg;
import ru.sental.mainmodulespring.constant.WeaponType;
import ru.sental.mainmodulespring.dto.request.WeaponRequest;
import ru.sental.mainmodulespring.dto.response.WeaponResponse;
import ru.sental.mainmodulespring.dto.response.lists.WeaponResponseList;
import ru.sental.mainmodulespring.entity.Weapon;
import ru.sental.mainmodulespring.exception.ResourceNotFoundException;
import ru.sental.mainmodulespring.mapper.WeaponMapper;
import ru.sental.mainmodulespring.repository.WeaponRepository;
import ru.sental.mainmodulespring.service.WeaponService;
import ru.sental.mainmodulespring.utils.FindAndCheckService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class WeaponServiceImpl implements WeaponService {

    private final WeaponRepository weaponRepository;
    private final WeaponMapper weaponMapper;
    private final FindAndCheckService findAndCheckService;

    @Override
    public WeaponResponse create(WeaponRequest request) {

        Weapon weapon = weaponMapper.toNewWeapon(request);
        weaponRepository.save(weapon);

        return weaponMapper.toWeaponResponse(weapon);
    }

    @Override
    public WeaponResponse getById(long id) {

        Weapon weapon = findAndCheckService.findAndCheckWeapon(id);

        return weaponMapper.toWeaponResponse(weapon);
    }

    @Override
    public WeaponResponseList findAll() {

        List<Weapon> weapons = weaponRepository.findAll();

        List<WeaponResponse> weaponResponseList = weaponMapper.toWeaponResponseList(weapons);

        return new WeaponResponseList(weaponResponseList);
    }

    @Override
    public WeaponResponse update(long id, WeaponRequest request) {

        Weapon existingWeapon = findAndCheckService.findAndCheckWeapon(id);

        existingWeapon.setWeaponName(request.getWeaponName());
        existingWeapon.setWeaponDamage(WeaponDmg.valueOf(request.getWeaponDamage().toUpperCase()));
        existingWeapon.setWeaponBonus(WeaponBonus.valueOf(request.getWeaponBonus().toUpperCase()));
        existingWeapon.setWeaponType(WeaponType.valueOf(request.getWeaponType().toLowerCase()));
        existingWeapon.setWeaponDescription(request.getWeaponDescription());
        existingWeapon.setWeaponRangeFt(request.getWeaponRangeFt());
        existingWeapon.setWeaponWeightLbs(request.getWeaponWeightLbs());

        weaponRepository.save(existingWeapon);

        return weaponMapper.toWeaponResponse(existingWeapon);
    }

    @Override
    public void delete(long id) {

        Weapon weapon = findAndCheckService.findAndCheckWeapon(id);

        weaponRepository.delete(weapon.getWeaponId());
    }
}
