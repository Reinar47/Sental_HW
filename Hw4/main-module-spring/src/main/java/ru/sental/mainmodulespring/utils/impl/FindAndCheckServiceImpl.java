package ru.sental.mainmodulespring.utils.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.sental.mainmodulespring.entity.Armor;
import ru.sental.mainmodulespring.entity.CharacterClass;
import ru.sental.mainmodulespring.entity.CharacterRace;
import ru.sental.mainmodulespring.entity.Equipment;
import ru.sental.mainmodulespring.entity.GameCharacter;
import ru.sental.mainmodulespring.entity.Monster;
import ru.sental.mainmodulespring.entity.UserAccount;
import ru.sental.mainmodulespring.entity.Weapon;
import ru.sental.mainmodulespring.exception.ResourceNotFoundException;
import ru.sental.mainmodulespring.repository.ArmorRepository;
import ru.sental.mainmodulespring.repository.CharacterClassRepository;
import ru.sental.mainmodulespring.repository.CharacterRaceRepository;
import ru.sental.mainmodulespring.repository.EquipmentRepository;
import ru.sental.mainmodulespring.repository.GameCharacterRepository;
import ru.sental.mainmodulespring.repository.MonsterRepository;
import ru.sental.mainmodulespring.repository.UserRepository;
import ru.sental.mainmodulespring.repository.WeaponRepository;
import ru.sental.mainmodulespring.utils.FindAndCheckService;

@Component
@RequiredArgsConstructor
public class FindAndCheckServiceImpl implements FindAndCheckService {

    private final UserRepository userRepository;
    private final GameCharacterRepository gameCharacterRepository;
    private final ArmorRepository armorRepository;
    private final CharacterClassRepository characterClassRepository;
    private final CharacterRaceRepository characterRaceRepository;
    private final EquipmentRepository equipmentRepository;
    private final MonsterRepository monsterRepository;
    private final WeaponRepository weaponRepository;


    @Override
    public UserAccount findAndCheckUser(long userId) {

        UserAccount userAccount = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + userId));

        return userAccount;
    }

    @Override
    public GameCharacter findAndCheckGameCharacter(long characterId) {

        GameCharacter gameCharacter = gameCharacterRepository.findById(characterId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + characterId));

        return gameCharacter;
    }

    @Override
    public Armor findAndCheckArmor(long armorId) {

        Armor armor = armorRepository.findById(armorId)
                .orElseThrow(() -> new ResourceNotFoundException("Armor not found: " + armorId));

        return armor;
    }

    @Override
    public CharacterClass findAndCheckCharacterClass(long classId) {

        CharacterClass characterClass = characterClassRepository.findById(classId)
                .orElseThrow(() -> new ResourceNotFoundException("CharacterClass not found: " + classId));

        return characterClass;
    }

    @Override
    public CharacterRace findAndCheckCharacterRace(long raceId) {

        CharacterRace characterRace = characterRaceRepository.findById(raceId)
                .orElseThrow(() -> new ResourceNotFoundException("CharacterRace not found: " + raceId));

        return characterRace;
    }

    @Override
    public Equipment findAndCheckEquipment(long equipmentId) {

        Equipment equipment = equipmentRepository.findById(equipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Equipment not found: " + equipmentId));

        return equipment;
    }

    @Override
    public Monster findAndCheckMonster(long monsterId) {

        Monster monster = monsterRepository.findById(monsterId)
                .orElseThrow(() -> new ResourceNotFoundException("Monster not found: " + monsterId));

        return monster;
    }

    @Override
    public Weapon findAndCheckWeapon(long weaponId) {

        Weapon weapon = weaponRepository.findById(weaponId)
                .orElseThrow(() -> new ResourceNotFoundException("Weapon not found: " + weaponId));

        return weapon;
    }

}
