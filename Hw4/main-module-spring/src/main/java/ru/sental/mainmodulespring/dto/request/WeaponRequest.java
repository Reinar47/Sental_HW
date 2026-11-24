package ru.sental.mainmodulespring.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.sental.mainmodulespring.constant.WeaponBonus;
import ru.sental.mainmodulespring.constant.WeaponDmg;
import ru.sental.mainmodulespring.constant.WeaponType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeaponRequest {

    private String weaponName;

    private String weaponDamage;

    private String weaponBonus;

    private String weaponType;

    private String weaponDescription;

    private Boolean weaponEquipped;

    private int weaponRangeFt;

    private int weaponWeightLbs;
}
