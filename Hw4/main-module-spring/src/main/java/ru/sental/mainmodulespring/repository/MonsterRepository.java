package ru.sental.mainmodulespring.repository;

import ru.sental.mainmodulespring.entity.Monster;

import java.util.List;
import java.util.Optional;

public interface MonsterRepository {

    Monster save(Monster monster);

    List<Monster> findAll();

    Optional<Monster> findById(long id);

    void delete(long id);

    boolean existsById(long id);
}
