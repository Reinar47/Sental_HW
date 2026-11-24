package ru.sental.mainmodulespring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sental.mainmodulespring.constant.MonsterType;
import ru.sental.mainmodulespring.dto.request.MonsterRequest;
import ru.sental.mainmodulespring.dto.response.MonsterResponse;
import ru.sental.mainmodulespring.dto.response.lists.MonsterResponseList;
import ru.sental.mainmodulespring.entity.Monster;
import ru.sental.mainmodulespring.exception.ResourceNotFoundException;
import ru.sental.mainmodulespring.mapper.MonsterMapper;
import ru.sental.mainmodulespring.repository.MonsterRepository;
import ru.sental.mainmodulespring.service.MonsterService;
import ru.sental.mainmodulespring.utils.FindAndCheckService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MonsterServiceImpl implements MonsterService {

    private final MonsterRepository monsterRepository;
    private final MonsterMapper monsterMapper;
    private final FindAndCheckService findAndCheckService;

    @Override
    public MonsterResponse create(MonsterRequest request) {

        Monster monster = monsterMapper.toNewMonster(request);
        monsterRepository.save(monster);

        return monsterMapper.toMonsterResponse(monster);
    }

    @Override
    public MonsterResponse getById(long id) {

        Monster monster = findAndCheckService.findAndCheckMonster(id);

        return monsterMapper.toMonsterResponse(monster);
    }

    @Override
    public MonsterResponseList findAll() {

        List<Monster> monsters = monsterRepository.findAll();

        List<MonsterResponse> monsterResponseList = monsterMapper.toMonsterResponseList(monsters);

        return new MonsterResponseList(monsterResponseList);
    }

    @Override
    public MonsterResponse update(long id, MonsterRequest request) {

        Monster existingMonster = findAndCheckService.findAndCheckMonster(id);

        existingMonster.setMonsterName(request.getMonsterName());
        existingMonster.setMonsterType(MonsterType.valueOf(request.getMonsterType().toUpperCase()));
        existingMonster.setMonsterDescription(request.getMonsterDescription());
        existingMonster.setMonsterStrength(request.getMonsterStrength());
        existingMonster.setMonsterDexterity(request.getMonsterDexterity());
        existingMonster.setMonsterConstitution(request.getMonsterConstitution());
        existingMonster.setMonsterIntelligence(request.getMonsterIntelligence());
        existingMonster.setMonsterWisdom(request.getMonsterWisdom());
        existingMonster.setMonsterCharisma(request.getMonsterCharisma());

        monsterRepository.save(existingMonster);

        return monsterMapper.toMonsterResponse(existingMonster);
    }

    @Override
    public void delete(long id) {

        Monster monster = findAndCheckService.findAndCheckMonster(id);

        monsterRepository.delete(monster.getId());
    }
}
