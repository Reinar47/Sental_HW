package ru.sental.mainmodulespring.repository;

import ru.sental.mainmodulespring.entity.Weapon;

import java.util.List;
import java.util.Optional;

public interface WeaponRepository {

    Weapon save(Weapon weapon);

    List<Weapon> findAll();

    Optional<Weapon> findById(long id);

    void delete(long id);

    boolean existsById(long id);
}
