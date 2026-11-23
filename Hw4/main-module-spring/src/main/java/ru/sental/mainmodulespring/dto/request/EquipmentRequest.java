package ru.sental.mainmodulespring.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.sental.mainmodulespring.constant.EquipmentType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentRequest {

    private String equipmentName;

    private String equipmentDescription;

    private int equipmentAmount;

    private EquipmentType equipmentType;
}
