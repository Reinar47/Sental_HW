package ru.sental.mainmodulespring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.sental.mainmodulespring.dto.request.ArmorRequest;
import ru.sental.mainmodulespring.dto.response.ArmorResponse;
import ru.sental.mainmodulespring.entity.Armor;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArmorMapper {

    @Mapping(target = "armorEquipped", constant = "false")
    Armor toNewArmor(ArmorRequest armorRequest);

    ArmorResponse toArmorResponse(Armor armor);

    List<ArmorResponse> toArmorResponseList(List<Armor> armorList);
}
