package ru.sental.mainmodulespring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sental.mainmodulespring.dto.request.CharacterClassRequest;
import ru.sental.mainmodulespring.dto.response.CharacterClassResponse;
import ru.sental.mainmodulespring.dto.response.lists.CharacterClassResponseList;
import ru.sental.mainmodulespring.entity.CharacterClass;
import ru.sental.mainmodulespring.exception.ResourceNotFoundException;
import ru.sental.mainmodulespring.mapper.CharacterClassMapper;
import ru.sental.mainmodulespring.repository.CharacterClassRepository;
import ru.sental.mainmodulespring.service.CharacterClassService;
import ru.sental.mainmodulespring.utils.FindAndCheckService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CharacterClassServiceImpl implements CharacterClassService {

    private final CharacterClassRepository characterClassRepository;
    private final CharacterClassMapper characterClassMapper;
    private final FindAndCheckService findAndCheckService;

    @Override
    public CharacterClassResponse create(CharacterClassRequest request) {

        CharacterClass characterClass = characterClassMapper.toNewCharacterClass(request);
        characterClassRepository.save(characterClass);

        return characterClassMapper.toCharacterClassResponse(characterClass);
    }

    @Override
    public CharacterClassResponse getById(long id) {

        CharacterClass characterClass = findAndCheckService.findAndCheckCharacterClass(id);

        return characterClassMapper.toCharacterClassResponse(characterClass);
    }

    @Override
    public CharacterClassResponseList findAll() {

        List<CharacterClass> characterClasses = characterClassRepository.findAll();

        List<CharacterClassResponse> characterClassResponseList = characterClassMapper.toCharacterClassResponseList(characterClasses);

        return new CharacterClassResponseList(characterClassResponseList);
    }

    @Override
    public CharacterClassResponse update(long id, CharacterClassRequest request) {

        CharacterClass existingCharacterClass = findAndCheckService.findAndCheckCharacterClass(id);

        existingCharacterClass.setClassName(request.getClassName());
        existingCharacterClass.setClassDescription(request.getClassDescription());

        characterClassRepository.save(existingCharacterClass);

        return characterClassMapper.toCharacterClassResponse(existingCharacterClass);
    }

    @Override
    public void delete(long id) {

        CharacterClass characterClass = findAndCheckService.findAndCheckCharacterClass(id);

        characterClassRepository.delete(characterClass.getClassId());
    }
}
