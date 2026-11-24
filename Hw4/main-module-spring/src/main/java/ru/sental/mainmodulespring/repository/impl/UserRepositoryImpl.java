package ru.sental.mainmodulespring.repository.impl;

import org.springframework.stereotype.Repository;
import ru.sental.mainmodulespring.entity.UserAccount;
import ru.sental.mainmodulespring.repository.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static ru.sental.mainmodulespring.mockBd.MockBbTables.userAccountMocTable;

@Repository
public class UserRepositoryImpl implements UserRepository {


    @Override
    public UserAccount save(UserAccount userAccount) {

        Objects.requireNonNull(userAccount, "userAccount must not be null");

        userAccountMocTable.insert(userAccount.getId(), userAccount);

        return userAccount;
    }

    @Override
    public List<UserAccount> findAll() {
        return userAccountMocTable.getAll();
    }

    @Override
    public Optional<UserAccount> findById(long id) {
        return Optional.ofNullable(userAccountMocTable.get(id));
    }

    @Override
    public void delete(long id) {
        userAccountMocTable.delete(id);
    }

    @Override
    public boolean existsById(long id) {

        return userAccountMocTable.existsById(id);
    }
}