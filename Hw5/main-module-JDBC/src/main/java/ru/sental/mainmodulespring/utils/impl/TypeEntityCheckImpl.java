package ru.sental.mainmodulespring.utils.impl;

import org.springframework.stereotype.Component;
import ru.sental.mainmodulespring.constant.UserRole;
import ru.sental.mainmodulespring.dto.request.UserAccountRequest;
import ru.sental.mainmodulespring.entity.UserAccount;
import ru.sental.mainmodulespring.exception.WrongTypeException;
import ru.sental.mainmodulespring.utils.TypeEntityCheck;

/**
 * Пока тут только один метод, но впоследствии класс будет наполнятся проверками типов других сущностей
 */
@Component
public class TypeEntityCheckImpl implements TypeEntityCheck {

    @Override
    public UserRole checkUserRole(UserAccountRequest userAccountRequest, UserAccount existingUser) {
        if (userAccountRequest.getUserRole() == null) {

            return existingUser.getUserRole();
        }
        if (!userAccountRequest.getUserRole().equalsIgnoreCase("PLAYER") &&
                !userAccountRequest.getUserRole().equalsIgnoreCase("GAME_MASTER")) {

            throw new WrongTypeException("Wrong type of user role, user role must be PLAYER or GAME_MASTER");
        }
        String role = userAccountRequest.getUserRole();

        return UserRole.valueOf(role);
    }
}
