package ru.sental.mainmodulespring.repository;

import ru.sental.mainmodulespring.entity.GameCharacter;

import java.util.List;
import java.util.Optional;

public interface GameCharacterRepository {

    GameCharacter save(GameCharacter gameCharacter);

    List<GameCharacter> findAll();

    Optional<GameCharacter> findById(long id);

    void delete(long id);

    boolean existsById(long id);
}
