package ru.sental.mainmodulespring.annotation;

import org.mapstruct.Mapping;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Mapping(target = "abilityScorePoints", constant = "15")
@Mapping(target = "strengthValue", constant = "10")
@Mapping(target = "strengthModifier", constant = "0")
@Mapping(target = "dexterityValue", constant = "10")
@Mapping(target = "dexterityModifier", constant = "0")
@Mapping(target = "constitutionValue", constant = "10")
@Mapping(target = "constitutionModifier", constant = "0")
@Mapping(target = "intelligenceValue", constant = "10")
@Mapping(target = "intelligenceModifier", constant = "0")
@Mapping(target = "wisdomValue", constant = "10")
@Mapping(target = "wisdomModifier", constant = "0")
@Mapping(target = "charismaValue", constant = "10")
@Mapping(target = "charismaModifier", constant = "0")
public @interface DefaultCharacterAbilityScores {
}