package ru.sental.mainmodulespring.repository.impl;

import org.springframework.stereotype.Repository;
import ru.sental.mainmodulespring.entity.Monster;
import ru.sental.mainmodulespring.repository.MonsterRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static ru.sental.mainmodulespring.mockBd.MockBbTables.monsterMocTable;

@Repository
public class MonsterRepositoryImpl implements MonsterRepository {

    @Override
    public Monster save(Monster monster) {

        Objects.requireNonNull(monster, "monster must not be null");

        monsterMocTable.insert(monster.getId(), monster);

        return monster;
    }

    @Override
    public List<Monster> findAll() {
        return monsterMocTable.getAll();
    }

    @Override
    public Optional<Monster> findById(long id) {
        return Optional.ofNullable(monsterMocTable.get(id));
    }

    @Override
    public void delete(long id) {
        monsterMocTable.delete(id);
    }

    @Override
    public boolean existsById(long id) {
        return monsterMocTable.existsById(id);
    }
}
