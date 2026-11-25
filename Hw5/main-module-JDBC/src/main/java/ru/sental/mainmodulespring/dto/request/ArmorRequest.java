package ru.sental.mainmodulespring.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.sental.mainmodulespring.constant.ArmorClass;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArmorRequest {

    private String armorName;

    private String armorClass;

    private int armorWeightLbs;

    private String armorDescription;

    private Boolean armorEquipped;
}
