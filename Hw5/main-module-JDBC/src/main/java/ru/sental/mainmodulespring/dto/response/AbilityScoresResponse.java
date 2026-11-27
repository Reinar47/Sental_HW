package ru.sental.mainmodulespring.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AbilityScoresResponse {

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
