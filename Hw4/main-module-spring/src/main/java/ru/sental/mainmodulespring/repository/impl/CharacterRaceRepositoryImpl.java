package ru.sental.mainmodulespring.repository.impl;

import org.springframework.stereotype.Repository;
import ru.sental.mainmodulespring.entity.CharacterRace;
import ru.sental.mainmodulespring.repository.CharacterRaceRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static ru.sental.mainmodulespring.mockBd.MockBbTables.characterRaceMocTable;

@Repository
public class CharacterRaceRepositoryImpl implements CharacterRaceRepository {

    @Override
    public CharacterRace save(CharacterRace characterRace) {

        Objects.requireNonNull(characterRace, "characterRace must not be null");

        characterRaceMocTable.insert(characterRace.getRaceId(), characterRace);

        return characterRace;
    }

    @Override
    public List<CharacterRace> findAll() {
        return characterRaceMocTable.getAll();
    }

    @Override
    public Optional<CharacterRace> findById(long id) {
        return Optional.ofNullable(characterRaceMocTable.get(id));
    }

    @Override
    public void delete(long id) {
        characterRaceMocTable.delete(id);
    }

    @Override
    public boolean existsById(long id) {
        return characterRaceMocTable.existsById(id);
    }
}
