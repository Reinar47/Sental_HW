package ru.sental.mainmodulespring.repository.impl;

import org.springframework.stereotype.Repository;
import ru.sental.mainmodulespring.entity.Armor;
import ru.sental.mainmodulespring.repository.ArmorRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static ru.sental.mainmodulespring.mockBd.MockBbTables.armorMocTable;

@Repository
public class ArmorRepositoryImpl implements ArmorRepository {

    @Override
    public Armor save(Armor armor) {

        Objects.requireNonNull(armor, "armor must not be null");

        armorMocTable.insert(armor.getArmorId(), armor);

        return armor;
    }

    @Override
    public List<Armor> findAll() {
        return armorMocTable.getAll();
    }

    @Override
    public Optional<Armor> findById(long id) {
        return Optional.ofNullable(armorMocTable.get(id));
    }

    @Override
    public void delete(long id) {
        armorMocTable.delete(id);
    }

    @Override
    public boolean existsById(long id) {
        return armorMocTable.existsById(id);
    }
}
