package ru.sental.di.demo;

import ru.sental.di.annotation.Component;
import ru.sental.di.annotation.Value;

@Component
public class AppConfig {

    @Value("app.port")
    private int port;

    @Value("db.url")
    private String dbUrl;

    @Value("feature.enabled")
    private boolean featureEnabled;

    public int getPort() {

        return port;
    }

    public String getDbUrl() {

        return dbUrl;
    }

    public boolean isFeatureEnabled() {

        return featureEnabled;
    }
}
