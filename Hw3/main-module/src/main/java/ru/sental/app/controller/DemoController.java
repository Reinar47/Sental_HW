package ru.sental.app.controller;

import ru.sental.di.annotation.Autowired;
import ru.sental.di.annotation.Component;
import ru.sental.app.service.ServiceInterface;

import java.util.Objects;

@Component
public class DemoController {

    private final ServiceInterface service;

    @Autowired
    public DemoController(ServiceInterface service) {
        this.service = Objects.requireNonNull(service, "service must not be null");
    }

    public String execute() {
        return Objects.requireNonNull(service.execute(), "service.execute() returned null");
    }
}


