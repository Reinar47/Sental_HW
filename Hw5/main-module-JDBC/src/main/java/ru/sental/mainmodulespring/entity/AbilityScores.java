package ru.sental.mainmodulespring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AbilityScores {

    private long abilityScoresId;

    private int abilityScorePoints;

    private int strengthValue;

    private int strengthModifier;

    private int dexterityValue;

    private int dexterityModifier;

    private int constitutionValue;

    private int constitutionModifier;

    private int intelligenceValue;

    private int intelligenceModifier;

    private int wisdomValue;

    private int wisdomModifier;

    private int charismaValue;

    private int charismaModifier;

}
