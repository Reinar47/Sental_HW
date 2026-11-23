package ru.sental.mainmodulespring.repository;

import ru.sental.mainmodulespring.entity.CharacterClass;

import java.util.List;
import java.util.Optional;

public interface CharacterClassRepository {

    CharacterClass save(CharacterClass characterClass);

    List<CharacterClass> findAll();

    Optional<CharacterClass> findById(long id);

    void delete(long id);

    boolean existsById(long id);
}
