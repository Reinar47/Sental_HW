package ru.sental.mainmodulespring.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.sental.mainmodulespring.constant.MonsterType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MonsterResponse {

    private long id;

    private String monsterName;

    private MonsterType monsterType;

    private String monsterDescription;

    private int monsterStrength;

    private int monsterDexterity;

    private int monsterConstitution;

    private int monsterIntelligence;

    private int monsterWisdom;

    private int monsterCharisma;

    private boolean monsterDeleted;
}
