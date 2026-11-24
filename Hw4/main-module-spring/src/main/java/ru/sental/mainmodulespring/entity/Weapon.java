package ru.sental.mainmodulespring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.sental.mainmodulespring.constant.WeaponBonus;
import ru.sental.mainmodulespring.constant.WeaponDmg;
import ru.sental.mainmodulespring.constant.WeaponType;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Weapon {


    private long weaponId;

    private String weaponName;

    private WeaponDmg weaponDamage;

    private WeaponBonus weaponBonus;

    private WeaponType weaponType;

    private String weaponDescription;

    private Boolean weaponEquipped;

    private int weaponRangeFt;

    private int weaponWeightLbs;

    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<GameCharacter> gameCharacter = new ArrayList<>();
}
