package ru.sental.mainmodulespring.annotation;

import org.mapstruct.Mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Mapping(target = "monsterStrength", constant = "10")
@Mapping(target = "monsterDexterity", constant = "10")
@Mapping(target = "monsterConstitution", constant = "10")
@Mapping(target = "monsterIntelligence", constant = "10")
@Mapping(target = "monsterWisdom", constant = "10")
@Mapping(target = "monsterCharisma", constant = "10")
@Mapping(target = "monsterDeleted", constant = "false")
public @interface DefaultMonsterAbilityScores {
}
