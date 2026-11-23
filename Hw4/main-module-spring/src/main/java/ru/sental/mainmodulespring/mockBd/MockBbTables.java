package ru.sental.mainmodulespring.mockBd;

import ru.sental.mainmodulespring.entity.AbilityScores;
import ru.sental.mainmodulespring.entity.Armor;
import ru.sental.mainmodulespring.entity.CharacterClass;
import ru.sental.mainmodulespring.entity.CharacterRace;
import ru.sental.mainmodulespring.entity.Equipment;
import ru.sental.mainmodulespring.entity.GameCharacter;
import ru.sental.mainmodulespring.entity.Monster;
import ru.sental.mainmodulespring.entity.UserAccount;
import ru.sental.mainmodulespring.entity.Weapon;

import java.util.HashMap;

public class MockBbTables {

    public static BdUtils<Long, AbilityScores> abilityScoresMocTable = new BdUtils<>(new HashMap<>());
    public static BdUtils<Long, Armor> armorMocTable = new BdUtils<>(new HashMap<>());
    public static BdUtils<Long, CharacterClass> characterClassMocTable = new BdUtils<>(new HashMap<>());
    public static BdUtils<Long, CharacterRace> characterRaceMocTable = new BdUtils<>(new HashMap<>());
    public static BdUtils<Long, Equipment> equipmentMocTable = new BdUtils<>(new HashMap<>());
    public static BdUtils<Long, GameCharacter> gameCharacterMocTable = new BdUtils<>(new HashMap<>());
    public static BdUtils<Long, Monster> monsterMocTable = new BdUtils<>(new HashMap<>());
    public static BdUtils<Long, UserAccount> userAccountMocTable = new BdUtils<>(new HashMap<>());
    public static BdUtils<Long, Weapon> weaponMocTable = new BdUtils<>(new HashMap<>());

}
