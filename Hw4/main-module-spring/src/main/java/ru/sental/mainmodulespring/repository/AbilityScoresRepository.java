package ru.sental.mainmodulespring.repository;

import ru.sental.mainmodulespring.entity.AbilityScores;

import java.util.List;
import java.util.Optional;

public interface AbilityScoresRepository {

    AbilityScores save(AbilityScores abilityScores);

    List<AbilityScores> findAll();

    Optional<AbilityScores> findById(long id);

    void delete(long id);

    boolean existsById(long id);
}
