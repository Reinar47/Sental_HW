package ru.sental.mainmodulespring.mapper;

import org.mapstruct.Mapper;
import ru.sental.mainmodulespring.annotation.DefaultMonsterAbilityScores;
import ru.sental.mainmodulespring.dto.request.MonsterRequest;
import ru.sental.mainmodulespring.dto.response.MonsterResponse;
import ru.sental.mainmodulespring.entity.Monster;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MonsterMapper {

    @DefaultMonsterAbilityScores
    Monster toNewMonster(MonsterRequest monsterRequest);

    MonsterResponse toMonsterResponse(Monster monster);

    List<MonsterResponse> toMonsterResponseList(List<Monster> monsterList);
}
