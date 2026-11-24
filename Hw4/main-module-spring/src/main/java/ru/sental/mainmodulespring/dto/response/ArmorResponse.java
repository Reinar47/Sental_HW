package ru.sental.mainmodulespring.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.sental.mainmodulespring.constant.ArmorClass;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArmorResponse {

    private long armorId;

    private String armorName;

    private ArmorClass armorClass;

    private int armorWeightLbs;

    private String armorDescription;

    private Boolean armorEquipped;
}
