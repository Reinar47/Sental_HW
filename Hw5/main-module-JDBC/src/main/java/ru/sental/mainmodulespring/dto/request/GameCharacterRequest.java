package ru.sental.mainmodulespring.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.sental.mainmodulespring.entity.Armor;
import ru.sental.mainmodulespring.entity.CharacterClass;
import ru.sental.mainmodulespring.entity.CharacterRace;
import ru.sental.mainmodulespring.entity.Equipment;
import ru.sental.mainmodulespring.entity.Weapon;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameCharacterRequest {

    private String characterName;

    private int experience;

    private int hitPoints;

    private int maxHitPoints;

    private int level;

    private boolean characterDeleted;

    private AbilityScoresRequest abilityScoresRequest;

    private CharacterRaceRequest characterRaceRequest;

    private CharacterClassRequest characterClassRequest;

    private ArmorRequest armorRequest;

    private List<EquipmentRequest> equipmentRequestList = new ArrayList<>();

    private List<WeaponRequest> weaponRequestList = new ArrayList<>();
    
}
