package ru.sental.mainmodulespring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sental.mainmodulespring.dto.request.GameCharacterRequest;
import ru.sental.mainmodulespring.dto.response.GameCharacterResponse;
import ru.sental.mainmodulespring.dto.response.lists.GameCharacterResponseList;
import ru.sental.mainmodulespring.entity.GameCharacter;
import ru.sental.mainmodulespring.mapper.AbilityScoresMapper;
import ru.sental.mainmodulespring.mapper.ArmorMapper;
import ru.sental.mainmodulespring.mapper.CharacterClassMapper;
import ru.sental.mainmodulespring.mapper.CharacterRaceMapper;
import ru.sental.mainmodulespring.mapper.EquipmentMapper;
import ru.sental.mainmodulespring.mapper.GameCharacterMapper;
import ru.sental.mainmodulespring.mapper.WeaponMapper;
import ru.sental.mainmodulespring.repository.ArmorRepository;
import ru.sental.mainmodulespring.repository.CharacterClassRepository;
import ru.sental.mainmodulespring.repository.CharacterRaceRepository;
import ru.sental.mainmodulespring.repository.GameCharacterRepository;
import ru.sental.mainmodulespring.service.GameCharacterService;
import ru.sental.mainmodulespring.utils.FindAndCheckService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class GameCharacterServiceImpl implements GameCharacterService {

    private final GameCharacterRepository gameCharacterRepository;
    private final GameCharacterMapper gameCharacterMapper;
    private final AbilityScoresMapper abilityScoresMapper;
    private final CharacterRaceRepository characterRaceRepository;
    private final CharacterClassRepository characterClassRepository;
    private final ArmorRepository armorRepository;
    private final CharacterRaceMapper characterRaceMapper;
    private final CharacterClassMapper characterClassMapper;
    private final ArmorMapper armorMapper;
    private final EquipmentMapper equipmentMapper;
    private final WeaponMapper weaponMapper;
    private final FindAndCheckService findAndCheckService;

    private final AtomicLong idSequence = new AtomicLong(1);

    /**
     * Первая запись в БД CharacterRace, CharacterClass, Armor это заглушка с ID = 1 (Что бы не было null)
     */
    private static final long DEFAULT_DUMMY_ID = 1L;

    @Override
    public GameCharacterResponse createGameCharacter(GameCharacterRequest gameCharacterRequest) {

        GameCharacter gameCharacter = gameCharacterMapper.toNewGameCharacter(gameCharacterRequest);
        gameCharacter.setCharacterId(idSequence.getAndIncrement());
        gameCharacter.setAbilityScores(
                abilityScoresMapper.defaultAbilityScores(gameCharacterRequest.getAbilityScoresRequest()));
        gameCharacter.setCharacterRace(characterRaceRepository.findById(DEFAULT_DUMMY_ID).get());
        gameCharacter.setCharacterClass(characterClassRepository.findById(DEFAULT_DUMMY_ID).get());
        gameCharacter.setArmor(armorRepository.findById(DEFAULT_DUMMY_ID).get());
        gameCharacter.setEquipment(new ArrayList<>());
        gameCharacter.setWeapons(new ArrayList<>());
        gameCharacterRepository.save(gameCharacter);

        return gameCharacterMapper.toGameCharacterResponse(gameCharacter);

    }

    @Override
    public GameCharacterResponse GameCharacterGetById(long characterId) {

        GameCharacter gameCharacter = findAndCheckService.findAndCheckGameCharacter(characterId);

        return gameCharacterMapper.toGameCharacterResponse(gameCharacter);
    }

    public GameCharacterResponseList findAllGameCharacters() {

        List<GameCharacter> gameCharacters = gameCharacterRepository.findAll();
        List<GameCharacterResponse> gameCharacterResponseList =
                gameCharacterMapper.toGameCharacterResponseList(gameCharacters);

        return new GameCharacterResponseList(gameCharacterResponseList);
    }

    @Override
    public GameCharacterResponse updateGameCharacter(long characterId, GameCharacterRequest request) {

        GameCharacter existChar = findAndCheckService.findAndCheckGameCharacter(characterId);

        existChar.setCharacterName(request.getCharacterName());
        existChar.setExperience(request.getExperience());
        existChar.setHitPoints(request.getHitPoints());
        existChar.setMaxHitPoints(request.getMaxHitPoints());
        existChar.setLevel(request.getLevel());
        existChar.setCharacterDeleted(request.isCharacterDeleted());
        existChar.setAbilityScores(abilityScoresMapper.updateAbilityScores(request.getAbilityScoresRequest()));
        existChar.setCharacterRace(characterRaceMapper.toNewCharacterRace(request.getCharacterRaceRequest()));
        existChar.setCharacterClass(characterClassMapper.toNewCharacterClass(request.getCharacterClassRequest()));
        existChar.setArmor(armorMapper.toNewArmor(request.getArmorRequest()));
        existChar.setEquipment(equipmentMapper.toEquipmentList(request.getEquipmentRequestList()));
        existChar.setWeapons(weaponMapper.toWeaponList(request.getWeaponRequestList()));

        gameCharacterRepository.save(existChar);

        return gameCharacterMapper.toGameCharacterResponse(existChar);

    }

    @Override
    public void deleteGameCharacter(long characterId) {
        GameCharacter existChar = findAndCheckService.findAndCheckGameCharacter(characterId);

        gameCharacterRepository.delete(existChar.getCharacterId());
    }
}
