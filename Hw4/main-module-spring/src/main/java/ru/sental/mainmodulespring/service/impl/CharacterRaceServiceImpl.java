package ru.sental.mainmodulespring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sental.mainmodulespring.dto.request.CharacterRaceRequest;
import ru.sental.mainmodulespring.dto.response.CharacterRaceResponse;
import ru.sental.mainmodulespring.dto.response.lists.CharacterRaceResponseList;
import ru.sental.mainmodulespring.entity.CharacterRace;
import ru.sental.mainmodulespring.exception.ResourceNotFoundException;
import ru.sental.mainmodulespring.mapper.CharacterRaceMapper;
import ru.sental.mainmodulespring.repository.CharacterRaceRepository;
import ru.sental.mainmodulespring.service.CharacterRaceService;
import ru.sental.mainmodulespring.utils.FindAndCheckService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CharacterRaceServiceImpl implements CharacterRaceService {

    private final CharacterRaceRepository characterRaceRepository;
    private final CharacterRaceMapper characterRaceMapper;
    private final FindAndCheckService findAndCheckService;

    @Override
    public CharacterRaceResponse create(CharacterRaceRequest request) {

        CharacterRace characterRace = characterRaceMapper.toNewCharacterRace(request);
        characterRaceRepository.save(characterRace);

        return characterRaceMapper.toCharacterRaceResponse(characterRace);
    }

    @Override
    public CharacterRaceResponse getById(long id) {

        CharacterRace characterRace = findAndCheckService.findAndCheckCharacterRace(id);

        return characterRaceMapper.toCharacterRaceResponse(characterRace);
    }

    @Override
    public CharacterRaceResponseList findAll() {

        List<CharacterRace> characterRaces = characterRaceRepository.findAll();

        List<CharacterRaceResponse> characterRaceResponseList = characterRaceMapper.toCharacterRaceResponseList(characterRaces);

        return new CharacterRaceResponseList(characterRaceResponseList);
    }

    @Override
    public CharacterRaceResponse update(long id, CharacterRaceRequest request) {

        CharacterRace existingCharacterRace = findAndCheckService.findAndCheckCharacterRace(id);

        existingCharacterRace.setRaceName(request.getRaceName());
        existingCharacterRace.setRaceDescription(request.getRaceDescription());

        characterRaceRepository.save(existingCharacterRace);

        return characterRaceMapper.toCharacterRaceResponse(existingCharacterRace);
    }

    @Override
    public void delete(long id) {

        CharacterRace characterRace = findAndCheckService.findAndCheckCharacterRace(id);

        characterRaceRepository.delete(characterRace.getRaceId());
    }
}
