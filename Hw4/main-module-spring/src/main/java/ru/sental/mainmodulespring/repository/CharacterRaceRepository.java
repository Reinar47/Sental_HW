package ru.sental.mainmodulespring.repository;

import ru.sental.mainmodulespring.entity.CharacterRace;

import java.util.List;
import java.util.Optional;

public interface CharacterRaceRepository {

    CharacterRace save(CharacterRace characterRace);

    List<CharacterRace> findAll();

    Optional<CharacterRace> findById(long id);

    void delete(long id);

    boolean existsById(long id);
}
