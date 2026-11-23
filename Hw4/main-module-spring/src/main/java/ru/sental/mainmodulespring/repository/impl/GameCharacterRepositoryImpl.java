package ru.sental.mainmodulespring.repository.impl;

import org.springframework.stereotype.Repository;
import ru.sental.mainmodulespring.entity.GameCharacter;
import ru.sental.mainmodulespring.repository.GameCharacterRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static ru.sental.mainmodulespring.mockBd.MockBbTables.gameCharacterMocTable;


@Repository
public class GameCharacterRepositoryImpl implements GameCharacterRepository {

    @Override
    public GameCharacter save(GameCharacter gameCharacter) {

        Objects.requireNonNull(gameCharacter, "gameCharacter must not be null");

        gameCharacterMocTable.insert(gameCharacter.getCharacterId(), gameCharacter);

        return gameCharacter;
    }

    @Override
    public List<GameCharacter> findAll() {

        return gameCharacterMocTable.getAll();
    }

    @Override
    public Optional<GameCharacter> findById(long id) {

        return Optional.ofNullable(gameCharacterMocTable.get(id));
    }

    @Override
    public void delete(long id) {
        gameCharacterMocTable.delete(id);
    }

    @Override
    public boolean existsById(long id) {

        return gameCharacterMocTable.existsById(id);
    }

}
