package ru.sental.mainmodulespring.repository.impl;

import org.springframework.stereotype.Repository;
import ru.sental.mainmodulespring.entity.Weapon;
import ru.sental.mainmodulespring.repository.WeaponRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static ru.sental.mainmodulespring.mockBd.MockBbTables.weaponMocTable;

@Repository
public class WeaponRepositoryImpl implements WeaponRepository {

    @Override
    public Weapon save(Weapon weapon) {

        Objects.requireNonNull(weapon, "weapon must not be null");

        weaponMocTable.insert(weapon.getWeaponId(), weapon);

        return weapon;
    }

    @Override
    public List<Weapon> findAll() {

        return weaponMocTable.getAll();
    }

    @Override
    public Optional<Weapon> findById(long id) {

        return Optional.ofNullable(weaponMocTable.get(id));
    }

    @Override
    public void delete(long id) {

        weaponMocTable.delete(id);
    }

    @Override
    public boolean existsById(long id) {

        return weaponMocTable.existsById(id);
    }
}
