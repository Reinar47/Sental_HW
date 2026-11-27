package ru.sental.mainmodulespring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sental.mainmodulespring.annotation.Transaction;
import ru.sental.mainmodulespring.dto.request.UserAccountRequest;
import ru.sental.mainmodulespring.dto.response.UserAccountResponse;
import ru.sental.mainmodulespring.dto.response.lists.UserAccountResponseList;
import ru.sental.mainmodulespring.entity.UserAccount;
import ru.sental.mainmodulespring.exception.EntityAlreadyExists;
import ru.sental.mainmodulespring.mapper.UserAccountMapper;
import ru.sental.mainmodulespring.repository.UserRepository;
import ru.sental.mainmodulespring.service.UserService;
import ru.sental.mainmodulespring.utils.FindAndCheckService;
import ru.sental.mainmodulespring.utils.TypeEntityCheck;

import java.util.List;

import static ru.sental.mainmodulespring.utils.messages.ExceptionMessages.THIS_ENTITY_ALREADY_EXISTS;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserAccountMapper userAccountMapper;
    private final FindAndCheckService findAndCheckService;
    private final TypeEntityCheck typeEntityCheck;

    @Override
    @Transaction
    public UserAccountResponse create(UserAccountRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new EntityAlreadyExists("User." + THIS_ENTITY_ALREADY_EXISTS + "email: " + request.getEmail());
        }

        UserAccount userAccount = userAccountMapper.toUserAccountEntity(request);

        UserAccount saved = userRepository.save(userAccount);

        return userAccountMapper.toUserAccountResponse(saved);
    }


    @Override
    public UserAccountResponse getById(long id) {

        UserAccount userAccount = findAndCheckService.findAndCheckUser(id);

        return userAccountMapper.toUserAccountResponse(userAccount);
    }

    @Override
    public UserAccountResponseList findAll() {

        List<UserAccount> userAccounts = userRepository.findAll();

        List<UserAccountResponse> userAccountResponseList = userAccountMapper.toUserAccountResponseList(userAccounts);

        return new UserAccountResponseList(userAccountResponseList);
    }

    @Override
    @Transaction
    public UserAccountResponse update(long id, UserAccountRequest request) {

        UserAccount existingUser = findAndCheckService.findAndCheckUser(id);

        existingUser.setNickName(request.getNickName());
        existingUser.setFirstName(request.getFirstName());
        existingUser.setLastName(request.getLastName());
        existingUser.setPassword(request.getPassword());
        existingUser.setUserRole(typeEntityCheck.checkUserRole(request, existingUser));
        existingUser.setEmail(request.getEmail());

        userRepository.save(existingUser);

        return userAccountMapper.toUserAccountResponse(existingUser);
    }

    @Override
    @Transaction
    public void delete(long id) {

        UserAccount user = findAndCheckService.findAndCheckUser(id);
        userRepository.delete(user.getUserId());
    }

}
