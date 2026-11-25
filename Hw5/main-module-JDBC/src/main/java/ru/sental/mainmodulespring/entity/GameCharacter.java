package ru.sental.mainmodulespring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"armor", "weapons", "userAccount","abilityScores","equipment"})
@EqualsAndHashCode(exclude = {"armor", "weapons", "userAccount","abilityScores","equipment"})
public class GameCharacter {


    private long characterId;

    private String characterName;

    private int experience;

    private int hitPoints;

    private int maxHitPoints;

    private int level;

    private boolean characterDeleted;

    private AbilityScores abilityScores;

    private CharacterRace characterRace;

    private CharacterClass characterClass;

    private Armor armor;

    private UserAccount userAccount;

    @Builder.Default
    private List<Equipment> equipment = new ArrayList<>();

    @Builder.Default
    private List<Weapon> weapons = new ArrayList<>();

}
