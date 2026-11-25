package ru.sental.mainmodulespring.repository;

import ru.sental.mainmodulespring.entity.Armor;

import java.util.List;
import java.util.Optional;

public interface ArmorRepository {

    Armor save(Armor armor);

    List<Armor> findAll();

    Optional<Armor> findById(long id);

    void delete(long id);

    boolean existsById(long id);
}
