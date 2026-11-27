package ru.sental.mainmodulespring.dto.response;

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
public class WeaponResponse {

    private long weaponId;

    private String weaponName;

    private WeaponDmg weaponDamage;

    private WeaponBonus weaponBonus;

    private WeaponType weaponType;

    private String weaponDescription;

    private Boolean weaponEquipped;

    private int weaponRangeFt;

    private int weaponWeightLbs;
}
