package ru.sental.mainmodulespring.utils;

import ru.sental.mainmodulespring.entity.Armor;
import ru.sental.mainmodulespring.entity.CharacterClass;
import ru.sental.mainmodulespring.entity.CharacterRace;
import ru.sental.mainmodulespring.entity.Equipment;
import ru.sental.mainmodulespring.entity.GameCharacter;
import ru.sental.mainmodulespring.entity.Monster;
import ru.sental.mainmodulespring.entity.UserAccount;
import ru.sental.mainmodulespring.entity.Weapon;

public interface FindAndCheckService {
    UserAccount findAndCheckUser(long userId);

    GameCharacter findAndCheckGameCharacter(long characterId);

    Armor findAndCheckArmor(long armorId);

    CharacterClass findAndCheckCharacterClass(long classId);

    CharacterRace findAndCheckCharacterRace(long raceId);

    Equipment findAndCheckEquipment(long equipmentId);

    Monster findAndCheckMonster(long monsterId);

    Weapon findAndCheckWeapon(long weaponId);
}
