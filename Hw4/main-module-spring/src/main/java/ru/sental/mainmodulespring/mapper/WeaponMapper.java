package ru.sental.mainmodulespring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.sental.mainmodulespring.constant.WeaponDmg;
import ru.sental.mainmodulespring.dto.request.WeaponRequest;
import ru.sental.mainmodulespring.dto.response.WeaponResponse;
import ru.sental.mainmodulespring.entity.Weapon;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WeaponMapper {

    @Mapping(target = "weaponEquipped", constant = "false")
    Weapon toNewWeapon(WeaponRequest weaponRequest);

    List<Weapon> toWeaponList(List<WeaponRequest> weaponRequestList);

    WeaponResponse toWeaponResponse(Weapon weapon);

    List<WeaponResponse> toWeaponResponseList(List<Weapon> weaponList);
}
