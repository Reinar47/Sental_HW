package ru.sental.mainmodulespring.repository;

import ru.sental.mainmodulespring.entity.Equipment;

import java.util.List;
import java.util.Optional;

public interface EquipmentRepository {

    Equipment save(Equipment equipment);

    List<Equipment> findAll();

    Optional<Equipment> findById(long id);

    void delete(long id);

    boolean existsById(long id);
}
