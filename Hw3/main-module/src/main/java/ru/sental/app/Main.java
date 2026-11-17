package ru.sental.app;

import ru.sental.app.controller.DemoController;
import ru.sental.di.IocContainer;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        IocContainer.init("ru.sental.app", "application.yml");

        DemoController controller = Objects.requireNonNull(
                IocContainer.getBean(DemoController.class),
                "DemoController bean is null");

        String result = Objects.requireNonNull(
                controller.execute(),
                "controller.execute() returned null");

        System.out.println(result);
    }
}
