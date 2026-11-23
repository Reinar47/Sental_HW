package ru.sental.mainmodulespring.repository.impl;

import org.springframework.stereotype.Repository;
import ru.sental.mainmodulespring.entity.Equipment;
import ru.sental.mainmodulespring.repository.EquipmentRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static ru.sental.mainmodulespring.mockBd.MockBbTables.equipmentMocTable;

@Repository
public class EquipmentRepositoryImpl implements EquipmentRepository {

    @Override
    public Equipment save(Equipment equipment) {

        Objects.requireNonNull(equipment, "equipment must not be null");

        equipmentMocTable.insert(equipment.getEquipmentId(), equipment);

        return equipment;
    }

    @Override
    public List<Equipment> findAll() {
        return equipmentMocTable.getAll();
    }

    @Override
    public Optional<Equipment> findById(long id) {
        return Optional.ofNullable(equipmentMocTable.get(id));
    }

    @Override
    public void delete(long id) {
        equipmentMocTable.delete(id);
    }

    @Override
    public boolean existsById(long id) {
        return equipmentMocTable.existsById(id);
    }
}
