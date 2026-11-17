package ru.sental.di.demo;

import ru.sental.di.annotation.Autowired;
import ru.sental.di.annotation.Component;

@Component
public class FieldInjectedBean {

    @Autowired
    private GreetingService greetingService;

    public String run() {

        return "Field: " + greetingService.jpa();
    }
}
