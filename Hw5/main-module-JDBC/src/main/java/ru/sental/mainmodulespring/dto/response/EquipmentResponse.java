package ru.sental.mainmodulespring.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.sental.mainmodulespring.constant.EquipmentType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentResponse {

    private long equipmentId;

    private String equipmentName;

    private String equipmentDescription;

    private int equipmentAmount;

    private EquipmentType equipmentType;
}
