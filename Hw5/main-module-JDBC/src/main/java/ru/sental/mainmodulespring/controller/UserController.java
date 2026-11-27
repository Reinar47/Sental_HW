package ru.sental.mainmodulespring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.sental.mainmodulespring.dto.request.UserAccountRequest;
import ru.sental.mainmodulespring.service.UserService;
import ru.sental.mainmodulespring.utils.Utils;

@Component
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final Utils utils;

    public String create(UserAccountRequest request) {

        return utils.toJson(userService.create(request));
    }

    public String getById(long id) {

        return utils.toJson(userService.getById(id));
    }

    public String findAll() {

        return utils.toJson(userService.findAll());
    }

    public String update(long id, UserAccountRequest request) {

        return utils.toJson(userService.update(id, request));
    }

    public String delete(long id) {
        userService.delete(id);
        return "{\"deleted\":true,\"id\":" + id + "}";
    }
}
