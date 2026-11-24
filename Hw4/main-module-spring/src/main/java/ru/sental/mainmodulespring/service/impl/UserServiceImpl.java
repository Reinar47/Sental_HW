package ru.sental.mainmodulespring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sental.mainmodulespring.constant.UserRole;
import ru.sental.mainmodulespring.dto.request.UserAccountRequest;
import ru.sental.mainmodulespring.dto.response.UserAccountResponse;
import ru.sental.mainmodulespring.dto.response.lists.UserAccountResponseList;
import ru.sental.mainmodulespring.entity.UserAccount;
import ru.sental.mainmodulespring.exception.ResourceNotFoundException;
import ru.sental.mainmodulespring.mapper.UserAccountMapper;
import ru.sental.mainmodulespring.repository.UserRepository;
import ru.sental.mainmodulespring.service.UserService;
import ru.sental.mainmodulespring.utils.FindAndCheckService;
import ru.sental.mainmodulespring.utils.Utils;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserAccountMapper userAccountMapper;
    private final AtomicLong idSequence = new AtomicLong(1);
    private final FindAndCheckService findAndCheckService;

    @Override
    public UserAccountResponse create(UserAccountRequest request) {

        UserAccount userAccount = userAccountMapper.toUserAccountEntity(request);
        userAccount.setId(idSequence.getAndIncrement());
        userRepository.save(userAccount);

        return userAccountMapper.toUserAccountResponse(userAccount);
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
    public UserAccountResponse update(long id, UserAccountRequest request) {

        UserAccount existingUser = findAndCheckService.findAndCheckUser(id);

        existingUser.setNickName(request.getNickName());
        existingUser.setFirstName(request.getFirstName());
        existingUser.setLastName(request.getLastName());
        existingUser.setPassword(request.getPassword());
        existingUser.setUserRole(request.getUserRole() == null ?
                existingUser.getUserRole() : UserRole.valueOf(request.getUserRole().toUpperCase()));
        existingUser.setEmail(request.getEmail());

        userRepository.save(existingUser);

        return userAccountMapper.toUserAccountResponse(existingUser);
    }

    @Override
    public void delete(long id) {

        UserAccount user = findAndCheckService.findAndCheckUser(id);
        userRepository.delete(user.getId());
    }


}
