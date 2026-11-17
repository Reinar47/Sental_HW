package ru.sental.di.demo;

import ru.sental.di.annotation.Autowired;
import ru.sental.di.annotation.Component;

@Component
public class ConstructorInjectedBean {

    private final GreetingService greetingService;

    @Autowired
    public ConstructorInjectedBean(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String run() {

        return "Constructor: " + greetingService.greet();
    }
}