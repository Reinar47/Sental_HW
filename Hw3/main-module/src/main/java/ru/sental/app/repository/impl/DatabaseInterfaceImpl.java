package ru.sental.app.repository.impl;

import ru.sental.di.annotation.Autowired;
import ru.sental.di.annotation.Component;
import ru.sental.app.repository.DatabaseInterface;
import ru.sental.app.utils.ParametersHolder;

import java.util.Objects;

@Component
public class DatabaseInterfaceImpl implements DatabaseInterface {

    @Autowired
    private ParametersHolder parametersHolder;

    @Override
    public String execute() {
        if (parametersHolder == null) {
            throw new IllegalStateException(
                    "ParametersHolder dependency is not injected in " + getClass().getName());
        }
        return Objects.requireNonNull(
                parametersHolder.getSomeText(),
                "parametersHolder.getSomeText() returned null");
    }
}
