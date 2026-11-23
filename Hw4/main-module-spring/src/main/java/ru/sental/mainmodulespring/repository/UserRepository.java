package ru.sental.mainmodulespring.repository;

import ru.sental.mainmodulespring.entity.UserAccount;

import java.util.List;
import java.util.Optional;

import static ru.sental.mainmodulespring.mockBd.MockBbTables.userAccountMocTable;


public interface UserRepository {

    UserAccount save(UserAccount userAccount);

    List<UserAccount> findAll();

    Optional<UserAccount> findById(long id);

    void delete(long id);

    boolean existsById(long id);
}
