package ru.sental.mainmodulespring.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.sental.mainmodulespring.constant.MonsterType;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Monster {

    private long monsterId;

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

    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<UserAccount> userAccounts = new ArrayList<>();

}
