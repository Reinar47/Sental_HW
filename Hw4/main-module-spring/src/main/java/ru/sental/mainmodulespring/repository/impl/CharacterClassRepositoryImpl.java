package ru.sental.mainmodulespring.repository.impl;

import org.springframework.stereotype.Repository;
import ru.sental.mainmodulespring.entity.CharacterClass;
import ru.sental.mainmodulespring.repository.CharacterClassRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static ru.sental.mainmodulespring.mockBd.MockBbTables.characterClassMocTable;

@Repository
public class CharacterClassRepositoryImpl implements CharacterClassRepository {

    @Override
    public CharacterClass save(CharacterClass characterClass) {

        Objects.requireNonNull(characterClass, "characterClass must not be null");

        characterClassMocTable.insert(characterClass.getClassId(), characterClass);

        return characterClass;
    }

    @Override
    public List<CharacterClass> findAll() {
        return characterClassMocTable.getAll();
    }

    @Override
    public Optional<CharacterClass> findById(long id) {
        return Optional.ofNullable(characterClassMocTable.get(id));
    }

    @Override
    public void delete(long id) {
        characterClassMocTable.delete(id);
    }

    @Override
    public boolean existsById(long id) {
        return characterClassMocTable.existsById(id);
    }
}
