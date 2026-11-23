package ru.sental.mainmodulespring.mapper;

import org.mapstruct.Mapper;
import ru.sental.mainmodulespring.dto.request.EquipmentRequest;
import ru.sental.mainmodulespring.dto.response.EquipmentResponse;
import ru.sental.mainmodulespring.entity.Equipment;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EquipmentMapper {

    Equipment toNewEquipment(EquipmentRequest equipmentRequest);

    List<Equipment> toEquipmentList(List<EquipmentRequest> equipmentRequestList);

    EquipmentResponse toEquipmentResponse(Equipment equipment);

    List<EquipmentResponse> toEquipmentResponseList(List<Equipment> equipmentList);
}
