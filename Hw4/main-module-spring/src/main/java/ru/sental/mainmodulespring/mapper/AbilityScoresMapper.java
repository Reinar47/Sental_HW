package ru.sental.mainmodulespring.mapper;

import org.mapstruct.Mapper;
import ru.sental.mainmodulespring.annotation.DefaultCharacterAbilityScores;
import ru.sental.mainmodulespring.dto.request.AbilityScoresRequest;
import ru.sental.mainmodulespring.dto.response.AbilityScoresResponse;
import ru.sental.mainmodulespring.entity.AbilityScores;

@Mapper(componentModel = "spring")
public interface AbilityScoresMapper {

    @DefaultCharacterAbilityScores
    AbilityScores defaultAbilityScores (AbilityScoresRequest abilityScoresRequest);

    AbilityScores updateAbilityScores (AbilityScoresRequest abilityScoresRequest);

    AbilityScoresResponse toAbilityScoresResponse(AbilityScores abilityScores);

}
