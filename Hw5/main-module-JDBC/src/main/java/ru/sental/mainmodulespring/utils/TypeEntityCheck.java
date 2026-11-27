package ru.sental.mainmodulespring.utils;

import ru.sental.mainmodulespring.constant.UserRole;
import ru.sental.mainmodulespring.dto.request.UserAccountRequest;
import ru.sental.mainmodulespring.entity.UserAccount;

public interface TypeEntityCheck {
    UserRole checkUserRole(UserAccountRequest userAccountRequest, UserAccount existingUser);
}
