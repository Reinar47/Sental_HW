package ru.sental.mainmodulespring.repository.impl;

import org.springframework.stereotype.Repository;
import ru.sental.mainmodulespring.entity.AbilityScores;
import ru.sental.mainmodulespring.repository.AbilityScoresRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static ru.sental.mainmodulespring.mockBd.MockBbTables.abilityScoresMocTable;

@Repository
public class AbilityScoresRepositoryImpl implements AbilityScoresRepository {

    @Override
    public AbilityScores save(AbilityScores abilityScores) {

        Objects.requireNonNull(abilityScores, "abilityScores must not be null");

        abilityScoresMocTable.insert(abilityScores.getAbilityScoresId(), abilityScores);

        return abilityScores;
    }

    @Override
    public List<AbilityScores> findAll() {
        return abilityScoresMocTable.getAll();
    }

    @Override
    public Optional<AbilityScores> findById(long id) {
        return Optional.ofNullable(abilityScoresMocTable.get(id));
    }

    @Override
    public void delete(long id) {
        abilityScoresMocTable.delete(id);
    }

    @Override
    public boolean existsById(long id) {
        return abilityScoresMocTable.existsById(id);
    }
}
