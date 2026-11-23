package ru.sental.mainmodulespring.service;

import ru.sental.mainmodulespring.dto.request.UserAccountRequest;
import ru.sental.mainmodulespring.dto.response.UserAccountResponse;
import ru.sental.mainmodulespring.dto.response.lists.UserAccountResponseList;

public interface UserService {

    UserAccountResponse create(UserAccountRequest request);

    UserAccountResponse getById(long id);

    UserAccountResponseList findAll();

    UserAccountResponse update(long id, UserAccountRequest request);

    void delete(long id);
}
