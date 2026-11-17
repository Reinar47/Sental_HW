package ru.sental.app.service.impl;

import ru.sental.di.annotation.Autowired;
import ru.sental.di.annotation.Component;
import ru.sental.app.repository.DatabaseInterface;
import ru.sental.app.service.ServiceInterface;

import java.util.Objects;

@Component
public class ServiceInterfaceImpl implements ServiceInterface {

    private DatabaseInterface database;

    @Autowired
    public void setDatabase(DatabaseInterface database) {
        this.database = Objects.requireNonNull(database, "database must not be null");
    }

    @Override
    public String execute() {
        if (database == null) {
            throw new IllegalStateException(
                    "Database dependency is not injected in " + getClass().getName());
        }
        return Objects.requireNonNull(database.execute(), "database.execute() returned null");
    }
}
